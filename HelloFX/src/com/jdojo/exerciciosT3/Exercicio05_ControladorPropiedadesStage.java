package com.jdojo.exerciciosT3;

import javafx.application.Application;
import javafx.beans.binding.Bindings;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Exercicio05_ControladorPropiedadesStage extends Application {

	@Override
	public void start(Stage stage) {
		// O primeiro é crear os controis
		Label opacityLabel = new Label("Opacidade: 1.0");
		
		//El primer 0.0 es el principio, el 1.0 es el final y el 1.0 es como quiero que salga por pantalla.
		Slider opacitySlider = new Slider(0.0, 1.0, 1.0);

		CheckBox resizableBox = new CheckBox("Redimensionable");
		//Que se pueda redimensionar
		resizableBox.setSelected(true);

		TextField minWidthField = new TextField("200");
		TextField minHeightField = new TextField("150");
		TextField maxWidthField = new TextField("800");
		TextField maxHeightField = new TextField("600");

		Button aplicarLimitesBtn = new Button("Aplicar Límites");
		Label avisoLabel = new Label();

		// Ligamos a propiedade de opacidade ao valor do slider
		stage.opacityProperty().bind(opacitySlider.valueProperty());

		// O Label está ligado a un texto personalizado que dependerá do valor do slider.
		// Bindings.createStringBinding(lambda, propiedade)
		opacityLabel.textProperty().bind(Bindings.createStringBinding(
				() -> String.format("Opacidade: %.2f", opacitySlider.getValue()), opacitySlider.valueProperty())
		);
		// Con Bindings.format
		// opacityLabel.textProperty().bind(Bindings.format("Opacidade: %.2f", opacitySlider.valueProperty()));
		
		// A propiedade do checkbox tamén terá un oínte que cambiará a propiedade do
		// stage setResizable()
		 resizableBox.selectedProperty().addListener((obs, oldVal, newVal) -> {
			stage.setResizable(newVal);
		});
		/* Isto non funciona porque se vinculamos o checkBox á propiedade logo non poderemos
		 * modificar o checkBox clicando sobre él.
		resizableBox.selectedProperty().bind(stage.resizableProperty());
		*/
		

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
		
		HBox opacidadeLayout = new HBox(opacityLabel, opacitySlider);
		HBox anchoMinLayout = new HBox(10, new Label("Ancho mín:"), minWidthField);
		HBox altoMinLayout = new HBox(10, new Label("Alto mín:"), minHeightField);
		HBox anchoMaxLayout = new HBox(10, new Label("Ancho máx:"), maxWidthField);
		HBox altoMaxLayout = new HBox(10, new Label("Alto máx:"), maxHeightField);

		
		VBox root = new VBox(10, new Label("Control de opacidade"),
				opacidadeLayout,
				resizableBox,
				new Label("Límites de tamaño:"),
				anchoMinLayout,
				altoMinLayout,
				anchoMaxLayout,
				altoMaxLayout,
				aplicarLimitesBtn,
				avisoLabel				
				);
		
		
		Scene scene = new Scene(root, 400, 350);
		stage.setScene(scene);
		stage.setTitle("Controlador de propiedades do Stage");
		stage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}
}
/*Exercicio 5 Controlador de propiedades do Stage

Imos crear unha aplicación que permita controlar a opacidade e o tamaño dunha xanela (Stage) de forma dinámica usando controis gráficos.
Instruccións:

    Control de opacidade
        Engade un Slider que permita variar a opacidade do Stage entre 0.0 (totalmente transparente) e 1.0 (totalmente opaco).
        Engade un Label que amose o valor actual do slider con dous decimais. Terás que facer unha vinculación. Usa Bindings.createStringBinding para que o label se actualice automaticamente.
        Vincula a propiedade do Stage opacityProperty() á propiedade valueProperty() do Slider para que o valor do Slider afecte directamente á xanela.

    Control de redimensionamento:
        Engade un CheckBox que permita activar ou desactivar a opción de que a xanela sexa redimensionable.
        Pista: usa checkBox.selectedProperty() e un listener para actualizar stage.setResizable().

    Límites de tamaño

    Engade TextField para que o usuario poida definir o ancho e alto mínimo e máximo da xanela.

    Engade un Botón “Aplicar Límites” que valide os valores e actualice stage.setMinWidth(), setMinHeight(), setMaxWidth() e setMaxHeight().

    Mostra mensaxes de aviso se os valores non son correctos (mínimos maiores que máximos ou valores non numéricos).

    Layout: Organiza os elementos usando VBox para a estrutura vertical e HBox para etiquetas e campos que deben ir na mesma fila.

Pistas sobre propiedades:

Slider.valueProperty() : representa o valor actual do slider e permite ligar outros elementos a este valor. CheckBox.selectedProperty() : devolve un booleano (true/false) indicando se está marcado ou non. Stage.opacityProperty() : propiedade que controla a opacidade da xanela (0.0-1.0). Bindings.createStringBinding(lambda, propiedade) : permite que un label ou outro control actualícese automaticamente cun String cando cambie unha propiedade.

    Non todas as propiedades do Stage se poden ligar directamente (bind), polo que para o CheckBox necesitarás un listener.
*/