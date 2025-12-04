package vilas_daniel;

import javafx.application.Application;
import javafx.beans.binding.Bindings;
import javafx.beans.binding.StringBinding;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.util.converter.NumberStringConverter;

public class Exercicio_2ControlVolume extends Application {
	
	public void start(Stage stage) throws Exception {

		Pane root = new Pane();
		
		Slider sliderH = new Slider(0, 100, 50);
		
		IntegerProperty numero1 = new  SimpleIntegerProperty();
		
		Label lbl1 = new Label();
		Label lbl2 = new Label();
		
		numero1.bind(sliderH.valueProperty());
		lbl2.textProperty().bindBidirectional(numero1, new NumberStringConverter());
		
				
		sliderH.setShowTickLabels(true);
		sliderH.setMajorTickUnit(100);
		sliderH.relocate(80, 80);
		lbl2.relocate(140,40);
		
		root.getChildren().addAll(lbl1, lbl2, sliderH);
	
		// Creamos la escena
		Scene scene = new Scene(root, 300, 250);
		stage.setTitle("Control de volume");
		stage.setScene(scene);
		stage.show();
	}

	public static void main(String[] args) {
		launch();
	}
}
//EXAMEN RESUELTO
/*package calo_carmen;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class ConvertorDeTemperatura extends Application {

	@Override
	public void start(Stage stage) {
		
		//Mostre unha xanela co título "Conversor de temperaturas" .
		stage.setTitle("Conversor de temperaturas");
		
		// Teña dous TextField para introducir temperaturas: un para Celsius e outro para Fahrenheit.
		TextField tfcelsius = new TextField();
		tfcelsius.setPromptText("Introduce ºC");
		TextField tffahrenheit = new TextField();
		tffahrenheit.setPromptText("Introduce ºF");
		
		//Teña dúas etiquetas Label que identifiquen cada campo: "Celsius:" e "Fahrenheit:" .
		Label lblcelsius = new Label("Celsius:");
		Label lblfahrenheit = new Label("Fahrenheit:");
		
		// Inclúa dous botóns:
		// --> "C a F" : Converte de Celsius a Fahrenheit.
		// --> "F a C" : Converte de Fahrenheit a Celsius
		Button btnCaF = new Button("C a F");
		Button btnFaC = new Button("F a C");
		
		//Mostre un Label de resultado que amose a funcion do boton 
		Label lblresultado = new Label("");
		
		//Función dos boton de conversion
		// --> Amose a conversión realizada con formato: "25°C = 77°F" ou "77°F = 25°C" .
		// --> Se o campo está baleiro ou o valor non é numérico, mostre "Introduce un valor
		//     válido" con fondo vermello.
		// --> Se a conversión é correcta, mostre o resultado con fondo verde claro.
		btnCaF.setOnAction(e -> {
			
			try {
				
		        //Celsius a Fahrenheit: F = (C × 9/5) + 32
				
				double celsius = Double.parseDouble(tfcelsius.getText());
				double resultado1 = (celsius * 9 / 5) + 32;
				
				lblresultado.setText(String.format("%.2fºC =  %.2fºF", celsius, resultado1));
				lblresultado.setBackground(new Background (new BackgroundFill(Color.LIGHTGREEN, null, null)));
				tffahrenheit.setText(String.valueOf(resultado1));
		        
		    } catch (NumberFormatException e1) {
		    	
		    	lblresultado.setText("Introduce un valor válido");
		    	lblresultado.setBackground(new Background (new BackgroundFill(Color.SALMON, null, null)));
		        
		    }
			
		});
		
		btnFaC.setOnAction(e -> {
			
			try {
				
		        //Fahrenheit a Celsius: C = (F - 32) × 5/9
				
				double fahrenheit = Double.parseDouble(tffahrenheit.getText());
				double resultado2 = (fahrenheit - 32) * 5/9;
				
				lblresultado.setText(String.format("%.2fºF =  %.2fºC", fahrenheit, resultado2));
				lblresultado.setBackground(new Background (new BackgroundFill(Color.LIGHTGREEN, null, null)));
				tfcelsius.setText(String.valueOf(resultado2));
		        
		    } catch (NumberFormatException e1) {
		    	
		    	lblresultado.setText("Introduce un valor válido");
		    	lblresultado.setBackground(new Background (new BackgroundFill(Color.SALMON, null, null)));
		        
		    }
			
		});

		//Inclúa un botón "Limpar" para que limpe os textfields
		Button btnLimpar = new Button("Limpar");
		
		//Funcions do boton de limpar
		// --> Limpe os TextField.
		// --> Restableza o Label de resultado ao texto inicial.
		// --> Elimine calquera estilo aplicado ao Label.
		
		btnLimpar.setOnAction(e -> {
			
			tfcelsius.setText("");
			tffahrenheit.setText("");
			lblresultado.setText(null);
			lblresultado.setBackground(new Background (new BackgroundFill(null, null, null)));
			
			
		});
		
		//Formatea os resultados a 2 decimais. (feito no das accions dos botons, máis arriba):
		//lblresultado.setText(String.format("%.2fºF =  %.2fºC", fahrenheit, resultado2));
		//lblresultado.setText(String.format("%.2fºC =  %.2fºF", celsius, resultado1));
		
		//HBox para as filas horizontais (celsius, fahrenheit, botons)
		HBox celsius = new HBox();
		celsius.getChildren().addAll(lblcelsius, tfcelsius);
		HBox fahreinheit = new HBox();
		fahreinheit.getChildren().addAll(lblfahrenheit, tffahrenheit);
		HBox botons = new HBox();
		botons.getChildren().addAll(btnCaF, btnFaC, btnLimpar);
		VBox root = new VBox();
		root.getChildren().addAll(celsius, fahreinheit, botons, lblresultado);
		
		//Espacio entre componentes (spacing e pading)
		root.setSpacing(10);
		celsius.setSpacing(10);
		fahreinheit.setSpacing(10);
		botons.setSpacing(10);
		root.setStyle("-fx-padding: 10;");
		
		//mostrar escena (tamaño de esta mesma tamen) e stage
		Scene scene = new Scene(root, 300, 250);
		stage.setScene(scene);
		stage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}
}*/
