package com.jdojo.exerciciosT3;

import static javafx.stage.Modality.*;
import static javafx.stage.StageStyle.*;


import java.util.ArrayList;
import java.util.List;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class Exercicio09_CreadorXanela extends Application {
	
	// Creamos o array que conterá as Stage fillas
	private List<Stage> xanelasFillas = new ArrayList<>();
	
	@Override
	public void start(Stage stage) {

		// Creamos a primeira fila. O constructor ComboBox recibe un ObservableList
		ComboBox<StageStyle> estiloCombo = new ComboBox<>(
				FXCollections.observableArrayList(DECORATED, UNDECORATED, TRANSPARENT, UNIFIED, UTILITY));
		estiloCombo.setValue(DECORATED);
		HBox estiloLayout = new HBox(10, new Label("Estilo: "), estiloCombo);
		
		// Creamos a segunda fila.
		ComboBox<Modality> modalidadeCombo = new ComboBox<>(
				FXCollections.observableArrayList(NONE, WINDOW_MODAL, APPLICATION_MODAL));
		modalidadeCombo.setValue(NONE);
		HBox modalidadeLayout = new HBox(10, new Label("Modalidade: "), modalidadeCombo);
		
		// A terceira fila ten un slider
		Slider opacidadeSlider = new Slider(0.0, 1.0, 1.0);
		opacidadeSlider.setShowTickLabels(true);
		HBox opacidadeLayout = new HBox(10, new Label("Opacidade: "), opacidadeSlider);

		
		// A cuarta fila. O checkBox por defecto está a true 
		CheckBox redimensionableCheck = new CheckBox("Redimensionable");
		redimensionableCheck.setSelected(true);
		
		// Dous botóns na última fila
		Button crearBtn = new Button ("Crear xanela");
		crearBtn.setOnAction(e -> {
			abrirXanela(stage, estiloCombo.getValue(), modalidadeCombo.getValue(),
					opacidadeSlider.getValue(), redimensionableCheck.isSelected());
		});
		
		Button pecharBtn = new Button ("Pechar todas");
		pecharBtn.setOnAction(e -> {
			 for (Stage filla : xanelasFillas) {
				 filla.close();
		        }
			 xanelasFillas.clear();
		});
		
		HBox botonsLayout = new HBox(10, crearBtn, pecharBtn);
		
		VBox root = new VBox(10, 
				estiloLayout, 
				modalidadeLayout,
				opacidadeLayout,
				redimensionableCheck,
				botonsLayout				
				);
		
		Scene scene = new Scene(root,300,200);
		stage.setTitle("Creador de xanelas");
		stage.setScene(scene);
		stage.show();
		}

	private void abrirXanela(Stage stage, StageStyle estilo, Modality modalidade, Double opacity, boolean redimensionable) {
		// Novo stage
		Stage xanela = new Stage();
		xanela.initOwner(stage);
		xanela.initStyle(estilo);
		xanela.initModality(modalidade);
		xanela.setOpacity(opacity);
		xanela.setResizable(redimensionable);
		// Engadimos á lista para levar a conta
		xanelasFillas.add(xanela);
		xanela.setTitle("Xanela filla " + xanelasFillas.size());
		
		Button aceptarBtn = new Button("Aceptar");
		aceptarBtn.setOnAction(e -> xanela.close());
		 
		// Aqui teremos a seguinte información
		VBox info = new VBox(
				new Label("Estilo: "+ estilo),
				new Label("Modalidade: "+ modalidade),
				new Label("Opacidade: "+ opacity),
				new Label("Redimensionable: "+ redimensionable));
		
		// Creamos un botón para pechar naqueles casos onde non poidamos
		// darlle a x de pechar ou non poidamos darlle ao botón de pechar todas
		if(!modalidade.equals(NONE) && (estilo.equals(UNDECORATED)|| estilo.equals(TRANSPARENT))) {
			info.getChildren().add(aceptarBtn);
		}
		Scene scene = new Scene(info, 250, 100);
		xanela.setScene(scene);
		
		 if (estilo.equals(TRANSPARENT) ) {
	            scene.setFill(null);
	            info.setStyle("-fx-background-color: transparent;");
	        }
		xanela.show();				
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