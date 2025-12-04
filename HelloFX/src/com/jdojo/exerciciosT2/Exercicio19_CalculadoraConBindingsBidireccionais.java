/*Imos crear unha calculadora en JavaFX que permita calcular o prezo total dun artigo a partir do prezo unitario, cantidade e desconto, empregando bindings bidireccionais para conectar os campos de entrada coas propiedades do modelo.
Requisitos da interface

    Un campo para introducir o prezo unitario.
    Un campo para introducir a cantidade.
    Un campo para introducir un desconto en %.
    Unha etiqueta que amose o prezo total formateado a 2 decimais.
    Unha etiqueta que mostre "Prezo alto" se o total supera os 100€.

Atención

Como se comentou no apartado 1.18 Vinculacións unidireccionais e bidireccionais, nos bindings bidireccionais, as propiedades que se conectan deben ser do mesmo tipo.

    Como TextField.textProperty() é un StringProperty e as nosas propiedades de modelo son DoubleProperty ou IntegerProperty, necesitamos un converter, como NumberStringConverter, para facer a conversión automática entre texto e número.

import javafx.util.converter.NumberStringConverter;
...
DoubleProperty prezoUnitario = new SimpleDoubleProperty();
TextField prezoUnitarioField = new TextField();

// Binding bidireccional con conversión automática entre String e Double
prezoUnitarioField.textProperty().bindBidirectional(prezoUnitario, new NumberStringConverter());

Pistas

    Emprega bindBidirectional para conectar os TextField coas propiedades.
    Usar NumberStringConverter para a conversión automática entre texto e número.
    Usar Bindings para calcular o total e a mensaxe de "Prezo alto".
    Non empregar listeners manuais para actualizar valores.*/


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
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.util.converter.NumberStringConverter;

public class Exercicio19_CalculadoraConBindingsBidireccionais extends Application{
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

			prezo_unitarioField.textProperty().bindBidirectional(prezo_unitario, new NumberStringConverter());
			cantidadField.textProperty().bindBidirectional(cantidade, new NumberStringConverter());
			descontoField.textProperty().bindBidirectional(desconto, new NumberStringConverter());
			
			DoubleBinding total = prezo_unitario.multiply(cantidade)
	                .subtract(prezo_unitario.multiply(cantidade).multiply(desconto.divide(100)));
			
			StringBinding alertaPrezo = Bindings.when(total.greaterThan(100)).then("Prezo alto").otherwise("Prezo baixo");

			StringBinding totalFormatado = (StringBinding) Bindings.format("Total: %.2f€", total);
			
			prezoTotal.textProperty().bind(totalFormatado);
			alertaLabel.textProperty().bind(alertaPrezo);	
			
			//Para que salga por pantalla
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
import javafx.beans.property.IntegerProperty;
import javafx.beans.binding.Binding;
import javafx.beans.binding.Bindings;
import javafx.beans.binding.DoubleBinding;
import javafx.beans.binding.StringBinding;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.util.converter.NumberStringConverter;

public class Exercicio19 extends Application {
	
	@Override
	public void start (Stage stage) {
		
		//Creamos as propiedades do modelo
		DoubleProperty prezo_unitario = new SimpleDoubleProperty();
		IntegerProperty cantidade = new SimpleIntegerProperty();
		DoubleProperty desconto = new SimpleDoubleProperty();
		
		//Precisamos os campos da IU
		TextField prezoField = new TextField();
		TextField cantidadeField = new TextField();
		TextField descontoField = new TextField();
		
		Label prezoLbl = new Label();
		Label alertaLbl = new Label();
		
		// Creamos as vinculacións bidireccionais
		prezoField.textProperty().bindBidirectional(prezo_unitario, new NumberStringConverter());
		cantidadeField.textProperty().bindBidirectional(cantidade, new NumberStringConverter());
		descontoField.textProperty().bindBidirectional(desconto, new NumberStringConverter());
		
		
		//Creamos un Binding para que nos calcule o prezoConDesconto
		//este logo estará ligado á label correspondente.
		
		DoubleBinding total = prezo_unitario.multiply(cantidade)
				.subtract(prezo_unitario.multiply(cantidade).multiply(desconto.divide(100)));
		
		// Binding formateado
		StringBinding totalFormatado = (StringBinding) Bindings.format("Total: %.2f€", total);
		
		// Agora estas vinculacións as asociamos aos Labels
		prezoLbl.textProperty().bind(totalFormatado);
		
		// Rematamos co Binding da alerta
		StringBinding alerta = Bindings.when(total.greaterThan(100))
				.then("Prezo alto")
				.otherwise("");
		alertaLbl.textProperty().bind(alerta);
		
		//Layout
		VBox root = new VBox(
				new Label("Prezo unitario (€): "), prezoField,
				new Label("Cantidade: "), cantidadeField,
				new Label("Desconto: "), descontoField,
				prezoLbl,
				alertaLbl
		);
		
		Scene scene = new Scene(root, 300, 250);
		stage.setScene(scene);
		stage.setTitle("Calculadora de prezo total (Bindings bidireccionais)");
		stage.show();
	}

}*/