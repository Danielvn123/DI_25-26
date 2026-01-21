package vilas_daniel;

	import static javafx.stage.Modality.*;
	import static javafx.stage.StageStyle.*;


	import java.util.ArrayList;
	import java.util.List;

	import javafx.application.Application;
import javafx.beans.binding.Bindings;
import javafx.collections.FXCollections;
	import javafx.scene.Scene;
	import javafx.scene.control.Button;
	import javafx.scene.control.CheckBox;
	import javafx.scene.control.ComboBox;
	import javafx.scene.control.Label;
import javafx.scene.control.Labeled;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
	import javafx.scene.layout.VBox;
	import javafx.stage.Modality;
	import javafx.stage.Stage;
	import javafx.stage.StageStyle;

	public class Exercicio2OpacidadeLimitesVenta extends Application {
		
	    private Label resultadoLabel = new Label();

		
		public void start(Stage stage) {
			// O primeiro é crear os controis
			Label opacityLabel = new Label("Opacidade:");

			Label opacityLabel2 = new Label("Opacidade:");
			
			//El primer 0.0 es el principio, el 1.0 es el final y el 1.0 es como quiero que salga por pantalla.
			Slider opacitySlider = new Slider(0.0, 1.0, 1);

			TextField minWidthField = new TextField("200");
			TextField minHeightField = new TextField("150");
			TextField maxWidthField = new TextField("800");
			TextField maxHeightField = new TextField("600");

			Button aplicarLimitesBtn = new Button("Aplicar Límites");
			Label avisoLabel = new Label();
		
			
		/*	Button erroBtn = new Button("Diálogo erro");
		        erroBtn.setOnAction(e -> {
		        	("Erro", "Ocorreu un erro inesperado na aplicación.",
		        			"✖", "-fx-background-color: lightcoral;");
		        	resultadoLabel.setText("Diálogo Erro: Aceptado");
		        });*/



			// Ligamos a propiedade de opacidade ao valor do slider
			stage.opacityProperty().bind(opacitySlider.valueProperty());

			// O Label está ligado a un texto personalizado que dependerá do valor do slider.
			// Bindings.createStringBinding(lambda, propiedade)
			opacityLabel.textProperty().bind(Bindings.createStringBinding(
					() -> String.format("Opacidade: %.2f", opacitySlider.getValue()), opacitySlider.valueProperty())
			);
			

			aplicarLimitesBtn.setOnAction(e -> {
				try {
					double minWidth = Double.parseDouble(minWidthField.getText());
					double minHeight = Double.parseDouble(minHeightField.getText());
					double maxWidth = Double.parseDouble(maxWidthField.getText());
					double maxHeight = Double.parseDouble(maxHeightField.getText());

					// Validamos que os valores teñan lóxica
					if (minWidth > maxWidth || minHeight > maxHeight) {
						avisoLabel.setText("Os valores mínimos non poden ser maiores que os máximos!");
						avisoLabel.setStyle("-fx-text-fill: red;");
						return;
					}

					stage.setMinWidth(minWidth);
					stage.setMinHeight(minHeight);
					stage.setMaxWidth(maxWidth);
					stage.setMaxHeight(maxHeight);

					avisoLabel.setText("Límites aplicados correctamente!");
					avisoLabel.setStyle("-fx-text-fill: green;");

				} catch (NumberFormatException ex) {
					avisoLabel.setText("Introduce valores numéricos válidos!");
					avisoLabel.setStyle("-fx-text-fill: red;");
				}
			});

				
			// Creo primeiro os HBox

			
			HBox opacidadeLayout = new HBox(opacityLabel2, opacitySlider);
			HBox anchoMinLayout = new HBox(10, new Label("Ancho mín:"), minWidthField);
			HBox altoMinLayout = new HBox(10, new Label("Alto mín:"), minHeightField);
			HBox anchoMaxLayout = new HBox(10, new Label("Ancho máx:"), maxWidthField);
			HBox altoMaxLayout = new HBox(10, new Label("Alto máx:"), maxHeightField);

			
			VBox root = new VBox(10, new Label("Control de opacidade"),
					opacidadeLayout,
					new Label("Límites de tamaño:"),
					anchoMinLayout,
					anchoMaxLayout,
					altoMinLayout,
					altoMaxLayout,
					aplicarLimitesBtn,
					avisoLabel				
					);
			
	        root.setStyle("-fx-padding: 5; -fx-alignment: center;");

	        Scene scene = new Scene(root, 400, 350);
			stage.setScene(scene);
			stage.setTitle("Controlador de propiedades do Stage");
			stage.show();
		}

			
	        private void mostrarDialogo(String titulo, String mensaxe, String icono, String estilo) {
	            Stage dialogo = new Stage();
	            dialogo.initModality(Modality.APPLICATION_MODAL);
	            
	            // Creamos a mensaxe 
	            Label iconLabel = new Label(icono);
	            iconLabel.setStyle("-fx-alignment: center; -fx-font-size: 24;");
	            Label mensaxeLbl = new Label(mensaxe);
	            mensaxeLbl.setStyle("-fx-alignment: center; -fx-font-size: 12;");
	                
	            HBox mensaxeLayout = new HBox(10, iconLabel, mensaxeLbl);
	            mensaxeLayout.setStyle("-fx-alignment: center;");
	            
	            HBox botonsLayout = new HBox(10);
	            botonsLayout.setStyle("-fx-alignment: center;");

	            // Creamos un botón de aceptar, no caso da confirmación crearemos dous botóns
	            if(titulo.equals("Confirmación")) {
	            	Button siBtn = new Button ("Si");
	            	siBtn.setOnAction(e -> {
	            		resultadoLabel.setText("Diálogo confirmación: Si");
	            		dialogo.close();
	            	});
	            	Button nonBtn = new Button ("Non");
	            	nonBtn.setOnAction(e -> {
	            		resultadoLabel.setText("Diálogo confirmación: Non");
	            		dialogo.close();
	            	});
	            	botonsLayout.getChildren().addAll(siBtn,nonBtn);
	            } else {
	            	Button aceptarBtn = new Button ("Aceptar");
	            	aceptarBtn.setOnAction(e -> {
	            		dialogo.close();
	            	});
	            	botonsLayout.getChildren().add(aceptarBtn);
	            }
	            
	            
	            VBox root = new VBox(mensaxeLayout, botonsLayout);
	            root.setStyle("-fx-alignment: center;" + estilo);
	            
	            Scene scene = new Scene(root, 300, 100);
	            dialogo.setScene(scene);
	            dialogo.setTitle(titulo);
	            dialogo.showAndWait();
	      
	        }
	        
		
		public static void main(String[] args) {
			launch(args);
		}
	}
	/*Exercicio 9 Creador de xanelas

	Neste exercicio crearemos unha aplicación que permita crear xanelas fillas con diferentes estilos e modalidades.
	Intruccións

	    A referencia as xanelas creadas ímolas almacenar nun array, para posteriormente poder pechar todas as xanelas fillas ao mesmo tempo. Para isto podemos crear un atributo a nivel de clase para que tódolos métodos da clase poidan acceder a esta lista: private List<Stage> xanelasFillas = new ArrayList<>();

	    A nivel gráfico temos:
	        Un ComboBox para seleccionar o estilo da xanela (decorada, sen decorar, transparente, unificada, utilidade).
	        Un ComboBox para seleccionar a modalidade da xanela (ningunha, modal de xanela, modal de aplicación).
	        Un Slider para seleccionar a opacidade da xanela.
	        Un CheckBox para indicar se a xanela é redimensionable.
	        Dous botóns para crear a xanela e pechar todas as xanelas fillas.

	    Ao premer o botón de crear a xanela, esta abrirase coa configuración seleccionada. Nela aparecerá a información seguinte:
	        O título da xanela no formato: Xanela filla [x] onde x é o número da xanela (empezando por 1).
	        O estilo da xanela.
	        A modalidade da xanela.
	        A opacidade da xanela.
	        Se a xanela é redimensionable ou non.

	    O botón de pechar todas a xanelas fillas pechará todas as xanelas que se abriron.

	Ollo

	O botón de pechar todas non funcionará no caso de que as xanelas fillas estean en modo Window Modal ou Application Modal. Cando o estilo da xanela teña os botóns de peche, como DECORATED ou UTILITY, no haberá problema. No obstante, deberemos crear un botón de peche cando as xanelas non teñan os botóns de peche, xa que senón a aplicación quedará bloqueada.*/
