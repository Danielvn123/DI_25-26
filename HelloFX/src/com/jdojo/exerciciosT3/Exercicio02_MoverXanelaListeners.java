package com.jdojo.exerciciosT3;

import javafx.application.Application;
import javafx.geometry.Rectangle2D;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Screen;
import javafx.stage.Stage;
import javafx.stage.Window;

import static javafx.stage.Modality.*;

public class Exercicio02_MoverXanelaListeners extends Application {

	@Override
	public void start(Stage stage) {
		// Obtemos límites da pantalla
		Rectangle2D visualBounds = Screen.getPrimary().getVisualBounds();

		Label label = new Label("Introduce as coordenadas X e Y:");
		TextField xField = new TextField();
		xField.setPromptText("0 - " + visualBounds.getMaxX());
		TextField yField = new TextField();
		yField.setPromptText("0 - " + visualBounds.getMaxY());

		// Creamos listener ligados aos TextField para mover o stage
		xField.textProperty().addListener((obs, oldVal, newVal) -> {
			try {
				Double x = Double.parseDouble(newVal);

				if (x < visualBounds.getMinX() || x > visualBounds.getMaxX() - stage.getWidth()) {
					showDialog(stage, WINDOW_MODAL, "Ancho fóra do rango");
				} else {
					stage.setX(x);
				}
			} catch (NumberFormatException e) {
				showDialog(stage, WINDOW_MODAL, "Débense escribir números.");
			}
		});

		// Agora o oínte para o texto de y
		yField.textProperty().addListener((obs, oldVal, newVal) -> {
			try {
				Double y = Double.parseDouble(newVal);

				if (y < visualBounds.getMinY() || y > visualBounds.getMaxY() - stage.getHeight()) {
					showDialog(stage, WINDOW_MODAL, "Altura fóra do rango");
				} else {
					stage.setY(y);
				}
			} catch (NumberFormatException e) {
				showDialog(stage, WINDOW_MODAL, "Débense escribir números.");
			}
		});
		// Preparamos a escena

		VBox root = new VBox(label, xField, yField);
		Scene scene = new Scene(root, 300, 200);
		stage.setScene(scene);
		stage.setTitle("Mover Stage con Coordenadas");
		stage.show();
	}

	// Método para amosar a xanela de aviso
	private void showDialog(Window owner, Modality modality, String msg) {
		Stage stage = new Stage(); // Nova xanela
		stage.initOwner(owner);// Configuramos o propietario desta nova xanela
		stage.initModality(modality); // e a modalidade

		Label avisoLabel = new Label(msg);
		Button closeButton = new Button("Pechar");
		closeButton.setOnAction(e -> stage.close());

		VBox root = new VBox(10);
		root.getChildren().addAll(avisoLabel, closeButton);
		Scene scene = new Scene(root, 200, 100);

		stage.setScene(scene);
		stage.setTitle("Caixa de diálogo");
		stage.show();

	}

	public static void main(String[] args) {
		launch(args);
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