/*Enunciado

Crea unha aplicación JavaFX chamada Cambiar cor de fondo que:

    Mostre unha xanela (stage) co título inicial "Cambiar cor de fondo".
    Teña tres botóns cun texto que diga "Vermello", "Verde" e "Azul".
    Cando o usuario prema un dos botóns, cambiará a cor de fondo da xanela á correspondente cor do botón premido.

Requisitos técnicos:

    A clase principal debe herdar de Application.
    Implementa o método start(Stage stage) que configura a interface gráfica.
    Usa un VBox como nodo raíz da escena para colocar os botóns en columna.
    A escena debe ter un tamaño de 300x200 píxeles.

Pista:

Para cambiar a cor de fondo debes empregar root.setBackground(new Background(new BackgroundFill(Color.RED, null, null)))*/

package com.jdojo.exerciciosT2;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
public class Exercicio02_CambiarColorDeFondo extends Application {
	
		public static void main(String[] args) {
			Application.launch(args);
		}

		@Override
		public void start(Stage stage) throws Exception {
			VBox root = new VBox();
			
			Button btn = new Button ("Vermello");
			Button btn2 = new Button ("Verde");
			Button btn3 = new Button ("Azul");

			//Creamos botones que al presionar cambian de color
			btn.setOnAction(e -> {
				root.setBackground(new Background(new BackgroundFill(Color.RED, null, null)));			
			});	
			btn2.setOnAction(e -> {
				root.setBackground(new Background(new BackgroundFill(Color.GREEN, null, null)));				
			});	
			btn3.setOnAction(e -> {
				root.setBackground(new Background(new BackgroundFill(Color.BLUE, null, null)));		
			});	
			root.getChildren().addAll(btn,btn2,btn3);

			//Configuramos stage
			Scene scene = new Scene(root, 300, 200);
			stage.setScene(scene);
			stage.setTitle("Miña primeira xanela");
			stage.show();
		}

	}