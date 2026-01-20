package com.jdojo.exerciciosT3;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.scene.paint.Color;
import static javafx.stage.StageStyle.*;

public class Exercicio04_XestorEstilosStage extends Application {

    @Override
    public void start(Stage stage) {
        stage.setTitle("Xestor de estilos de Stage");

        // Botóns para cada estilo
        Button btnDecorated = new Button("DECORATED");
        Button btnUndecorated = new Button("UNDECORATED");
        Button btnTransparent = new Button("TRANSPARENT");
        Button btnUtility = new Button("UTILITY");
        Button btnUnified = new Button("UNIFIED");

        // Na acción dos botóns imos chamar ao método abrirVenta ao cal pasaremos o estilo 
        // e abrirá outra ventá con ese estilo.
        btnDecorated.setOnAction(e -> abrirVenta(DECORATED));
        btnUndecorated.setOnAction(e -> abrirVenta(UNDECORATED));
        btnTransparent.setOnAction(e -> abrirVenta(TRANSPARENT));
        btnUtility.setOnAction(e -> abrirVenta(UTILITY));
        btnUnified.setOnAction(e -> abrirVenta(UNIFIED));

        VBox root = new VBox(10, btnDecorated, btnUndecorated, btnTransparent, btnUtility, btnUnified);
        Scene scene = new Scene(root, 300, 250);

        stage.setScene(scene);
        stage.show();
    }

    // Método para abrir unha xanela secundaria segundo o estilo
    private void abrirVenta(StageStyle estilo) {
        Stage secundario = new Stage();
        // iniciamos o estilo antes de amosalo
        secundario.initStyle(estilo);

        Label lbl = new Label("Estilo: " + estilo.toString());
        Button btnPechar = new Button("Pechar");
        btnPechar.setOnAction(e -> secundario.close());

        VBox layout = new VBox(15, lbl, btnPechar);
        layout.setStyle("-fx-padding: 20; -fx-background-color: lightblue;");

        Scene escena;

        if (estilo == TRANSPARENT) {
            escena = new Scene(layout, 250, 150);
            escena.setFill(null);
            layout.setStyle("-fx-background-color: transparent");	
        } else if (estilo == UNIFIED) {
            escena = new Scene(layout, 250, 150);
            escena.setFill(Color.TRANSPARENT); // Fondo transparente
        } else {
            escena = new Scene(layout, 250, 150);
        }

        secundario.setScene(escena);
        secundario.setTitle("Xanela secundaria - " + estilo);
        secundario.show();
    }

    public static void main(String[] args) {
        launch();
    }
}

/*Exercicio 4 Xestor de estilos de Stage

Imos crear unha aplicación que permita ao usuario comprobar os diferentes estilos dun Stage abrindo xanelas secundarias desde unha xanela principal.
Instruccións:

A xanela principal debe ter 5 botóns, un por cada estilo de StageStyle:

    DECORATED
    UNDECORATED
    TRANSPARENT
    UTILITY
    UNIFIED

Ao premer un botón abrirase unha xanela secundaria co estilo correspondente.

Cada xanela secundaria debe conter:

    Unha etiqueta que mostre o estilo actual.
    Un botón "Pechar" que permita pechar a xanela.
    Se o estilo é TRANSPARENT, a escena debe ser transparente.
    Se o estilo é UNIFIED, a escena debe ter un fondo transparente, pero a xanela debe manter os controis de barra de título.
*/