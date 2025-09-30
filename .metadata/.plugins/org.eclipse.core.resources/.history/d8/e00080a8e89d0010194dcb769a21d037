package com.jdojo.intro;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
public class CambiarColorDeFondo extends Application {
	
		public static void main(String[] args) {
			Application.launch(args);
		}

		@Override
		public void start(Stage stage) throws Exception {
			VBox root = new VBox();
			
			Button btn = new Button ("Vermello");
			Button btn2 = new Button ("Verde");
			Button btn3 = new Button ("Azul");

			btn.setOnAction(e -> {
				root.setBackground(new Background(new BackgroundFill(Color.RED, null, null)));			
			});	
			btn2.setOnAction(e -> {
				root.setBackground(new Background(new BackgroundFill(Color.GREEN, null, null)));				
			});	
			btn3.setOnAction(e -> {
				root.setBackground(new Background(new BackgroundFill(Color.BLUE, null, null)));		
			});	
			root.getChildren().addAll(btn,btn2,btn3);

			Scene scene = new Scene(root, 300, 200);
			stage.setScene(scene);
			stage.setTitle("Miña primeira xanela");
			stage.show();
		}

	}