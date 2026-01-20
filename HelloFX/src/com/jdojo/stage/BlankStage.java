// BlankStage.java
package com.jdojo.stage;

import javafx.application.Application;
import javafx.stage.Stage;

public class BlankStage extends Application {
    public static void main(String[] args) {
        Application.launch(args);
    }

    @Override
    public void start(Stage stage) {
        stage.setTitle("Blank Stage");
        stage.show();
    }
}

/*Engadindo unha escena baleira
import javafx.scene.Group;
import javafx.scene.Scene;
...
@Override
public void start(Stage stage) {
    stage.setTitle("Stage with an Empty Scene");
    Scene scene = new Scene(new Group()); // raíz obrigatoria
    stage.setScene(scene);
    stage.show();
}*/

/*Engadindo un botón
import javafx.scene.control.Button;
...
@Override
public void start(Stage stage) {
    stage.setTitle("Stage with a Button in the Scene");
    Group root = new Group(new Button("Hello"));
    Scene scene = new Scene(root);
    stage.setScene(scene);
    stage.show();
}*/

/*Definindo tamaño da escena
@Override
public void start(Stage stage) {
    stage.setTitle("Stage with a Sized Scene");
    Group root = new Group(new Button("Hello"));
    Scene scene = new Scene(root, 300, 100);
    stage.setScene(scene);
    stage.show();
}*/

/*Definindo tamén o tamaño do Stage
@Override
public void start(Stage stage) {
    stage.setTitle("A Sized Stage with a Sized Scene");
    Group root = new Group(new Button("Hello"));
    Scene scene = new Scene(root, 300, 100);
    stage.setScene(scene);
    stage.setWidth(400);
    stage.setHeight(100);
    stage.show();
}*/