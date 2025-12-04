/*Contexto: que é un Slider?

En JavaFX, un Slider é un control gráfico que permite seleccionar un valor dentro dun rango, movendo unha barra ou manilla horizontal ou vertical.

Constructor principal:

Slider(min, max, valorInicial)

    min → valor mínimo permitido.
    max → valor máximo permitido.
    valorInicial → valor no que comeza o slider.

Propiedades útiles:

    valueProperty(): valor actual do slider (tipo DoubleProperty).
    setOrientation(Orientation.VERTICAL): pon o slider en vertical.
    setOrientation(Orientation.HORIZONTAL): pon o slider en horizontal (por defecto).

Instruccións

Crea unha aplicación JavaFx que

    Teña un slider en horizontal e outro en vertical:
    Ámbolos dous deben ter un rango entre 0 e 100 e un valor inicial de 40.
    Os Sliders deben estar sincronizados mediante un binding bidireccional.
    A xanela terá un tamaño de 200x150 píxeles.
    Mostra por consola o resultado valueProperty().isBound() de cada slider. Que resultado amosa e por que?*/


package com.jdojo.exerciciosT2;

import javafx.application.Application;
import javafx.geometry.Orientation;
import javafx.scene.Scene;
import javafx.scene.control.Slider;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Exercicio22_SlidersBindingBidireccional extends Application {

	public void start(Stage stage) throws Exception {

		// Creamos los slider
		Slider sliderH = new Slider(0, 100, 40);
		Slider sliderV = new Slider(0, 100, 40);

		sliderV.setOrientation(Orientation.VERTICAL);

		sliderH.valueProperty().bindBidirectional(sliderV.valueProperty());

		System.out.println("Valor slider vinculación: " + sliderH.valueProperty().isBound());
		System.out.println("Valor slider vinculación: " + sliderV.valueProperty().isBound());

		VBox root = new VBox(10, sliderV, sliderH);

		// Creamos la escena
		Scene scene = new Scene(root, 200, 150);
		stage.setTitle("Exercicio 21 Binding helper");
		stage.setScene(scene);
		stage.show();
	}

	public static void main(String[] args) {
		launch();
	}
}
/*
import javafx.application.Application;
import javafx.geometry.Orientation;
import javafx.scene.Scene;
import javafx.scene.control.Slider;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Exercicio22 extends Application {

	@Override
	public void start(Stage stage) {
		Slider slider1 = new Slider(0, 100, 40);
		Slider slider2 = new Slider(0, 100, 40);
		
		//Sincronizamos os sliders
		slider1.valueProperty().bindBidirectional(slider2.valueProperty());
		
		slider1.setOrientation(Orientation.VERTICAL);
		
		VBox root = new VBox(slider1,slider2);
		
		Scene scene = new Scene(root, 200, 150);
		
		stage.setScene(scene);
		stage.setTitle("Sliders e binding");
		stage.show();	
		
        // keep in mind that isBound() doesn't work for bidirectional binding
        System.out.println(slider1.valueProperty().isBound()); // false
        System.out.println(slider2.valueProperty().isBound()); // false
	}
    public static void main(String[] args) {
        launch(args);
    }
}*/