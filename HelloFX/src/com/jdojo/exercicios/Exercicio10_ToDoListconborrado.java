package com.jdojo.exercicios;
import java.util.ArrayList;
import java.util.List;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Exercicio10_ToDoListconborrado extends Application {

	private int numeroTarefa = 1;
	@Override
	public void start(Stage stage) {
		stage.setTitle("To-Do List con borrado");
		// Neste exercicio precisamos un TextField para introducir cada tarefa e un botón para engadila
		TextField tarefa = new TextField();
		Button btnEngadir = new Button("Nova tarefa");

		// Precisamos o nó raíz
		VBox root = new VBox();
		root.getChildren().addAll(tarefa, btnEngadir);

		btnEngadir.setOnAction(e -> engadirTarefa(tarefa,root));
		
		
		Scene scene = new Scene(root,300,400);
		stage.setScene(scene);
		stage.show();

	}

	private void engadirTarefa(TextField novaTarefa, VBox root) {
		novaTarefa.setStyle("-fx-text-fill: black;");
		
		if(novaTarefa.getText().trim().length()>0) {
			// Creamos un ademáis do label un CheckBox e un botón
			CheckBox check = new CheckBox();
			Label lblTarefa = new Label("Tarefa_"+ numeroTarefa +": " + novaTarefa.getText());
			Button btnBorrar = new Button("Borrar");
			
			// Inicialmente o botón está deshabilitado
			btnBorrar.setDisable(true);
			
			/*
			 * Con selectedProperty() podemos atender ao cambio do CheckBox
			 * Con addListener() executamos un código cando vexamos un cambio
			 */
			
			check.selectedProperty().addListener((obs, antes, agora) -> btnBorrar.setDisable(!agora));
			 
			// Acción para borrar a tarefa (o HBox)
            btnBorrar.setOnAction(e -> root.getChildren().remove(btnBorrar.getParent()));
            
            HBox tarefaBox = new HBox(10, check, lblTarefa, btnBorrar);
			 
			lblTarefa.setStyle("-fx-padding: 6;");
			
			root.getChildren().add( tarefaBox);
			
			numeroTarefa++;
			novaTarefa.clear();
		} else {
			novaTarefa.setText("Campo obrigatorio");
			novaTarefa.setStyle("-fx-text-fill: red;");
		}


	}

	public static void main(String[] args) {
		Application.launch(args);
	}
}