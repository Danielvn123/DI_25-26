package com.jdojo.exercicios;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Exercicio08_MiniCalculadora extends Application {

	public static void main(String[] args) {
		Application.launch(args);
	}

	@Override
	public void start(Stage stage) throws Exception {
		
		// Para que salga en horizontal
		HBox root = new HBox();
		
		//Declaramos las etiquetas para poner los números
		TextField namefld1 = new TextField();
		TextField namefld2 = new TextField();
		namefld1.setPromptText("Operando 1");
		namefld2.setPromptText("Operando 2");

		//Declaramos el texto donde aparecera el resultado
		Label label1 = new Label("Resultado: ");
		
		//Declaramos botones
		Button btn1 = new Button("+");
		Button btn2 = new Button("-");
		Button btn3 = new Button("x");
		Button btn4 = new Button("/");
		
		//Acciones de los botones donde cada boton hace una función(suma,resta,multiplica y divide)
		btn1.setOnAction( e->{
			try {
				double op1 = Double.parseDouble(namefld1.getText());
				double op2 = Double.parseDouble(namefld2.getText());
	             label1.setText("Resultado: " + (op1 + op2));
		 } catch (NumberFormatException ex) {
             label1.setText("Ingrese números válidos");
         }
     });
		btn2.setOnAction( e->{
			try {
				double op1 = Double.parseDouble(namefld1.getText());
				double op2 = Double.parseDouble(namefld2.getText());
	             label1.setText("Resultado: " + (op1 - op2));
		 } catch (NumberFormatException ex) {
             label1.setText("Ingrese números válidos");
         }
     });
		btn3.setOnAction( e->{
			try {
				double op1 = Double.parseDouble(namefld1.getText());
				double op2 = Double.parseDouble(namefld2.getText());
	             label1.setText("Resultado: " + (op1 * op2));
		 } catch (NumberFormatException ex) {
             label1.setText("Ingrese números válidos");
         }
     });
		btn4.setOnAction( e->{
			try {
				double op1 = Double.parseDouble(namefld1.getText());
				double op2 = Double.parseDouble(namefld2.getText());
	             label1.setText("Resultado: " + (op1 / op2));
		 } catch (NumberFormatException ex) {
             label1.setText("Ingrese números válidos");
         }
     });

		//Para ver el orden de aparición en la escena
		root.getChildren().addAll(namefld1, namefld2, label1, btn1, btn2, btn3, btn4);

		// Para ver la escena
		Scene scene = new Scene(root, 600, 50);
		stage.setTitle("Mini calculadora");
		stage.setScene(scene);
		stage.show();
	}
}
