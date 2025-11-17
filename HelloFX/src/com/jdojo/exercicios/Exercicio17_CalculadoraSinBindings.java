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

public class Exercicio17_CalculadoraSinBindings extends Application {

	@Override
	public void start(Stage stage) throws Exception {

		DoubleProperty prezo_unitario = new SimpleDoubleProperty();
		IntegerProperty cantidade = new SimpleIntegerProperty();

		// Campos de entrada
		TextField prezo_unitario1 = new TextField();
		TextField cantidade1 = new TextField();

		// Etiqueta prezo total
		Label prezoTotal = new Label();

		//Listener para as propiedades
		prezo_unitario.addListener((obs, oldValue, newValue) -> {
			double total = newValue.doubleValue() * cantidade.get();
			prezoTotal.setText(String.format("Total: %.2f €", total));
		});

		//Listener para os campos
		cantidade.addListener((obs, oldValue, newValue) -> {
			double total = newValue.doubleValue() * prezo_unitario.get();
			prezoTotal.setText(String.format("Total: %.2f €", total));
		});

		prezo_unitario1.textProperty().addListener((obs, oldValue, newValue) -> {
			try {
				if (!newValue.isEmpty()) {
					prezo_unitario.set(Double.parseDouble(newValue));
				}
			} catch (NumberFormatException e) {

			}
		});

		cantidade1.textProperty().addListener((obs, oldValue, newValue) -> {
			try {
				cantidade.set(Integer.parseInt(newValue));
			} catch (NumberFormatException e) {

			}
		});

		VBox root = new VBox(new Label("Precio unitario:"), prezo_unitario1, new Label("Precio cantidade"), cantidade1,
				prezoTotal);
		Scene scene = new Scene(root, 300, 300);

		stage.setScene(scene);
		stage.setTitle("Calculadora de prezo total(listeners manuais)");
		stage.show();
	}

	public static void main(String[] args) {
		launch();
	}
}
//SIN DESCUENTO 
/*import javafx.application.Application;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Exercicio17 extends Application {
	 @Override
	    public void start(Stage stage) {
	        // Modelo de datos
	        DoubleProperty prezo_unitario = new SimpleDoubleProperty();
	        IntegerProperty cantidade = new SimpleIntegerProperty();

	        // Campos de entrada
	        TextField prezo_unitarioField = new TextField();
	        TextField cantidadeField = new TextField();

	        // Etiqueta para o prezo total
	        Label prezoTotalField = new Label("Total: 0.00€");

	        // Listener manual para actualizar o total cando cambia o prezo_unitario
	        prezo_unitario.addListener((obs, oldVal, newVal) -> {
	            double total = newVal.doubleValue() * cantidade.get();
	            prezoTotalField.setText(String.format("Total: %.2f€", total));
	        });

	        // Listener para actualizar o total cando cambia a cantidade
	        cantidade.addListener((obs, oldVal, newVal) -> {
	            double total = prezo_unitario.get() * newVal.intValue();
	            prezoTotalField.setText(String.format("Total: %.2f€", total));
	        });

	        // Listener para entrada de texto no campo prezo_unitario
	        prezo_unitarioField.textProperty().addListener((obs, oldVal, newVal) -> {
	            try {
	                if (!newVal.isEmpty()) {
	                    prezo_unitario.set(Double.parseDouble(newVal));
	                }
	            } catch (NumberFormatException e) {
	                // Ignorar valores inválidos
	            }
	        });

	        // Listener para entrada de texto no campo cantidade
	        cantidadeField.textProperty().addListener((obs, oldVal, newVal) -> {
	            try {
	                if (!newVal.isEmpty()) {
	                    cantidade.set(Integer.parseInt(newVal));
	                }
	            } catch (NumberFormatException e) {
	                // Ignorar valores inválidos
	            }
	        });

	        VBox root = new VBox(
	            new Label("Precio unitario:"), prezo_unitarioField,
	            new Label("Cantidade:"), cantidadeField,
	            prezoTotalField
	        );

	        Scene scene = new Scene(root, 300, 200);
	        stage.setScene(scene);
	        stage.setTitle("Calculadora de prezo total (listeners manuais)");
	        stage.show();
	    }

	    public static void main(String[] args) {
	        launch();
	    }
}*/

