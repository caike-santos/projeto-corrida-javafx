package com.corrida;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * JavaFX App
 */
public class App extends Application {

    private static Scene scene;

    @Override
    public void start(Stage stage) throws IOException {
        Pista pista = new Pista();
        scene = pista.exibirTela(); 
        String cssGlobal = App.class.getResource("/styles/style.css").toExternalForm();
            scene.getStylesheets().add(cssGlobal);
        stage.setScene(scene);
        stage.show();
    }

   

    public static void main(String[] args) {
        launch();
    }

}