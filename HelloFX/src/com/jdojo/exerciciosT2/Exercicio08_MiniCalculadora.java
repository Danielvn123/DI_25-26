/*Enunciado

Crea unha aplicación JavaFX chamada Mini Calculadora que:

    Mostre unha xanela cun título "Mini Calculadora".
    Teña dous TextField para introducir os operandos.
    Mostre un Label onde se visualizará o resultado das operacións.
    Inclúa catro botóns coas operacións básicas: +, -, x, /.
    Ao premer un botón, debe realizar a operación correspondente entre os dous operandos e mostrar o resultado no Label.
    Se algún dos campos contén un número non válido, mostrarase a mensaxe "Falta algún operando".

Requisitos técnicos:

    A clase principal debe herdar de Application.
    Implementa o método start(Stage stage) que configura a interface gráfica.
    A interface debe estar organizada usando un HBox como contedor raíz.
    A xanela debe ter un tamaño de 600x50 píxeles.
    Implementa unha función auxiliar isNumeric(String str) que comprobe se unha cadea é un número válido.
    Emprega Double.parseDouble(...) para converter os operandos antes de operar.

Exercicio 8
Pista:

Podes usar try/catch para capturar excepcións de conversión numérica e validar os datos introducidos.*/

package com.jdojo.exerciciosT2;

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
/*import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class Exercicio08 extends Application {
	
	// Esta función a metemos para verificar que o que se mete nos TextField son números.
	
	private boolean isNumeric(String str) {
	    if (str == null || str.isEmpty()) {
	        return false;
	    }
	    try {
	        Double.parseDouble(str);
	        return true;
	    } catch (NumberFormatException e) {
	        return false;
	    }
	}

	@Override
	public void start(Stage stage) {

		stage.setTitle("Mini Calculadora");

		// Precisamos dous TextField e un Label para o resultado

		TextField txtFld1 = new TextField("Operando 1");
		TextField txtFld2 = new TextField("Operando 2");

		Label result = new Label("Resultado: ");

		// Precisamos os botóns das operacións

		Button sumarBtn = new Button("+");
		Button restarBtn = new Button("-");
		Button multiplicaBtn = new Button("x");
		Button divideBtn = new Button("/");

		// Accións para os botóns

		sumarBtn.setOnAction(e -> {
			if (isNumeric(txtFld1.getText()) && isNumeric(txtFld2.getText())) {
				result.setText(
						String.valueOf(Double.parseDouble(txtFld1.getText()) + Double.parseDouble(txtFld2.getText())));
			} else {
				result.setText("Falta algún operando");
			}
		});
		restarBtn.setOnAction(e -> {
			if (isNumeric(txtFld1.getText()) && isNumeric(txtFld2.getText())) {
				result.setText(
						String.valueOf(Double.parseDouble(txtFld1.getText()) - Double.parseDouble(txtFld2.getText())));
			} else {
				result.setText("Falta algún operando");
			}
		});
		multiplicaBtn.setOnAction(e -> {
			if(isNumeric(txtFld1.getText()) && isNumeric(txtFld2.getText())) {	
				result.setText(String.valueOf(Double.parseDouble(txtFld1.getText()) *
						Double.parseDouble(txtFld2.getText())));
			} else {
				result.setText("Falta algún operando");
			}	
		});
		divideBtn.setOnAction(e -> {
			if(isNumeric(txtFld1.getText()) && isNumeric(txtFld2.getText())) {	
				result.setText(String.valueOf(Double.parseDouble(txtFld1.getText()) /
						Double.parseDouble(txtFld2.getText())));
			} else {
				result.setText("Falta algún operando");
			}	
		});
		
		HBox root = new HBox();
		root.getChildren().addAll(txtFld1,txtFld2,result,sumarBtn,restarBtn,multiplicaBtn,divideBtn);
		
		Scene scene = new Scene(root,600,50);
		stage.setScene(scene);
		stage.show();		
		
		
		
	}

	public static void main(String[] args) {
		Application.launch(args);
	}
}
*/