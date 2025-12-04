package com.jdojo.stage;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.stage.Modality;
import javafx.stage.Window;
import static javafx.stage.Modality.*;

public class StageModalityApp extends Application {

    public static void main(String[] args) {
        Application.launch(args);
    }

    @Override
    public void start(Stage stage) {

           // Non bloquea podemos seguir facendo click na principal e abrir outras
        Button ownedNoneButton = new Button("Propietario None");
        ownedNoneButton.setOnAction(e -> showDialog(stage, NONE));
           // Igual que antes pero sen propietario
        Button nonOwnedNoneButton = new Button("Non-propietario None");
        nonOwnedNoneButton.setOnAction(e -> showDialog(null, NONE));
            // Non podemos facer click na xanela propietaria mentres a modal estea aberta
        Button ownedWinButton = new Button("Propietario Window Modal");
        ownedWinButton.setOnAction(e -> showDialog(stage, WINDOW_MODAL));
            // Neste caso ao non ter propietario comportase como se fose una NONE
        Button nonOwnedWinButton = new Button("Non-propietario Window Modal");
        nonOwnedWinButton.setOnAction(e -> showDialog(null, WINDOW_MODAL));
            // Bloquea todas as xanela incluso as que non son a propietaria
        Button ownedAppButton = new Button("Propietario Application Modal");
        ownedAppButton.setOnAction(e -> showDialog(stage, APPLICATION_MODAL));
            // Igual que antes, ainda sen propietario bloqueanse tódalas xanelas
        Button nonOwnedAppButton = new Button("Non-propietario Application Modal");
        nonOwnedAppButton.setOnAction(e -> showDialog(null, APPLICATION_MODAL));

        VBox root = new VBox(10);
        root.getChildren().addAll(
                ownedNoneButton, nonOwnedNoneButton,
                ownedWinButton, nonOwnedWinButton,
                ownedAppButton, nonOwnedAppButton);

        Scene scene = new Scene(root, 300, 200);
        stage.setScene(scene);
        stage.setTitle("O Stage principal");
        stage.show();
    }

    // Método para amosar unha xanela secundaria
    private void showDialog(Window owner, Modality modality) {
        Stage stage = new Stage(); // Nova xanela
        stage.initOwner(owner);// Configuramos o propietario desta nova xanela
        stage.initModality(modality); // e a modalidade

        Label modalityLabel = new Label(modality.toString());
        Button closeButton = new Button("Pechar");
        closeButton.setOnAction(e -> stage.close());

        VBox root = new VBox(10);
        root.getChildren().addAll(modalityLabel, closeButton);
        Scene scene = new Scene(root, 200, 100);

        stage.setScene(scene);
        stage.setTitle("Caixa de diálogo");
        stage.show();
    }
}