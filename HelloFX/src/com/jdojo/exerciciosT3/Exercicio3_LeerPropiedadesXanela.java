package com.jdojo.exerciciosT3;

import javafx.application.Application;
import javafx.beans.binding.Bindings;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Exercicio3_LeerPropiedadesXanela {
	
	public class Exercicio3 extends Application{
		
		public void start(Stage stage) throws Exception{
			
			Label xLabel = new Label();
			Label yLabel = new Label();
			Label widthLabel = new Label();
			Label heightLabel = new Label();

			
			xLabel.textProperty().bind(Bindings.concat("X: ", stage.xProperty()));
			yLabel.textProperty().bind(Bindings.concat("X: ", stage.yProperty()));
			widthLabel.textProperty().bind(Bindings.concat("X: ", stage.widthProperty()));
			heightLabel.textProperty().bind(Bindings.concat("X: ", stage.heightProperty()));
			
			
			VBox root = new VBox (10, xLabel, yLabel, widthLabel, heightLabel);
			Scene scene = new Scene(root, 300, 200);
			stage.setScene(scene);
			stage.show();

		}
		
		public static void main (String[] args) {
			launch(args);
		}
	}

}
