/*Enunciado

Crea unha aplicación JavaFX chamada Adiviña o número que:

    Mostre unha xanela co título "Adiviña o número".

    Debe xerar un número secreto aleatorio entre 0 e 100 ao iniciar o programa ou ao reiniciar o xogo.

    Mostre unha etiqueta cun texto que indique que o usuario debe adiviñar un número entre 0 e 100.

    Teña un campo de texto onde o usuario poida escribir un número.

    Teña un botón "Probar" que comprobe o número introducido polo usuario e indique:
        Se o número está fóra do rango, mostrará unha mensaxe de erro.
        Se o número é maior que o número secreto, mostrará "O número é máis baixo." nun label.
        Se o número é menor que o número secreto, mostrará "O número é máis alto." nun label.
        Se o número é correcto, mostrará unha mensaxe de éxito con fondo verde nun label.

    Mostre o número de intentos realizados polo usuario.

    Teña un botón "Reiniciar Xogo" para comezar un novo xogo, xerando un novo número e limpando o TextField e o Label.

    Teña un botón "Rendirse" que amose o número secreto e poña unha mensaxe con fondo laranxa.

Requisitos técnicos:

    A clase principal debe herdar de Application.
    Implementa o método start(Stage stage) que configura a interface gráfica.
    Usa un VBox como nodo raíz para organizar todos os controis.
    Actualiza as etiquetas e o fondo das mensaxes conforme as accións do usuario.
    A escena debe ter un tamaño de 300x200 píxeles.
    Verifica que se está a introducir un número válido. Controla ademáis as excepcións para asegurar que o usuario introduza un número e non un caracter.

Exercicio4_1 Exercicio4_2 Exercicio4_3
Pista:

Podes usar a clase Random para xerar o número aleatorio. Para cambiar o estilo dun nodo podes empregar setStyle(-fx-background-color: transparent) con CSS inline.*/

package com.jdojo.exerciciosT2;

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

public class Exercicio04_AdivinaoNumero extends Application {

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
/*import java.util.Random;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Exercicio04 extends Application {

	private int intentosCount = 0;
	private int numeroSecreto ;

	@Override
	public void start(Stage stage) {
		stage.setTitle("Adiviña o número");
		
		// Xeramos un número aleatorio para o xogo
		Random rand = new Random();
		numeroSecreto = rand.nextInt(100);

		// Precisamos tres Label un TextField e dous botón
		Label msg = new Label("Adiviña o número comprendido entre 0 e 100");
		TextField numero = new TextField();
		Button btnEnviar = new Button("Probar");
		Label resultado = new Label();
		Label intentos = new Label("Intentos: ");
		Button btnReiniciar = new Button("Reiniciar Xogo");
		Button btnRendirse = new Button("Rendirse");

		//
		btnEnviar.setOnAction(e -> {
			try {
				int intento = Integer.parseInt(numero.getText());
				if(intento<1 || intento>100) {
					resultado.setText("O resultado debe estar entre 0 e 100");
				} else if (intento > numeroSecreto){
					intentosCount++;
					resultado.setText("O número é máis baixo.");
					intentos.setText("Intentos: " + intentosCount);
				} else if (intento < numeroSecreto) {
					intentosCount++;
					resultado.setText("O número é máis alto.");
					intentos.setText("Intentos: " + intentosCount);
				} else {
					resultado.setText("Correcto o número é: " + numeroSecreto);
					resultado.setStyle("-fx-background-color: #BDFFC2;");
				}

			} catch (NumberFormatException ex) {
				System.out.println("Introduce un número válido");
			}
		});
		
		btnReiniciar.setOnAction( e -> {
			intentosCount = 0;
			numeroSecreto = rand.nextInt(100);
			resultado.setText("");
			resultado.setStyle("-fx-background-color: transparent;");
			numero.clear();				
		});
		
		btnRendirse.setOnAction( e -> {
			resultado.setText("O número secreto era: " + numeroSecreto);
			resultado.setStyle("-fx-background-color: #FFD3BD;");
				
		});
		
		VBox root = new VBox();
		root.getChildren().addAll(msg, numero, btnEnviar, btnReiniciar, btnRendirse, resultado, intentos);
		
		Scene scene = new Scene(root,300,200);
		stage.setScene(scene);
		stage.show();
		
	}

	public static void main(String[] args) {
		Application.launch(args);
	}

}*/