package vilas_daniel;

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

public class Exercicio_1ConversorTemperatura extends Application {

	public static void main(String[] args) {
		Application.launch(args);
	}

	@Override
	public void start(Stage stage) throws Exception {

		VBox root = new VBox();

		HBox primero = new HBox();
		HBox segundo = new HBox();
		HBox terceiro = new HBox();
		HBox cuarto = new HBox();

		// Creamos los label
		Label celsius = new Label("Celsius:");
		Label fahrenheit = new Label("Fahrenheit:");
		Label rslt = new Label("");


		// Creamos textfield
		TextField celsiusfield = new TextField();
		TextField fahrenheitfield = new TextField();

		celsiusfield.setPromptText("Introduce C: ");
		fahrenheitfield.setPromptText("Introduce F: ");

		// Celsius a Fahrenheit: F = (C × 9/5) + 32
		// Fahrenheit a Celsius: C = (F - 32) × 5/9

		// Creamos PRIMER boton y sus acciones
		Button btn1 = new Button("C a F");
		btn1.setOnAction(e -> {

			try {

				double ncelsius = Double.parseDouble(celsiusfield.getText());
				double resultado1 = (ncelsius * 9 / 5) + 32;

				rslt.setText(ncelsius + "ºC = " + +resultado1 + "ºF");
				rslt.setBackground(new Background(new BackgroundFill(Color.LIGHTGREEN, null, null)));
				;
				fahrenheitfield.setText(String.valueOf(resultado1));

			} catch (NumberFormatException e1) {

				rslt.setText("Introduce un valor válido");
				rslt.setBackground(new Background(new BackgroundFill(Color.RED, null, null)));
				;
			}
		});
		
		
		// Creamos SEGUNDO boton y sus acciones
		Button btn2 = new Button("F a C");
		btn2.setOnAction(e -> {

			try {

				double nfahrenheit = Double.parseDouble(fahrenheitfield.getText());
				double resultado2 = (nfahrenheit - 32) * 5/9;

				rslt.setText(nfahrenheit + "ºF = " + +resultado2 + "ºC");
				rslt.setBackground(new Background(new BackgroundFill(Color.LIGHTGREEN, null, null)));
				;
				celsiusfield.setText(String.valueOf(resultado2));

			} catch (NumberFormatException e2) {

				rslt.setText("Introduce un valor válido");
				rslt.setBackground(new Background(new BackgroundFill(Color.RED, null, null)));
				;
			}
		});
		
		// Creamos TERCER boton y sus acciones
		Button btn3 = new Button("Limpar");
		btn3.setOnAction(e -> {
		
		//Para eliminar los números al pulsar limpar
		celsiusfield.setText(null);
		fahrenheitfield.setText(null);
		rslt.setText(null);
		});
		
		root.setSpacing(10);
		primero.setSpacing(10);
		segundo.setSpacing(10);
		terceiro.setSpacing(10);

		// Indica el orden
		root.getChildren().addAll(primero, segundo, terceiro, cuarto);
		primero.getChildren().addAll(celsius, celsiusfield);
		segundo.getChildren().addAll(fahrenheit, fahrenheitfield);
		terceiro.getChildren().addAll(btn1, btn2, btn3);
		cuarto.getChildren().addAll(rslt );

		// Para que me aparezca la escena
		Scene scene = new Scene(root, 300, 200);
		stage.setTitle("Conversor de temperatura");
		stage.setScene(scene);
		stage.show();
	}

} 
//EXAMEN RESUELTO 
/*package calo_carmen;

import javafx.application.Application;
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

public class ControlDeVolume extends Application {

	@Override
	public void start(Stage stage) {
		IntegerProperty numero = new SimpleIntegerProperty();
		
		//Mostre unha xanela co título "Control de volume".
		stage.setTitle("Control de volume");
		
		//Teña un Slider que represente o nivel de volume, con valores entre 0 e 100. O valor inicial debe ser 50.
		Slider slidervolume = new Slider(0,100,50);
		slidervolume.setShowTickLabels(false);
		slidervolume.relocate(75, 150);
		
		//Mostre dúas etiquetas (Label):
		// --> Unha co texto: "Volume: X%" , que se actualiza automaticamente ao mover o Slider
		//     para o que terás que empregar vinculacións (bindings).
		Label lblvolume = new Label();	
		
		// Este slider o vinculamos á propiedade de texto do label
		numero.bind(slidervolume.valueProperty());
		lblvolume.textProperty().bindBidirectional(numero, new NumberStringConverter());

		// --> Outra que indique o estado do volume segundo o valor actual:
		// 		--> Se o volume é menor de 30 -> mostra "Baixo" .
     	//		--> Se o volume está entre 30 e 70 -> mostra "Medio" .
		// 		--> Se o volume é maior de 70 -> mostra "Alto" .
		Label lblestado = new Label();	
		StringBinding estado = new StringBinding() {
			{
				this.bind(numero);
			}

			@Override
			protected String computeValue() {
				int valor = numero.get();
				if(valor<30) {
					return "Baixo";
				} else if (valor >= 30 && valor <=70) {
					return "Medio";
				} else {
					return "Alto";
				}
			}
		};
		
		lblestado.textProperty().bind(estado);
		lblestado.relocate(130, 120);
		
		// O comportamento da aplicación debe basearse exclusivamente en bindings, sen empregar
		// 		listeners, if, nin chamadas a setText() manuais.
		// O layout pode ser un VBox con espaciado e aliñación centrada. Neste caso usei un Pane
		Pane root = new Pane();
		HBox volumen = new HBox();
		volumen.relocate(110, 85);
		volumen.getChildren().addAll(new Label("Volume: " ), lblvolume, new Label("%"));
		root.getChildren().addAll(volumen, lblestado, slidervolume);
		Scene scene = new Scene(root, 300, 300);
		stage.setScene(scene);
		stage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}
}*/