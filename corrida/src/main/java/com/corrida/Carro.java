package com.corrida;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import javafx.application.Platform;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;


public class Carro extends ImageView implements Runnable{
    private String carro;
    private int posicaox;
    private int posicaoy;
    private int posicaoInicialX; // Salva a posição inicial para o restart
    private volatile boolean rodando; // Flag para controlar se o carro deve continuar rodando
    private Thread carroThread;
    private static ImageView primeiroLugarImg;
    private static ImageView segundoLugarImg;
    private static ImageView terceiroLugarImg;
    private static ArrayList<Carro> carros = new ArrayList<>();
    
    public Carro(String carro, int posicaox, int posicaoy) {
        this.carro = carro;
        this.posicaox = posicaox;
        this.posicaoy = posicaoy;
        this.posicaoInicialX = posicaox;
        

        // Como Carro herda de ImageView, nós definimos a imagem e as dimensões nele mesmo
        this.setImage(new javafx.scene.image.Image(getClass().getResourceAsStream("/images/" + carro + ".png")));
        this.setFitWidth(100);
        this.setFitHeight(100);
        this.setLayoutX(posicaox);
        this.setLayoutY(posicaoy);
        
        this.carroThread = new Thread(this);
    }

    public Carro(){

    };
    
    public void run() {
        while (posicaox < 450 && rodando) {
            try {
                // Sorteia um tempo de pausa para o carro andar em velocidades diferentes
                Thread.sleep(new Random().nextInt(5) * 100 + 100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            // Aumenta a posição do carro
            posicaox += new Random().nextInt(3) * 20 + 10;
            
            if (posicaox > 450) {
                posicaox = 450; // Chegou na linha de chegada
            }

            // O JavaFX não permite mudar a interface a partir de uma Thread separada.
            // Precisamos usar o Platform.runLater para enviar a atualização para a Thread Principal da Tela.
            Platform.runLater(() -> {
                this.setLayoutX(posicaox);
                Carro.atualizarPosicoes(Carro.getCarros());
            });
        }
    }

    static void setPodiumImages(ImageView primeiro, ImageView segundo, ImageView terceiro) {
        primeiroLugarImg = primeiro;
        segundoLugarImg = segundo;
        terceiroLugarImg = terceiro;
    }

    static void addCarro(Carro  ...carro) {
        carros.addAll(Arrays.asList(carro));
    }
    static ArrayList<Carro> getCarros() {
        return carros;
    }

    static void atualizarPosicoes(ArrayList<Carro> carros) {
        carros.sort((c1, c2) -> Integer.compare(c2.posicaox, c1.posicaox));
        for (int i = 0; i < carros.size(); i++) {
            Carro carro = carros.get(i);
            switch (i) {
                case 0:
                    if (primeiroLugarImg != null) primeiroLugarImg.setImage(carro.getImage());
                    break;
                case 1:
                    if (segundoLugarImg != null) segundoLugarImg.setImage(carro.getImage());
                    break;
                case 2:
                    if (terceiroLugarImg != null) terceiroLugarImg.setImage(carro.getImage());
                    break;
            }
        }
    }

    static void iniciarCorrida() {
        if (carros.isEmpty()) return;

        // Avisa todas as threads antigas para pararem
        for (Carro carro : carros) {
            carro.rodando = false; 
        }

        // Aguarda um milissegundo para garantir que as threads antigas pararam e recria tudo
        for (Carro carro : carros) {
            carro.posicaox = carro.posicaoInicialX; // Reseta a posição
            carro.setLayoutX(carro.posicaoInicialX); // Move a imagem de volta para o início
            carro.rodando = true; // Permite rodar
            
            // Recria a thread (Threads no Java só podem dar .start() uma única vez na vida)
            carro.carroThread = new Thread(carro);
            carro.carroThread.start();
        }
    }
}


