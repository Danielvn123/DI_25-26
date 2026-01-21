package com.jdojo.fxmlexercicios.Controlador;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class Ex3 extends Application {
	
	public void start(Stage stage) throws Exception{
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(Ex1.class.getResource("/com/jdojo/fxmlexercicios/Vista/Ex3Vista.fxml"));
		
		// Crear unha vista
		
		Pane ventana = loader.load();
		
		Scene scene = new Scene(ventana);
		
		stage.setScene(scene);
		stage.show();
			
	}
	
	public static void main(String[] args) {
		launch(args);
	}

}
