package com.jdojo.exerciciosT3;


import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class Exercicio08_Sistema_Diálogos_Personalizados extends Application {

    private Label resultadoLabel = new Label();

    @Override
    public void start(Stage primaryStage) {
    	
    	// Creamos os botóns coas súas accións
    	Button infoBtn = new Button("Diálogo info");
        infoBtn.setOnAction(e -> {
        	mostrarDialogo("Información", "Esta é unha mensaxe informativa.",
        			"ℹ", "-fx-background-color: lightblue;");
        	resultadoLabel.setText("Diálogo Info: Aceptado");
        });

        Button avisoBtn = new Button("Diálogo aviso");
        avisoBtn.setOnAction(e -> {
        	mostrarDialogo("Advertencia", "Atención! Esta acción pode ter consecuencias.",
        			"！", "-fx-background-color: orange;");
        	resultadoLabel.setText("Diálogo Aviso: Aceptado");
        });

        Button erroBtn = new Button("Diálogo erro");
        erroBtn.setOnAction(e -> {
        	mostrarDialogo("Erro", "Ocorreu un erro inesperado na aplicación.",
        			"✖", "-fx-background-color: lightcoral;");
        	resultadoLabel.setText("Diálogo Erro: Aceptado");
        });

        Button confirmacionBtn = new Button("Diálogo confirmación");
        confirmacionBtn.setOnAction(e -> {
        	mostrarDialogo("Confirmación", "Estás seguro de que queres continuar?",
        			"？", "-fx-background-color: lightgreen;");
        });

        VBox root = new VBox(15);
        root.getChildren().addAll(
            new Label("Sistema de diálogos personalizados"),
            infoBtn, avisoBtn, erroBtn, confirmacionBtn, resultadoLabel
        );
        root.setStyle("-fx-padding: 30; -fx-alignment: center;");

        Scene scene = new Scene(root, 400, 300);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Sistema de diálogos");
        primaryStage.show();
    }

    
    private void mostrarDialogo(String titulo, String mensaxe, String icono, String estilo) {
        Stage dialogo = new Stage();
        dialogo.initModality(Modality.APPLICATION_MODAL);
        
        // Creamos a mensaxe 
        Label iconLabel = new Label(icono);
        iconLabel.setStyle("-fx-alignment: center; -fx-font-size: 24;");
        Label mensaxeLbl = new Label(mensaxe);
        mensaxeLbl.setStyle("-fx-alignment: center; -fx-font-size: 12;");
            
        HBox mensaxeLayout = new HBox(10, iconLabel, mensaxeLbl);
        mensaxeLayout.setStyle("-fx-alignment: center;");
        
        HBox botonsLayout = new HBox(10);
        botonsLayout.setStyle("-fx-alignment: center;");

        // Creamos un botón de aceptar, no caso da confirmación crearemos dous botóns
        if(titulo.equals("Confirmación")) {
        	Button siBtn = new Button ("Si");
        	siBtn.setOnAction(e -> {
        		resultadoLabel.setText("Diálogo confirmación: Si");
        		dialogo.close();
        	});
        	Button nonBtn = new Button ("Non");
        	nonBtn.setOnAction(e -> {
        		resultadoLabel.setText("Diálogo confirmación: Non");
        		dialogo.close();
        	});
        	botonsLayout.getChildren().addAll(siBtn,nonBtn);
        } else {
        	Button aceptarBtn = new Button ("Aceptar");
        	aceptarBtn.setOnAction(e -> {
        		dialogo.close();
        	});
        	botonsLayout.getChildren().add(aceptarBtn);
        }
        
        
        VBox root = new VBox(mensaxeLayout, botonsLayout);
        root.setStyle("-fx-alignment: center;" + estilo);
        
        Scene scene = new Scene(root, 300, 100);
        dialogo.setScene(scene);
        dialogo.setTitle(titulo);
        dialogo.showAndWait();
  
    }

    public static void main(String[] args) {
        launch(args);
    }
}
/*Exercicio 8 Sistema de diálogos personalizados

Imos crear un sistema de diálogos personalizados que permita mostrar diferentes tipos de mensaxes ao usuario.
Instruccións

    Crearemos un botón para cada tipo de diálogo: información, advertencia, erro e confirmación.
    Cada botón debe abrir unha xanela cun diálogo correspondente ao tipo de mensaxe ao que pertence.
        O diálogo de información deberá amosar a mensaxe "Esta é unha mensaxe informativa." xunto cun icono de información. O fondo deste diálogo será lightblue.
        O diálogo de advertencia deberá mostrar a mensaxe "Atención! Esta acción pode ter consecuencias." xunto cun icono de advertencia. O fondo deste diálogo será orange.
        O diálogo de erro deberá amosar a mensaxe "Ocorreu un erro inesperado na aplicación." xunto cun icono de erro. O fondo deste diálogo será lightcoral.
        O diálogo de confirmación deberá amosar a mensaxe "Estás seguro de que queres continuar?" xunto cun icono de confirmación. O fondo deste diálogo será lightgreen.
    O diálogo de confirmación debe ter dous botóns: "Si" e "Non".
    Asimesmo existirá un Label para mostrar o resultado da acción do usuario:
        Para os diálogos de información, advertencia e erro, mostrar "Diálogo [tipo]: Aceptado" cando o usuario prema o botón de aceptar.
        Para o diálogo de confirmación, mostrar "Diálogo confirmación: Si" ou "Diálogo confirmación: Non" segundo a elección do usuario.
    O diálogo debe ser modal, é dicir, debe impedir a interacción coa xanela principal ata que se peche o diálogo*/