/*Crea unha aplicación gráfica en JavaFX que:

    Teña unha propiedade IntegerProperty para almacenar un número enteiro.
    Mostre un campo de texto (TextField) no que o usuario poida introducir o número.
    Mostre nunha etiqueta (Label) se o número é PAR ou IMPAR.
    Para determinar a paridade, crea un binding personalizado mediante unha subclase anónima de StringBinding, ligando esta ao IntegerProperty e sobreescribindo computeValue().
    Establece un bind bidireccional entre o campo de texto e a propiedade IntegerProperty empregando un NumberStringConverter, de modo que ao modificar o texto se actualice o número e viceversa.
    Faga que a etiqueta se actualice automaticamente a PAR ou IMPAR ao cambiar o valor do número grazas ao binding.*/


package com.jdojo.exerciciosT2;

import javafx.application.Application;
import javafx.beans.binding.Bindings;
import javafx.beans.binding.StringBinding;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.util.converter.NumberStringConverter;

public class Exercicio20_IndicadorNúmeroParImpar extends Application {

	public void start(Stage stage) throws Exception {

		IntegerProperty numeroEnteiro = new SimpleIntegerProperty();

		TextField numero = new TextField();

		Label parImpar = new Label();

		numero.textProperty().bindBidirectional(numeroEnteiro, new NumberStringConverter());

		StringBinding ParImparBinding = new StringBinding() {
			{
				this.bind(numeroEnteiro);
			}

			@Override
			protected String computeValue() {
				int valor = numeroEnteiro.get();
				System.out.print(valor);
				if (!(valor == 0)) {
					return (valor % 2 == 0) ? "PAR" : "IMPAR";
				} else {
					return "";
				}
			}
		};

		parImpar.textProperty().bind(ParImparBinding);

		numero.textProperty().bindBidirectional(numeroEnteiro, new NumberStringConverter());

		VBox root = new VBox(new Label("Número:"), numero, parImpar);
		Scene scene = new Scene(root, 300, 300);
		stage.setScene(scene);
		stage.setTitle("Indicador Par / Impar");
		stage.show();
	}

	public static void main(String[] args) {
		launch();
	}
}
/*
import javafx.application.Application;
import javafx.beans.binding.Bindings;
import javafx.beans.binding.StringBinding;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.util.converter.NumberStringConverter;

public class Exercicio20_b extends Application {

	@Override
	public void start(Stage stage) {
		// Comezamos coas propiedades
		IntegerProperty numero = new SimpleIntegerProperty();

		// IU TextField e Label
		TextField numeroField = new TextField();
		Label paridadeLbl = new Label();

		// Como non temos un Binding axeitado para discernir se un número é par ou impar
		// creamos un propio
		StringBinding paridadeBinding = new StringBinding() {
			{
				// Ligamos a propiedade numero como dependencia.
				this.bind(numero);
			}

			@Override
			protected String computeValue() {
				// Escibimos a lóxica
				int valor = numero.get();
				return valor % 2 == 0 ? "PAR" : "IMPAR";
			}
		};

		// Enlazamos os datos coa interface gráfica.
		// O Binding creado o ligamos ao label
		paridadeLbl.textProperty().bind(paridadeBinding);
		// E o numero e TextField cun bind bidireccional
		numeroField.textProperty().bindBidirectional(numero, new NumberStringConverter());

		VBox root = new VBox(new Label("Introduce número:"), numeroField, paridadeLbl);

		Scene scene = new Scene(root, 300, 250);
		stage.setScene(scene);
		stage.setTitle("Indicador Par/Impar b");
		stage.show();

	}
}*/