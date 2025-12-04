/*Enunciado

Crea unha aplicación JavaFX chamada To-Do List que:

    Mostre unha xanela cun título "To-Do List".
    Teña un TextField para introducir tarefas e un botón "Nova tarefa".
    Cando se prema o botón:
        Se o campo está baleiro, mostrarase "Campo obrigatorio" en vermello dentro do TextField.
        Se se introduce unha tarefa válida, esta engadirase como un novo Label no contedor principal.
        Limparase o TextField.
        Cada tarefa engadida debe numerarse de forma incremental co formato "Tarefa_1: ...", "Tarefa_2: ...", etc.

Requisitos técnicos:

    A clase principal debe herdar de Application.
    Implementa o método start(Stage stage) que configura a interface gráfica.
    Usa un VBox como nodo raíz da escena.
    A xanela debe ter un tamaño de 300x400 píxeles.
    As tarefas que se inclúen deben mostrarse con estilo (-fx-padding: 6;) e numerarse correctamente.

Exercicio 9
Pista:

    O botón "Nova tarefa" debe pode chamar ao método auxiliar engadirTarefa(TextField, VBox) que xestiona a validación e inserción das tarefas.*/

package com.jdojo.exerciciosT2;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Exercicio09_ToDoList extends Application {
	
	//Declaramos contador y la lista
	int contador = 0;
	String lista = "";

	public static void main(String[] args) {
		Application.launch(args);
	}

	@Override
	public void start(Stage stage) throws Exception {

		VBox root = new VBox();
		
		Label label1 = new Label();

		TextField namefld = new TextField();
		
		Button btn = new Button("Nova tarefa");
		
		//Acción del botón para que cada vez que pulses salga en el label lo que escribes
		btn.setOnAction( e->{
			String field = namefld.getText();
		
			if(field.isEmpty()) {
				namefld.setPromptText("Campo obrigatorio");
				namefld.setStyle("-fx-prompt-text-fill: red;");
			}else {
				contador++;
				lista += "Tarefa_" + contador + ": " + field + "\n";
				label1.setText(lista);
				
				namefld.clear();
			}
		});


		root.getChildren().addAll(namefld, btn, label1);

// Para ver la escena
		Scene scene = new Scene(root, 300, 400);
		stage.setTitle("To-Do List");
		stage.setScene(scene);
		stage.show();
	}
}
/*import java.util.ArrayList;
import java.util.List;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Exercicio09 extends Application {

	private int numeroTarefa = 1;
	@Override
	public void start(Stage stage) {

		stage.setTitle("To-Do List");
		
		// Neste exercicio precisamos un TextField para introducir cada tarefa e un botón para engadila
		TextField tarefa = new TextField();
		Button btnEngadir = new Button("Nova tarefa");

		// Precisamos o nó raíz
		VBox root = new VBox();
		root.getChildren().addAll(tarefa, btnEngadir);

		// Neste caso cada vez que introduzamos unha tarefa deberemos vincular un novo label a root.
			 
		/* Imos crear un método engadirTarefa(TextField, VBox) en vez de 
		   btnEngadir.setOnAction(e -> {
		
			Label lblTarefa = new Label(tarefa.getText());
			root.getChildren().add(lblTarefa);
			listaTarefas.add(tarefa.getText());
		});*/
		/*btnEngadir.setOnAction(e -> engadirTarefa(tarefa,root));
		
		
		Scene scene = new Scene(root,300,400);
		stage.setScene(scene);
		stage.show();

	}

	private void engadirTarefa(TextField novaTarefa, VBox root) {
		novaTarefa.setStyle("-fx-text-fill: black;");
		if(novaTarefa.getText().trim().length()>0) {
			Label lblTarefa = new Label("Tarefa_"+ numeroTarefa +": " + novaTarefa.getText());
			lblTarefa.setStyle("-fx-padding: 6;");
			root.getChildren().add(lblTarefa);
			numeroTarefa++;
		} else {
			novaTarefa.setText("Campo obrigatorio");
			novaTarefa.setStyle("-fx-text-fill: red;");
		}


	}

	public static void main(String[] args) {
		Application.launch(args);
	}
}*/
