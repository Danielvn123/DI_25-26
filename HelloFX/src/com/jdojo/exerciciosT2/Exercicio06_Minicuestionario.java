/*Enunciado

Crea unha aplicación JavaFX chamada Mini Cuestionario que:

    Mostre unha xanela cun título "Mini Cuestionario".
    Presente unha pregunta: "Cal é a capital de Galicia?", seguida de tres posibles respostas:
        A Coruña
        Santiago de Compostela
        Vigo
    Mostre un campo de texto onde o usuario poida escribir a súa resposta.
    Inclúa un botón chamado "Enviar resposta" que:
        Se o campo está baleiro, escribe no propio campo "Campo obrigatorio" en vermello.
        Se a resposta é incorrecta ("a coruña" ou "vigo"), cambia o fondo da xanela a vermello.
        Se a **resposta é correcta **("santiago de compostela"), cambia o fondo a verde.
        Para calquera outro texto, cambia o fondo a laranxa.

Requisitos técnicos:

    A clase principal debe herdar de Application.
    Implementa o método start(Stage stage) que configura a interface gráfica.
    Usa un VBox como nodo raíz para colocar todos os controis en vertical.
    Utiliza Label, TextField e Button para construír a interface.
    Emprega root.setBackground(...) para cambiar a cor de fondo coma no Exercicio 2.
    A escena debe ter un tamaño de 300x200 píxeles.

Exercicio 6
Pista:

Para comparar cadeas de texto sen distinguir maiúsculas/minúsculas podes usar toLowerCase() e equals(...) ou directamente un switch. Lembra comprobar que o campo non está baleiro antes de procesar a resposta.*/

package com.jdojo.exerciciosT2;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class Exercicio06_Minicuestionario extends Application {

	public static void main(String[] args) {
		Application.launch(args);
	}

	@Override
	public void start(Stage stage) throws Exception {
		
		//Para que salga en vertical
		VBox root = new VBox();
		
		//Creamos textos
		Label label1 = new Label("Cal é a capital de Galicia");
		Label label2 = new Label("-A Coruña");
		Label label3 = new Label("-Santiago de Compostela");
		Label label4 = new Label("-Vigo");
		
		//Creamos Etiqueta
		TextField nameFld = new TextField();
		
		//Creamos Botón
		Button btn = new Button("Enviar resposta");
		

		//Creamos las acciones del botón
		btn.setOnAction( e->{
			String respuesta = nameFld.getText();
			if(respuesta.equalsIgnoreCase("A Coruña") || respuesta.equalsIgnoreCase("Vigo")){
				
				root.setBackground(new Background(new BackgroundFill(Color.RED, null, null)));;
				
			}else if(respuesta.equalsIgnoreCase("Santiago de Compostela")) {
				
				root.setBackground(new Background(new BackgroundFill(Color.GREEN, null, null)));;

			}else if(respuesta.isEmpty()){
				
				
				nameFld.setPromptText("Campo obrigatorio");
				nameFld.setStyle("-fx-prompt-text-fill: red;");
				root.setBackground(new Background(new BackgroundFill(null, null, null)));;

			}else {
				
				root.setBackground(new Background(new BackgroundFill(Color.ORANGE, null, null)));
			}
			
		});
		
		//Lo utilizamos para configurar el orden
		root.getChildren().addAll(label1, label2, label3, label4, nameFld, btn);

		//Para ver la escena
		Scene scene = new Scene(root, 300, 200);
		stage.setTitle("Mini Cuestionario");
		stage.setScene(scene);
		stage.show();
	}
}
/*import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class Exercicio06 extends Application {
	@Override
	public void start(Stage stage) {
		
		stage.setTitle("Mini Cuestionario");
		
		//Os controis serán catro Label para a pregunta e opcións, un TextField para a resposta, un botón para enviar a resposta
		Label pregunta = new Label("Cal é a capital de Galicia?");
		Label lblOption1 = new Label ("- A Coruña");
		Label lblOption2 = new Label ("- Santiago de Compostela");
		Label lblOption3 = new Label ("- Vigo");
		TextField resposta = new TextField();
		Button btnEnviar = new Button("Enviar resposta");
		
		// Preparamos un Vertical Box para os elementos
		VBox root = new VBox();
		root.getChildren().addAll(pregunta,lblOption1,lblOption2,lblOption3,resposta,btnEnviar);
		
		//Programamos o comportamento do botón
		
		btnEnviar.setOnAction(e -> {
			resposta.setStyle("-fx-text-fill: black;");
			if(resposta.getText().trim().length()>0) {
				switch(resposta.getText().toLowerCase()) {
				case "a coruña" : root.setBackground(new Background(new BackgroundFill(Color.RED, null, null))); break;
				case "santiago de compostela" : root.setBackground(new Background(new BackgroundFill(Color.GREEN, null, null))); break;
				case "vigo" : root.setBackground(new Background(new BackgroundFill(Color.RED, null, null))); break;
				default: root.setBackground(new Background(new BackgroundFill(Color.ORANGE, null, null)));
				}
	
			} else {
				resposta.setText("Campo obrigatorio");
				resposta.setStyle("-fx-text-fill: red;");
			}
		});
		
	
        Scene scene = new Scene(root,300,200);
        stage.setScene(scene);
        stage.show();
	}
	
	public static void main (String[] args) {
		Application.launch(args);
	}
*/