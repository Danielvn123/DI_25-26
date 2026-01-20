package com.jdojo.exerciciosT3;

import javafx.application.Application;
import javafx.geometry.Rectangle2D;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Screen;
import javafx.stage.Stage;

public class Exercicio01_MoverXanela extends Application {
	@Override
	public void start(Stage stage) {
		// Obtemos límites da pantalla
		Rectangle2D visualBounds = Screen.getPrimary().getVisualBounds();

		Label label = new Label("Introduce as coordenadas X e Y:");
		TextField xField = new TextField();
		xField.setPromptText("0 - " + visualBounds.getMaxX());
		TextField yField = new TextField();
		yField.setPromptText("0 - " + visualBounds.getMaxY());

		Label avisoLabel = new Label();

		// Botón para aplicar os cambios
		Button moverButton = new Button("Mover Stage");
		moverButton.setOnAction(e -> {
			// Verificar que os valores son numéricos parseando a double
			try {
				double x = Double.parseDouble(xField.getText());
				double y = Double.parseDouble(yField.getText());

				// Verificamos os límites para non mover fóra deles.
				if (x > visualBounds.getMinX() && x < visualBounds.getMaxX() - stage.getWidth() && y > visualBounds.getMinY()
						&& y < visualBounds.getMaxY() - stage.getHeight()) {
					stage.setX(x);
					stage.setY(y);
					avisoLabel.setText("Stage movido correctamente.");
					
				} else {
					avisoLabel.setText("Coordenadas fóra de rango!");
				}

			} catch (NumberFormatException ex) {
				avisoLabel.setText("Introduce número válidos");
			}
		});

		// Preparamos a escena

		VBox root = new VBox(label, xField, yField, moverButton, avisoLabel);
		Scene scene = new Scene(root, 300, 200);

		stage.setScene(scene);
		stage.setTitle("Mover Stage con Coordenadas");
		stage.show();
	}

	public static void main(String[] args) {
		launch();
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