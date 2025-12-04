/*Enunciado

Crea unha aplicación JavaFX chamada Cambiar tamaño da xanela que:

    Mostre unha xanela cun tamaño inicial de 300x200 píxeles e título "Cambiar tamaño da xanela".
    Amose dous campos de texto (TextField) onde o usuario poida introducir un novo ancho e unha nova altura para a xanela.
    Mostre dúas etiquetas, unha para cada campo, que indiquen claramente o que se espera introducir.
    Teña un botón chamado "Redimensionar" que:
        Lea os valores introducidos.
        Se ambos son números positivos, cambia o tamaño da xanela a eses valores.
        Se se introduce un valor non numérico ou negativo, mostra unha mensaxe de erro por consola.

Requisitos técnicos:

    A clase principal debe herdar de Application.
    Implementa o método start(Stage stage) que configura a interface gráfica.
    Usa un VBox como contedor principal (root) e HBox para agrupar as etiquetas e os campos de texto horizontalmente.
    Usa TextField.setPromptText(...) para dar unha pista ao usuario sobre o que introducir.
    Na redimensión controla que non se introduzan valores negativos nin tampouco caracteres non numéricos con try/catch.
    A escena debe inicializarse con 300x200 píxeles.

Exercicio 5
Pista:

    HBox funciona igual que VBox. Agrupa o TextField e o Label nun HBox e logo eses HBox resultantes fainos fillos de VBox root
*/

package com.jdojo.exerciciosT2;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Exercicio05_Cambiarotamanodaxanela extends Application {

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
/*import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Exercicio05 extends Application {

	@Override
	public void start(Stage stage) {
		
		stage.setTitle("Cambiar tamaño da xanela");

		// Controis: dous TextField, dous label e un botón
		Label anchoLbl = new Label("Novo ancho");
		TextField ancho = new TextField();
		ancho.setPromptText("Indica o novo ancho..");

		HBox anchoBox = new HBox();
		anchoBox.getChildren().addAll(anchoLbl, ancho);

		Label altoLbl = new Label("Nova altura");
		TextField altura = new TextField();
		altura.setPromptText("Indica a nova altura..");

		HBox alturaBox = new HBox();
		alturaBox.getChildren().addAll(altoLbl, altura);

		Button btnRedimensionar = new Button("Redimensionar");

		// Configuramos o comportamento ao clicar o botón
		btnRedimensionar.setOnAction(e -> {
			try {
				Double novoAncho = Double.parseDouble(ancho.getText());
				Double novaAltura = Double.parseDouble(altura.getText());
				if (novoAncho > 0 && novaAltura > 0) {
					stage.setWidth(novoAncho);
					stage.setHeight(novaAltura);
				} else {
					System.out.println("Por favor, introduce valores positivos.");
				}

			} catch (NumberFormatException ex) {
				System.out.println("Por favor, introduce números válidos.");
			}

		});

		VBox root = new VBox();
		root.getChildren().addAll(anchoBox, alturaBox, btnRedimensionar);

		Scene scene = new Scene(root, 300, 200);
		stage.setScene(scene);
		stage.show();
	}

	public static void main(String[] args) {
		Application.launch(args);
	}
}
*/