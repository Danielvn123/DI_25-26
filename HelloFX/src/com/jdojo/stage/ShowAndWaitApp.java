// ShowAndWaitApp.java
package com.jdojo.stage;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class ShowAndWaitApp extends Application {

    protected static int counter = 0;
    protected Stage lastOpenStage;

    public static void main(String[] args) {
        Application.launch(args);
    }

    @Override
    public void start(Stage stage) {
        VBox root = new VBox();
        Button openButton = new Button("Abrir");
        openButton.setOnAction(e -> open(++counter));
        root.getChildren().add(openButton);

        Scene scene = new Scene(root, 400, 400);
        stage.setScene(scene);
        stage.setTitle("Xanela Principal");
        stage.show();

        this.lastOpenStage = stage;
    }

    private void open(int stageNumber) {
        Stage stage = new Stage();
        stage.setTitle("#" + stageNumber);

        Button sayHelloButton = new Button("Dicir Ola");
        sayHelloButton.setOnAction(
            e -> System.out.println("Ola desde #" + stageNumber));

        Button openButton = new Button("Abrir");
        openButton.setOnAction(e -> open(++counter));

        VBox root = new VBox();
        root.getChildren().addAll(sayHelloButton, openButton);

        Scene scene = new Scene(root, 200, 200);
        stage.setScene(scene);

        // Colocar a xanela lixeiramente desprazada respecto da última aberta
        stage.setX(this.lastOpenStage.getX() + 50);
        stage.setY(this.lastOpenStage.getY() + 50);
        this.lastOpenStage = stage;

        System.out.println("Antes de stage.showAndWait(): " + stageNumber);
        stage.showAndWait(); // Aquí se detén a execución!!!! 
        // Polo que non se amosará o println seguinte ata pechar a xanela 
        System.out.println("Despois de stage.showAndWait(): " + stageNumber);
    }
}