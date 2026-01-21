package vilas_daniel;

	import static javafx.stage.Modality.NONE;
import static javafx.stage.StageStyle.DECORATED;
import static javafx.stage.StageStyle.TRANSPARENT;
import static javafx.stage.StageStyle.UNDECORATED;
import static javafx.stage.StageStyle.UNIFIED;
import static javafx.stage.StageStyle.UTILITY;

import java.util.ArrayList;
import java.util.List;

import javafx.application.Application;
import javafx.beans.binding.Bindings;
import javafx.collections.FXCollections;
import javafx.geometry.Rectangle2D;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Modality;
import javafx.stage.Screen;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

	public class Exercicio1XestorXanelas extends Application {
		
		private List<Stage> xanelasFillas = new ArrayList<>();

	    @Override
	    public void start(Stage stage) {
	        stage.setTitle("Xestor de múltiples xanelas");
	        
			Label label = new Label("Configuración da nova xanela");
			Label label2 = new Label("Título:");

			TextField Field = new TextField(" ");

			// A segunda ten un slider
			Slider anchoSlider = new Slider(200, 800, 250);
			anchoSlider.setShowTickLabels(true);
			HBox anchoLayout = new HBox(10, new Label("Ancho: "), anchoSlider);
			
			// A terceira ten un slider
			Slider altoSlider = new Slider(150, 600, 120);
			altoSlider.setShowTickLabels(true);
			HBox altoLayout = new HBox(10, new Label("Alto: "), altoSlider);
			
			ComboBox<StageStyle> estiloCombo = new ComboBox<>(
					FXCollections.observableArrayList(DECORATED, UNDECORATED, UTILITY));
			estiloCombo.setValue(UNDECORATED);
			HBox estiloLayout = new HBox(10, new Label("Estilo: "), estiloCombo);
			
			CheckBox redimensionableCheck = new CheckBox("Maximizar ao abrir");
			redimensionableCheck.setSelected(false);
			
			anchoSlider.accessibleTextProperty()
			.bind(Bindings.concat("Ancho: ", stage.widthProperty(), "valor: ", stage.heightProperty()));
			
			
			altoSlider.accessibleTextProperty()
			.bind(Bindings.concat("Alto: ", stage.widthProperty(), "valor: ", stage.heightProperty()));
			
			// Para maximizar debemos conseguir os límites visuais
			redimensionableCheck.setOnAction(e -> {
				Rectangle2D visualBounds = Screen.getPrimary().getVisualBounds();
				stage.setX(visualBounds.getMinX());
				stage.setWidth(visualBounds.getMaxX());
				stage.setY(visualBounds.getMinY());
				stage.setHeight(visualBounds.getMaxY());
			});
			
			// Dous botóns na última fila
			Button crearBtn = new Button ("Crear xanela");
			crearBtn.setOnAction(e -> {
				abrirVenta(estiloCombo.getValue(), false);
			});
			
			Button pecharBtn = new Button ("Pechar todas");
			pecharBtn.setOnAction(e -> {
				 for (Stage filla : xanelasFillas) {
					 filla.close();
			        }
				 xanelasFillas.clear();
			});
			
			
			HBox botonsLayout = new HBox(10, crearBtn, pecharBtn);
			
			
	        VBox root = new VBox(10, label, label2, Field, anchoLayout,altoLayout, estiloLayout, redimensionableCheck, botonsLayout);
	        Scene scene = new Scene(root, 400, 350);
	        
	        root.setStyle("-fx-padding: 5; -fx-alignment: center;");

	        
	        
	        stage.setScene(scene);
	        stage.show();
	    }
	    
	    private void abrirVenta(StageStyle estilo, boolean redimensionable) {
	        Stage secundario = new Stage();
	        // iniciamos o estilo antes de amosalo
	        secundario.initStyle(estilo);
	        secundario.setResizable(redimensionable);


	        Label lbl = new Label("Titulo: Xanela " + estilo.toString());
	        Label lb2 = new Label("Dimensión: " + redimensionable);
	        Label lb3 = new Label("Posición:  " + estilo.toString());

	        
	        Button btnPechar = new Button("Pechar");
	        btnPechar.setOnAction(e -> secundario.close());

	        VBox layout = new VBox(15, lbl, lb2, lb3, btnPechar);
	        layout.setStyle("-fx-padding: 20; -fx-background-color: lightgreen;");

	        Scene escena = new Scene(layout, 250, 150);
	      

	        secundario.setScene(escena);
	        secundario.setTitle("Xanela secundaria - " + estilo);
	        secundario.show();
	    }

	    public static void main(String[] args) {
	        launch();
	    }
	}
