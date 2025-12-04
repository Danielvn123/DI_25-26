// MaximizedStage.java
package com.jdojo.stage;

import javafx.application.Application;
import javafx.geometry.Rectangle2D;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.stage.Screen;
import javafx.stage.Stage;

public class MaximizedStage extends Application {

    public static void main(String[] args) {
        Application.launch(args);
    }

    @Override
    public void start(Stage stage) {
        // Crear a escena
        stage.setScene(new Scene(new Group()));
        stage.setTitle("Un Stage Maximizado");

        // Obter os límites visibles da pantalla
        Rectangle2D visualBounds = Screen.getPrimary().getVisualBounds();

        // Configurar posición e tamaño da xanela para ocupar toda a pantalla
        stage.setX(visualBounds.getMinX());
        stage.setY(visualBounds.getMinY());
        stage.setWidth(visualBounds.getWidth());
        stage.setHeight(visualBounds.getHeight());

        // Amosar a xanela
        stage.show();
    }
}