package com.jdojo.intro;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class ImprovedHelloFXApp extends Application {
	
	public static void main(String[] args) {
		Application.launch(args);
	}
	
	@Override
	public void start (Stage stage) {
		//elementos da IU
		Label nameLbl = new Label("Introduce o teu nome");
		TextField nameFld = new TextField();
		
		//esta vai ser a etiqueta da mensaxe do boton
		Label msg = new Label();
		msg.setStyle("-fx-text-fill: blue;");
		
		//creamos os botons
		Button btnOla = new Button ("Dicir Ola");
		Button btnSair = new Button ("Sair");
		
		//crear controlador para manexar o evento do boton dicir ola
		 btnOla.setOnAction(e -> {
	            String nome = nameFld.getText();
	            if (nome.length() > 0) {
	                msg.setText("Ola " + nome);
	            } else {
	                msg.setText("Ola descoñecido");
	            }
	        });
		 
		// crear controlador para manexar o evento do boton sair
		btnSair.setOnAction(e -> Platform.exit());
		
		VBox root = new VBox();
		
		// Establecer o espazo vertical entre os fillos a 5 píxeles
        root.setSpacing(5);
		
		root.getChildren().addAll(nameLbl, nameFld, msg, btnOla, btnSair);
		
		Scene scene = new Scene(root, 400, 150);
		stage.setScene(scene);
		
		//mostramos o escenario
		stage.show();
		
	}

}
