package com.jdojo.exerciciosT3;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Screen;
import javafx.stage.Stage;

public class Exercicio1_MoverXanela extends Application {

	public static void main(String[] args) {
		Application.launch(args);
	}

	@Override
	public void start(Stage stage) {

		Screen screen = Screen.getPrimary();
		double maxWidth = screen.getVisualBounds().getWidth();
		double maxHeight = screen.getVisualBounds().getHeight();

		TextField XTF = new TextField();
		XTF.setPromptText("Introduce coordenada X");
		TextField YTF = new TextField();
		YTF.setPromptText("Introduce coordenada Y");
		// Etiqueta
		Label infoLabel = new Label();

		Button moverButton = new Button("Move Button");
		moverButton.setOnAction(e -> {
			try {
				// Validación de entrada numérica
				double x = Double.parseDouble(XTF.getText());
				double y = Double.parseDouble(YTF.getText());

				// Comprobación límites pantalla
				if (x < 0 || x > maxWidth || y < 0 || y > maxHeight) {
					infoLabel.setText("Erro: Coordenadas fóra de rango.");
				} else {
					// Mover a xanela
					stage.setX(x);
					stage.setY(y);
					infoLabel.setText("Xanela movida correctamente!");
				}

			} catch (NumberFormatException ex) {
				infoLabel.setText("Erro: Introduce números válidos.");
			}
		});

		VBox root = new VBox(10);
		root.getChildren().addAll(XTF, YTF, infoLabel, moverButton);

		Scene scene = new Scene(root, 250, 150);
		stage.setScene(scene);
		stage.setTitle("Mover a xanela");
		stage.show();
	}
}
/*Exercicio 1 Mover a xanela

Imos crear unha pequena aplicación gráfica que permita ao usuario mover a xanela da aplicación a unha posición concreta da pantalla mediante coordenadas X e Y. A aplicación debe:
Instruccións

    Mostrar dous campos de texto para que o usuario introduza as coordenadas X e Y.
    Mostrar un botón "Mover Stage" que aplique as coordenadas á xanela.
    Comprobar que os valores introducidos son números válidos.
    Comprobar que as coordenadas están dentro dos límites visibles da pantalla e avisar se o usuario introduce valores fóra de rango.
    Informar ao usuario mediante unha etiqueta se a operación foi correcta ou se houbo algún erro.

Extras (opcional):

    Evita que a xanela quede fóra da pantalla por exemplo cando se introducen o valor máximo de X ou o valor máximo de Y.
*/