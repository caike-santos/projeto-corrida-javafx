package com.corrida;

import javafx.scene.layout.*;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
public class Pista {
    private HBox Boxtitulo;
    private VBox layout;
    
    public Pista() {
    Boxtitulo = new HBox();
    Label titulo = new Label("Bem vindo a corrida de carros");
    
    Boxtitulo.getChildren().add(titulo);
    Boxtitulo.setSpacing(10);
    HBox.setHgrow(Boxtitulo, Priority.ALWAYS);
    Boxtitulo.alignmentProperty().set(javafx.geometry.Pos.TOP_CENTER);

    HBox posicao = new HBox();
    Label primeiro = new Label("1º");
    ImageView imgPrimeiro = new ImageView();
    imgPrimeiro.setFitWidth(50); imgPrimeiro.setFitHeight(50);
    Label segundo = new Label("2º");
    ImageView imgSegundo = new ImageView();
    imgSegundo.setFitWidth(50); imgSegundo.setFitHeight(50);
    Label terceiro = new Label("3º");
    ImageView imgTerceiro = new ImageView();
    imgTerceiro.setFitWidth(50); imgTerceiro.setFitHeight(50);
    Carro.setPodiumImages(imgPrimeiro, imgSegundo, imgTerceiro);
    posicao.setSpacing(10);
    posicao.getChildren().addAll(primeiro, imgPrimeiro, segundo, imgSegundo, terceiro, imgTerceiro);
    posicao.alignmentProperty().set(javafx.geometry.Pos.CENTER_LEFT);

    Pane pista = new Pane();
    pista.setMinWidth(300);
    pista.setMinHeight(300);
    pista.setMaxWidth(600);
    pista.setMaxHeight(300);
    ImageView pistaImageView = new ImageView(getClass().getResource("/images/pista.jpg").toExternalForm());
    pistaImageView.setFitWidth(600);
    pistaImageView.setFitHeight(300);
    Carro carro1 = new Carro("carro1", 10, 40);
    Carro carro2 = new Carro("carro2", 10, 100);
    Carro carro3 = new Carro("carro3", 10, 160);
    Carro.addCarro(carro1, carro2, carro3);
    carro1.setLayoutX(30);
    carro1.setLayoutY(40);
    carro2.setLayoutX(30);
    carro2.setLayoutY(100);
    carro3.setLayoutX(30);
    carro3.setLayoutY(160);
    pista.getChildren().addAll(pistaImageView, carro1, carro2, carro3);
    pista.setId("pista");

    HBox botaoBox = new HBox();
    Button botao = new Button("Iniciar Corrida");
    botaoBox.getChildren().add(botao);
    botao.setId("botao");
    botaoBox.alignmentProperty().set(javafx.geometry.Pos.CENTER);

    botao.setOnAction(e -> {
        Carro.iniciarCorrida();
    });

    layout = new VBox();
    layout.alignmentProperty().set(javafx.geometry.Pos.CENTER);
    layout.getChildren().addAll(Boxtitulo, posicao, pista, botaoBox);
    layout.setSpacing(10);
    }

public Scene exibirTela(){
    return new Scene(layout, 640, 480);
}
}
