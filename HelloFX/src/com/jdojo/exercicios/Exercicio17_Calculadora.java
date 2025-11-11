package com.jdojo.exercicios;

import javafx.application.Application;
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

public class Exercicio17_Calculadora extends Application {

	@Override
	    public void start(Stage stage) {
		
	        DoubleProperty nome = new SimpleDoubleProperty();
	        IntegerProperty nome2 = new SimpleIntegerProperty();
	        
	        TextField prezoTexto = new TextField();
	        TextField cantidadTexto = new TextField();
	        
		//    nome.balanceProperty().bind(nome2.balanceProperty());

	    //    nome.balanceProperty().addListener((obs, oldValue, newValue)-> {
		//		System.out.println("O valor de acc2 antigo: " + oldValue);
		//		System.out.println("O valor de acc2 novo: " + newValue);
		//	});
	        
	    //    nome2.balanceProperty().addListener((obs, oldValue, newValue)-> {
		//		System.out.println("O valor de acc2 antigo: " + oldValue);
		//		System.out.println("O valor de acc2 novo: " + newValue);
		//	});
	        
	        prezoTexto.textProperty().unbindBidirectional(nome);
	        cantidadTexto.textProperty().unbindBidirectional(nome2);
	        
	        Label prezo = new Label("Prezo unitario:");
	        Label cantidad = new Label("Cantidade:");
	        Label total = new Label("Total: ");

	        
	       // Button botonCambiar = new Button("Cambiar a Invitado");
	        //botonCambiar.setOnAction(e -> nome.set("Invitado"));        

	        VBox root = new VBox(prezo, prezoTexto, cantidad, cantidadTexto);
	        Scene scene = new Scene(root, 300, 300);

	        stage.setScene(scene);
	        stage.setTitle("Calculadora de prezo total");
	        stage.show();
	    }

	public static void main(String[] args) {
	        launch();
	    }
}