// StageStyleApp.java
package com.jdojo.stage;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import static javafx.stage.StageStyle.*;

public class StageStyleApp extends Application {
    public static void main(String[] args) {
        Application.launch(args);
    }

    @Override
    public void start(Stage stage) {
        // Etiqueta para mostrar o estilo
        Label styleLabel = new Label("Stage Style");

        // Botón para pechar a xanela
        Button closeButton = new Button("Pechar");
        closeButton.setOnAction(e -> stage.close());

        VBox root = new VBox();
        root.getChildren().addAll(styleLabel, closeButton);

        Scene scene = new Scene(root, 150, 100);
        stage.setScene(scene);
        stage.setTitle("Exemplo de estilos de Stage");

        /* Proba un estilo cada vez */
        this.show(stage, styleLabel, DECORATED);
        //this.show(stage, styleLabel, UNDECORATED);
        //this.show(stage, styleLabel, TRANSPARENT);
        //this.show(stage, styleLabel, UNIFIED);
        //this.show(stage, styleLabel, UTILITY);
    }

    private void show(Stage stage, Label styleLabel, StageStyle style) {
        styleLabel.setText(style.toString());
        stage.initStyle(style);

        if (style == TRANSPARENT) {
            // Facer a escena transparente
            stage.getScene().setFill(null);
            // Aplicar estilo CSS transparente ao nodo raíz
            stage.getScene().getRoot().setStyle(
                "-fx-background-color: transparent");
        } else if (style == UNIFIED) {
            stage.getScene().setFill(Color.TRANSPARENT);
        }

        stage.show();
    }
}