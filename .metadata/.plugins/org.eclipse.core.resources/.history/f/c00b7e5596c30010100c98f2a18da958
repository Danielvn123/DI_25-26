package com.jdojo.exercicios;

import javafx.application.Application;
import javafx.beans.binding.Bindings;
import javafx.beans.binding.DoubleBinding;
import javafx.beans.binding.StringBinding;
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

public class Exercicio18_CalculadoraConBindingsUnidireccionais extends Application {

	@Override
	public void start(Stage stage) throws Exception {

		DoubleProperty prezo_unitario = new SimpleDoubleProperty();
		IntegerProperty cantidade = new SimpleIntegerProperty();
		DoubleProperty desconto = new SimpleDoubleProperty();

		// Campos de entrada
		TextField prezo_unitarioField = new TextField();
		TextField cantidadField = new TextField();
		TextField descontoField = new TextField();

		// Etiqueta prezo total
		Label prezoTotal = new Label();
		Label alertaLabel = new Label();

		/*
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
		
		desconto.addListener((obs, oldValue, newValue) -> {
		double total = newValue.doubleValue() * prezo_unitario.get();
		prezoTotal.setText(String.format("Total: %.2f €", total));
		});*/

		prezo_unitarioField.textProperty().addListener((obs, oldValue, newValue) -> {
			try {
				if (!newValue.isEmpty()) {
					prezo_unitario.set(Double.parseDouble(newValue));
				}
			} catch (NumberFormatException e) {

			}
		});

		cantidadField.textProperty().addListener((obs, oldValue, newValue) -> {
			try {
				if(!newValue.isEmpty());
				cantidade.set(Integer.parseInt(newValue));
			} catch (NumberFormatException e) {

			}
		});
		
		descontoField.textProperty().addListener((obs, oldValue, newValue) -> {
			try {
				if(!newValue.isEmpty());
				desconto.set(Integer.parseInt(newValue));
			} catch (NumberFormatException e) {

			}
		});
		

		DoubleBinding total = prezo_unitario.multiply(cantidade)
                .subtract(prezo_unitario.multiply(cantidade).multiply(desconto.divide(100)));
		
		StringBinding alertaPrezo = Bindings.when(total.greaterThan(100)).then("Prezo alto").otherwise("Prezo baixo");

		StringBinding totalFormatado = (StringBinding) Bindings.format("Total: %.2f€", total);
		
		prezoTotal.textProperty().bind(totalFormatado);
		alertaLabel.textProperty().bind(alertaPrezo);	
		
		VBox root = new VBox(new Label("Precio unitario:"), prezo_unitarioField, new Label("cantidade"), 
				cantidadField,
				new Label("Descontos:"), descontoField,
				prezoTotal, alertaLabel);
		
		Scene scene = new Scene(root, 300, 300);
		stage.setScene(scene);
		stage.setTitle("Calculadora de prezo total(listeners manuais)");
		stage.show();
	}

	public static void main(String[] args) {
		launch();
	}
}