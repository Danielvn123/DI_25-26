package com.jdojo.exerciciosT3;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Screen;
import javafx.stage.Stage;

public class Exercicio2_MoverXanelaListeners extends Application {

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
/*Exercicio 2 Mover a xanela con listeners

Partindo da aplicación do exercicio anterior, imos mellorar a interacción do usuario para que:

    Ao escribir novas coordenadas X e Y nos campos de texto, a xanela se mova automaticamente sen premer un botón.
    Se o usuario introduce valores fóra dos límites visibles da pantalla, apareza unha caixa de diálogo informando do erro.
    Se o usuario introduce texto que non sexa un número, tamén apareza unha caixa de diálogo avisando.
    Cada caixa de diálogo terá un botón "Pechar" que permita ao usuario pechala.
    As caixas de diálogo deben ser modais respecto á xanela principal (non se pode interactuar coa xanela principal ata pechar a caixa de diálogo).

Pistas

    As propiedades stage.xProperty() e stage.yProperty() son ReadOnlyDoubleProperty, non DoubleProperty. Iso significa que non podes facer bind() directamente, porque JavaFX non permite ligar ou supeditar propiedades de só de lectura a outras propiedades. Terás que usar métodos como setX() e setY() para mover a xanela dende un listener de cambio sobre os campos de texto, é dicir, cando cambie o texto do campo o escoitamos e chamamos aos métodos setX() e setY()

    Crea un método privado para a xanela de aviso como fixemos no apartado 1.6
*/