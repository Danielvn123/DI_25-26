/*Enunciado

Crea unha aplicación JavaFX chamada Click Me! que:

    Mostre unha xanela (stage) co título "Click Me!".
    Teña un Label que amose un contador, empezando en 0.
    Teña un botón cun texto que diga "Incrementar".
    Cada vez que o usuario prema o botón, o número mostrado no Label incrementarase en 1.

Requisitos técnicos:

    A clase principal debe herdar de Application.
    Implementa o método start(Stage stage) que configura a interface gráfica.
    Usa un VBox como nodo raíz da escena para organizar o Label e o botón en vertical.
    Engade un espazo de 10 píxeles entre os elementos do VBox.
    A escena debe ter un tamaño de 300x300 píxeles.
    Actualiza o texto do Label cada vez que se prema o botón incrementando o contador.

Pista:

Usa unha variable enteira como atributo da clase para almacenar o valor do contador. No evento do botón incrementa ese valor..*/

package com.jdojo.exerciciosT2;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Exercicio03_ClickMe extends Application {

	private int contador = 0;

	public static void main(String[] args) {
		Application.launch(args);
	}

	@Override
	public void start(Stage stage) throws Exception {

        // Creamos Label con contador inicial
		Label label = new Label();

		VBox root = new VBox(10);
		
        // Creamos botón
		Button btn = new Button("Incrementar");

        // Acción do botón: incrementar contador e actualizar o texto do Label
		btn.setOnAction(e -> {
			contador++;
			label.setText("contador: " + contador);
		});

		root.getChildren().addAll(label, btn);

        // Creamos escena
		Scene scene = new Scene(root, 300, 300);

		
		//Configuramos el stage
		stage.setTitle("Click Me!");
		stage.setScene(scene);
		stage.show();
	}

}
/*import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Exercicio03 extends Application {
	
	//Precisamos unha propiedade para almacenar o valor do contador
	private int clickCount = 0;
	
	@Override
	public void start(Stage stage) {
		
		stage.setTitle("Click Me!");
		
		// Agora temos que crear os controis un Label para amosar o número e un botón para incremetar
		
		Label count = new Label();
		count.setText(String.valueOf(clickCount));
		Button btnIncrement = new Button("Incrementar");
		
		// Agora indicamos que facer cando clicamos
		btnIncrement.setOnAction(e -> {
			clickCount++;
			count.setText(String.valueOf(clickCount));
		});
		
		//Creamos o elemento root a escena e adxuntamos os elementos
		VBox root = new VBox();
		root.getChildren().addAll(count,btnIncrement);
		root.setSpacing(10);
		
		Scene scene = new Scene(root,300,300);
		stage.setScene(scene);
		stage.show();
	}
	
	public static void main (String[] args) {
		Application.launch(args);
	}

}*/