package com.jdojo.stage;

import javafx.application.Application;
import javafx.geometry.Rectangle2D;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Screen;
import javafx.stage.Stage;

public class CenteredAStage extends Application {

	@Override
	public void start(Stage stage) {
		stage.setTitle("A Truly Centered Stage");
		Group root = new Group(new Button("Hello"));
		Scene scene = new Scene(root);
		stage.setScene(scene);
		
		// Erro!!!! A seguinte lóxica se emprega despois da chamada show()
		// Neste momento, o ancho e alto do stage non se coñecen. Son NaN.
		System.out.println("Antes do show(): width=" + stage.getWidth() + ", height=" + stage.getHeight());
		Rectangle2D bounds = Screen.getPrimary().getVisualBounds();
		double x = bounds.getMinX() + (bounds.getWidth() - stage.getWidth()) / 2.0;
		double y = bounds.getMinY() + (bounds.getHeight() - stage.getHeight()) / 2.0;
		stage.setX(x);
		stage.setY(y);
		stage.show();
        
		System.out.println("Despois do show(): width=" + stage.getWidth() + ", height=" + stage.getHeight());
	}

	public static void main(String[] args) {
		launch();
	}

}