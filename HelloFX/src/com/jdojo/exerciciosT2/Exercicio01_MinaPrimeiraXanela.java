/*Enunciado

Crea unha aplicación JavaFX chamada Miña primeira xanela que:

    Amose unha xanela (stage) co título inicial "Miña primeira xanela".
    Teña un botón cun texto que diga "Cambiar título".
    Cando o usuario prema o botón:
        Se o título da xanela é "Miña primeira xanela", cambiará a "Título cambiado".
        Se xa está en "Título cambiado", volverá a poñer "Miña primeira xanela".

Requisitos técnicos:

    A clase principal debe herdar de Application.
    Implementa o método start(Stage stage) que configura a interface gráfica.
    Usa un Group como nodo raíz da escena.
    A escena debe ter un tamaño de 400x300 píxeles.

Pista:

Podes empregar stage.getTitle() para obter o título actual e comparalo, e stage.setTitle(...) para cambialo.*/

package com.jdojo.exerciciosT2;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Exercicio01_MinaPrimeiraXanela extends Application {
	
		public static void main(String[] args) {
			Application.launch(args);
		}

		@Override
		public void start(Stage stage) throws Exception {
			VBox group = new VBox();
			
			Button btn = new Button ("Cambiar titulo");

			btn.setOnAction(e -> {
	            if (stage.getTitle().equals("Miña primeira xanela")) {
	            	stage.setTitle("Titulo cambiado");
	            } else {
	            	stage.setTitle("Miña primeira xanela");
	            }
	        });
			
			group.getChildren().add(btn);

			//Configuramos stage
			Scene scene = new Scene(group, 400, 300);
			stage.setScene(scene);
			stage.setTitle("Miña primeira xanela");
			stage.show();
		}

	}
