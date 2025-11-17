package com.jdojo.exercicios;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Slider;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

public class Exercicio23_ControlarCirculosSliders extends Application {

	public void start(Stage stage) throws Exception {

		// Creamos el Pane
		Pane root = new Pane();
		
		//Creamos el Circulo
		Circle circulo = new Circle(150, 150, 40, Color.ANTIQUEWHITE);
		circulo.setStroke(Color.BLACK);
		
		Slider sliderH = new Slider(0, 100, 40);
		sliderH.setShowTickLabels(true);
		sliderH.setMajorTickUnit(20);
		sliderH.relocate(85, 10);
		Slider sliderV = new Slider(0, 10, 2);
		sliderV.setShowTickLabels(true);
		sliderV.setMajorTickUnit(2);
		sliderV.relocate(85, 40);

		circulo.radiusProperty().bind(sliderH.valueProperty());
		
		circulo.strokeWidthProperty().bind(sliderV.valueProperty());

		root.getChildren().addAll(sliderH, sliderV, circulo);
	
		// Creamos la escena
		Scene scene = new Scene(root, 300, 250);
		stage.setTitle("Exercicio 23 Controlar un círculo con sliders");
		stage.setScene(scene);
		stage.show();
	}

	public static void main(String[] args) {
		launch();
	}
}
/*import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Slider;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

public class Exercicio23_b extends Application {
	@Override
	public void start(Stage stage) {
		Pane root = new Pane();
		
		// Dámoslle ao círuclo unha posición inicial, un radio inicial e un recheo e borde
	    Circle circulo = new Circle(150, 150, 40, Color.ANTIQUEWHITE);
	    circulo.setStroke(Color.BLACK);
        
        // Creamos un slider para o radio o posicionamos e configuramos as súas características
	    Slider sliderRadio = new Slider(0,100,40);
	    sliderRadio.setShowTickLabels(true);
	    sliderRadio.setMajorTickUnit(20);
	    sliderRadio.relocate(85, 50);
	    
	    // Este slider o vinculamos á propiedade radius do circulo
	    circulo.radiusProperty().bind(sliderRadio.valueProperty());
	    
		// Agora facemos o mesmo pero para un slider para o grosor strokeWidth
	    Slider sliderGrosor = new Slider(0, 10, 2);
	    sliderGrosor.setShowTickLabels(true);
	    sliderGrosor.setMajorTickUnit(2);
	    sliderGrosor.relocate(85, 20);
	    
	    circulo.strokeWidthProperty().bind(sliderGrosor.valueProperty());
	    
	    root.getChildren().addAll(sliderRadio,sliderGrosor,circulo);
	    Scene scene = new Scene(root, 300, 250);
	    stage.setScene(scene);
	    stage.setTitle("Controlar un círculo con sliders");
	    stage.show();
	}
	
	public static void main (String[] args) {
		launch();
	}
}*/