//CON DESCUENTO 
/*import javafx.application.Application;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Exercicio_17_extra extends Application {
	@Override
    public void start(Stage stage) {
        // Modelo de datos
        DoubleProperty prezo_unitario = new SimpleDoubleProperty();
        IntegerProperty cantidade = new SimpleIntegerProperty();
        
        //- 1 Incorporamos o dato desconto
        DoubleProperty desconto = new SimpleDoubleProperty();

        // Campos de entrada
        TextField prezo_unitarioField = new TextField();
        TextField cantidadeField = new TextField();
        //- 2 Incorporamos o campo desconto
        TextField descontoField = new TextField();

        // Etiqueta para o prezo total
        Label prezoTotalField = new Label("Total: 0.00€");

        //- 5 Dependendo do valor do totalConDesconto mandamos a alerta ou non cun if normal
        Label alertLbl = new Label();

        //- 3 Agora o prezoTotal tamén deberá escoitar ao desconto por se cambia polo que engadimos un listener a desconto e refacer os outros listener para que no calculo teñan en conta o que vale desconto
                      
        desconto.addListener((obs, oldVal, newVal) -> {
        	double total = prezo_unitario.get() * cantidade.get();
        	double totalConDesconto = total * (1 - (newVal.doubleValue()/100));
            prezoTotalField.setText(String.format("Total: %.2f€", totalConDesconto));
            if (totalConDesconto > 100) alertLbl.setText("Prezo alto");
            else alertLbl.setText("");
        });
        

        // Listener manual para actualizar o total cando cambia o prezo_unitario
        prezo_unitario.addListener((obs, oldVal, newVal) -> {
            double total = newVal.doubleValue() * cantidade.get();
            double totalConDesconto = total * (1 - (desconto.get()/100));
            prezoTotalField.setText(String.format("Total: %.2f€", totalConDesconto));
            if (totalConDesconto > 100) alertLbl.setText("Prezo alto");
            else alertLbl.setText("");
        });

        // Listener para actualizar o total cando cambia a cantidade
        cantidade.addListener((obs, oldVal, newVal) -> {
            double total = prezo_unitario.get() * newVal.intValue();
            double totalConDesconto = total * (1 - (desconto.get()/100));
            prezoTotalField.setText(String.format("Total: %.2f€", totalConDesconto));
            if (totalConDesconto > 100) alertLbl.setText("Prezo alto");
            else alertLbl.setText("");
        });

        // Listener para entrada de texto no campo prezo_unitario
        prezo_unitarioField.textProperty().addListener((obs, oldVal, newVal) -> {
            try {
                if (!newVal.isEmpty()) {
                    prezo_unitario.set(Double.parseDouble(newVal));
                }
            } catch (NumberFormatException e) {
                // Ignorar valores inválidos
            }
        });

        // Listener para entrada de texto no campo cantidade
        cantidadeField.textProperty().addListener((obs, oldVal, newVal) -> {
            try {
                if (!newVal.isEmpty()) {
                    cantidade.set(Integer.parseInt(newVal));
                }
            } catch (NumberFormatException e) {
                // Ignorar valores inválidos
            }
        });
     
        //- 4 Listener para entrada de texto no campo desconto
        descontoField.textProperty().addListener((obs, oldVal, newVal) -> {
            try {
                if (!newVal.isEmpty()) {
                    desconto.set(Integer.parseInt(newVal));
                }
            } catch (NumberFormatException e) {
                // Ignorar valores inválidos
            }
        });

        
        VBox root = new VBox(
            new Label("Precio unitario:"), prezo_unitarioField,
            new Label("Cantidade:"), cantidadeField,
            new Label("Desconto:"), descontoField,
            prezoTotalField,
            alertLbl
        );

        Scene scene = new Scene(root, 300, 200);
        stage.setScene(scene);
        stage.setTitle("Calculadora de prezo total (listeners manuais)");
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }*/