package com.jdojo.intro;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Cambiarotamanodaxanela extends Application {

	public static void main(String[] args) {
		Application.launch(args);
	}

	@Override
	public void start(Stage stage) throws Exception {

		//Para que salga en vertical
		VBox root = new VBox();
		
		//Para que salga en horizontal
		HBox primero = new HBox();
		HBox segundo = new HBox();

		//Texto 
		Label label1 = new Label("Novo ancho");
		Label label2 = new Label("Nova altura");
		Label msg = new Label(" ");
		
		//Etiquetas
		TextField nameFld = new TextField();
		TextField nameFld2 = new TextField();

		//Texto que aparece dentro de las etiquetas
		nameFld.setPromptText("Indica o novo ancho");
		nameFld2.setPromptText("Indica a nova altura");
		
		//Botón creado
		Button btn = new Button("Redimensionar");
		
		
		//Try-catch 
		btn.setOnAction(e -> {
			int Ancho = Integer.parseInt(nameFld.getText());
			int Altura = Integer.parseInt(nameFld.getText());
			
			try {
				if(Altura > 0 && Ancho > 0) {
					stage.setWidth(Ancho);
					stage.setHeight(Altura);
			}else {
				msg.setText("Números inválidos");
			}
		}catch(Exception e1) {
			msg.setText("Error");
		}
		});

		//Configuramos el orden y el lugar
		root.getChildren().addAll(primero, segundo, btn);
		primero.getChildren().addAll(label1, nameFld);
		segundo.getChildren().addAll(label2, nameFld2);

		Scene scene = new Scene(root, 300, 200);
		stage.setTitle("Cambiar tamaño da xanela");
		stage.setScene(scene);
		stage.show();
	}

}