/*Imos modificar o exercicio anterior e en vez de usar listeners manuais empregaremos a Binding API de JavaFX para que o total se actualice automaticamente cando cambien os valores.
Requisitos da interface gráfica

    Un campo para introducir o prezo unitario.
    Un campo para introducir a cantidade.
    Un campo para introducir un desconto en %.
    Unha etiqueta que amose o prezo total.
    O prezo total debe actualizarse automaticamente cando se cambie calquera dos tres valores.
    Mostrar unha mensaxe de "Prezo alto" se o total supera os 100€, empregando Bindings.when(...).then(...).otherwise(...).

Pistas

    Emprega propiedades (DoubleProperty, IntegerProperty) para o prezo unitario, cantidade e desconto.
    Crea un DoubleBinding que calcule o total con desconto:

    DoubleBinding total = prezoUnitario.multiply(cantidade)
                                     .subtract(prezoUnitario.multiply(cantidade).multiply(desconto.divide(100)));

Formatea a saída a 2 decimais usando Bindings.format("Total: %.2f€", total) e castea a StringBinding
Emprega Bindings.when(...).then(...).otherwise(...) para a mensaxe de prezo alto.
Para a actualización dos campos de propiedades dependentes do textProperty() dos TextField deberás de seguir empregando listener manuais.*/

package com.jdojo.exerciciosT2;

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
/*import javafx.application.Application;
import javafx.stage.Stage;
import javafx.beans.binding.Bindings;
import javafx.beans.binding.DoubleBinding;
import javafx.beans.binding.StringBinding;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;

public class Exercicio18 extends Application {
	@Override
	public void start(Stage stage) {
		// Propiedades do modelo
		DoubleProperty prezoUnitario = new SimpleDoubleProperty();
		IntegerProperty cantidade = new SimpleIntegerProperty();
		DoubleProperty desconto = new SimpleDoubleProperty();

		// Campos da IU
		TextField prezoUnitarioField = new TextField();
		TextField cantidadeField = new TextField();
		TextField descontoField = new TextField();

		// Seguimos empregando Listeners para actualizar as propiedades segundo a
		// entrada de texto
		prezoUnitarioField.textProperty().addListener((obs, oldVal, newVal) -> {
			try {
				prezoUnitario.set(newVal.isEmpty() ? 0.0 : Double.parseDouble(newVal));
			} catch (NumberFormatException e) {
				// Ignorar valores inválidos
			}
		});

		cantidadeField.textProperty().addListener((obs, oldVal, newVal) -> {
			try {
				cantidade.set(newVal.isEmpty() ? 0 : Integer.parseInt(newVal));
			} catch (NumberFormatException e) {
				// Ignorar valores inválidos
			}
		});

		descontoField.textProperty().addListener((obs, oldVal, newVal) -> {
			try {
				desconto.set(newVal.isEmpty() ? 0 : Integer.parseInt(newVal));
			} catch (NumberFormatException e) {
				// Ignorar valores inválidos
			}
		});

		// Seguimos coas vinculacións
		DoubleBinding total = prezoUnitario.multiply(cantidade);
		DoubleBinding totalConDesconto = total.multiply(Bindings.subtract(1, Bindings.divide(desconto, 100)));

		// Se o queremos formatear seria:
		StringBinding totalFormatado = (StringBinding) Bindings.format("Total: %.2f", totalConDesconto);

		// Creamos un binding ligado ao prezo para a mensaxe de Prezo algo
		StringBinding alertaPrezo = Bindings.when(totalConDesconto.greaterThan(100)).then("Prezo alto").otherwise("");

		// Creamos as etiquetas tanto para o total como para a alerta
		Label alertaLbl = new Label();
		Label totalConDescontoLbl = new Label();

		// Vinculamos a propiedade texto do elementos Label á
		alertaLbl.textProperty().bind(alertaPrezo);
		totalConDescontoLbl.textProperty().bind(totalFormatado);

		// Layout
		VBox root = new VBox(new Label("Prezo unitario (€):"), prezoUnitarioField, new Label("Cantidade:"),
				cantidadeField, new Label("Desconto (%):"), descontoField, totalConDescontoLbl, alertaLbl);
		root.setSpacing(8);

		Scene scene = new Scene(root, 300, 250);
		stage.setScene(scene);
		stage.setTitle("Calculadora de prezo total (Bindings)");
		stage.show();
	}

	public static void main(String[] args) {
		launch();
	}
}*/