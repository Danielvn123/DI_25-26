/*Enunciado

Crea unha aplicación titulada To-Do List con borrado que amplía a aplicación anterior da To-Do List para que cada tarefa engadida:

    Inclúa unha caixa de verificación (CheckBox) e un botón para borrala.
    O botón de "Borrar" debe estar desactivado inicialmente: btn.setDisable(true);
    Este botón de borrado só debe activarse cando a tarefa estea marcada como completada (CheckBox activado).
    Ao premer o botón de "Borrar", a tarefa eliminarase da lista (do contedor visual).

Requisitos técnicos:

    Ao engadir cada tarefa esta estará contida nun HBox que terá:
        Un CheckBox para marcar a tarefa como feita.
        Un Label co texto da tarefa numerada (ex: "Tarefa_3: ...").
        Un botón "Borrar" que só se activa ao marcar o CheckBox.

Exercicio 10
Pista:
Activar ou desactivar o botón Borrar segundo o estado do CheckBox:

    O CheckBox ten un método chamado selectedProperty() que nos di se está marcado ou non.
    Podemos escoitar os cambios nesa propiedade usando addListener(...).

    // obs : Obxecto observable
    // antes: valor anterior do checkbox true/false
    // agora: valor actual do checkbox true/false
    checkbox.selectedProperty().addListener((obs, antes, agora) -> {
      btnBorrar.setDisable(!agora);
      });

Que fai isto?

    Cada vez que o CheckBox cambie (de marcado a desmarcado ou ao revés), executarase o código.
    Se está marcado (agora == true), activamos o botón Borrar (setDisable(false)).
    Se está desmarcado, desactivámolo (setDisable(true)).

Eliminar a tarefa cando se preme o botón Borrar:

Ao crear o botón btnBorrar, podes programar o que fará cando se prema:

btnBorrar.setOnAction(e -> root.getChildren().remove(btnBorrar.getParent()));

    Elimina o HBox enteiro (é dicir, a tarefa completa) do contedor principal VBox.
    Usamos btnBorrar.getParent() para coller o HBox onde está o botón.*/

package com.jdojo.exerciciosT2;
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
/*
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

public class Exercicio10 extends Application {

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
			/*
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
}*/