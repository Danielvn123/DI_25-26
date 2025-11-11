package com.jdojo.exercicios;

import javafx.application.Application;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Exercicio17_CalculadoraSinBindings extends Application {

	@Override
	public void start(Stage stage) throws Exception {

		DoubleProperty prezo_unitario = new SimpleDoubleProperty();
		IntegerProperty cantidade = new SimpleIntegerProperty();

		// Campos de entrada
		TextField prezo_unitario1 = new TextField();
		TextField cantidade1 = new TextField();

		// Etiqueta prezo total
		Label prezoTotal = new Label();

		//Listener para as propiedades
		prezo_unitario.addListener((obs, oldValue, newValue) -> {
			double total = newValue.doubleValue() * cantidade.get();
			prezoTotal.setText(String.format("Total: %.2f €", total));
		});

		//Listener para os campos
		cantidade.addListener((obs, oldValue, newValue) -> {
			double total = newValue.doubleValue() * prezo_unitario.get();
			prezoTotal.setText(String.format("Total: %.2f €", total));
		});

		prezo_unitario1.textProperty().addListener((obs, oldValue, newValue) -> {
			try {
				if (!newValue.isEmpty()) {
					prezo_unitario.set(Double.parseDouble(newValue));
				}
			} catch (NumberFormatException e) {

			}
		});

		cantidade1.textProperty().addListener((obs, oldValue, newValue) -> {
			try {
				cantidade.set(Integer.parseInt(newValue));
			} catch (NumberFormatException e) {

			}
		});

		VBox root = new VBox(new Label("Precio unitario:"), prezo_unitario1, new Label("Precio cantidade"), cantidade1,
				prezoTotal);
		Scene scene = new Scene(root, 300, 300);

		stage.setScene(scene);
		stage.setTitle("Calculadora de prezo total(listeners manuais)");
		stage.show();
	}

	public static void main(String[] args) {
		launch();
	}
}