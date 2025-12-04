/*Que é un Circle?

En JavaFX, un Circle é unha forma gráfica que se mostra nun VBox, un Pane ou outro layout. Ten varias propiedades que podemos modificar:

    radius: radio do círculo (canto mide desde o centro ata a orla).
    fill: cor do interior do círculo.
    stroke: cor do borde do círculo.
    strokeWidth: grosor do borde.

Podemos cambiar estas propiedades directamente con métodos como setRadius(), setFill() ou, mellor aínda, vincular propiedades a controis como sliders para que se actualicen automaticamente.
Instruccións

    Crea unha aplicación JavaFX cun Pane como raíz (é o mesmo cun VBox ou un HBox).
    Engade un Circle centrado aproximadamente no medio do pane:
        Posición inicial: (150, 150)
        Radio inicial: 40
        Cor de recheo (fill): ANTIQUEWHITE
        Cor do borde (stroke): BLACK
    Engade dous Sliders:
        Slider 1 : Radio do círculo
            Rango de 0 a 100
            Valor inicial 40
            Mostra as etiquetas de tick e marcas cada 20 unidades.
        Slider 2 – Grosor do borde
            Rango de 0 a 10
            Valor inicial 2
            Mostra as etiquetas de tick e marcas cada 2 unidades.
    Vincula os sliders ás propiedades correspondentes do círculo usando bindings:
        circle.radiusProperty() debe estar vinculado ao slider do radio.
        circle.strokeWidthProperty() debe estar vinculado ao slider do grosor do borde.
    Posiciona os sliders no pane para que non se sobrepoñan co círculo.
    Crea unha escena de tamaño 300 x 250 píxeles e móstraa nunha xanela.

Exercicio23
Posicionamento dos elementos

Pane é un Layout que a diferenza de VBox non xestiona a disposición dos elementos. Para colocar os elementos debes empregar o método relocate da Class Node*/

package com.jdojo.exerciciosT2;

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