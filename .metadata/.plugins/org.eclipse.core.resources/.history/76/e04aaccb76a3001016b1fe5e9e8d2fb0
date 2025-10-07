package com.jdojo.intro;

import java.util.Random;

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

public class AdivinaoNumero extends Application {

	//Creamos un random para que me de numeros aleatorios y tambien un contador
	Random generador = new Random(); 
	int aleatorio = generador.nextInt(100);
	int intentos = 0;

	public static void main(String[] args) {
		Application.launch(args);
	}

	@Override
	public void start(Stage stage) throws Exception {

		VBox root = new VBox();
		
		// Creamos los textos y la etiqueta
		Label label = new Label("Adiviña o número comprendido entre 0 e 100");
		Label label2 = new Label("O número é máis alto.");
		Label msgIntentos = new Label();
		TextField nameFld = new TextField();

		// Creamos PRIMER boton y sus acciones
		Button btn = new Button("Probar");
		btn.setOnAction(e -> {
			intentos++;
			int numero = Integer.parseInt(nameFld.getText());
			if (aleatorio > numero && numero >= 0) {
				label2.setText("O número é máis alto");
				label2.setBackground(new Background(new BackgroundFill(null, null, null)));;
			} else if (aleatorio < numero && numero <=100) {
				label2.setText("O número é máis baixo");
				label2.setBackground(new Background(new BackgroundFill(null, null, null)));;
			} else if (numero == aleatorio) {
				label2.setText("Correcto o número é: " + aleatorio);
				label2.setBackground(new Background(new BackgroundFill(Color.LIGHTGREEN, null, null)));			
		}else {
			label2.setText("Error, ese numero esta fora do rango");
		}
			msgIntentos.setText("Intentos: " + intentos);
		});

		// Creamos SEGUNDO boton y sus acciones
		Button btn2 = new Button("Reiniciar Xogo");
		btn2.setOnAction(e -> {
			label2.setText("Xogo reiniciado");
			aleatorio = generador.nextInt(100);
			intentos = 0;
			msgIntentos.setText(" ");
			label2.setBackground(new Background(new BackgroundFill(null, null, null)));;
	});
		
		// Creamos TERCER boton y sus acciones
		Button btn3 = new Button("Rendirse");
		btn3.setOnAction(e -> {
			label2.setText("O número secreto era: "+ aleatorio);
			label2.setBackground(new Background(new BackgroundFill(Color.LIGHTCORAL, null, null)));;
			msgIntentos.setText(" ");
		});

		// Indica el orden
		root.getChildren().addAll(label, nameFld, btn, btn2, btn3, label2,msgIntentos);

		//Para que me aparezca la escena
		Scene scene = new Scene(root, 300, 200);
		stage.setTitle("Adiviña o número");
		stage.setScene(scene);
		stage.show();
	}

}