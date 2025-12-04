/*Enunciado

Crea unha aplicación JavaFX chamada Ciclo de vida con consola que:

    Mostre unha xanela cun título "Ciclo de vida con consola".

    Mostre TextArea onde se vai a recrear unha consola onde se amosen mensaxes de log sobre o ciclo de vida da aplicación coma se fose a consola dun sistema operativo.

    Inclúa un botón "Pechar aplicación" que, ao premelo, pecha a aplicación.

    Mostre tamén un Label cunha mensaxe indicando que se comprobe a consola real ao saír.

    Rexistre os fíos de execución no momento no que se executan os métodos:
        init()
        start()
        O constructor

    Ao pechar a aplicación, tamén se debe rexistrar no método stop() unha mensaxe na consola do sistema (non na interface).

Requisitos técnicos:

    A clase principal debe herdar de Application.
    Implementa os métodos do ciclo de vida de JavaFX: init(), start(Stage stage) e stop().
    Emprega Thread.currentThread().getName() para identificar o fío no que se executa cada parte.
    Usa TextArea para mostrar o log na interface gráfica, cun fondo claro e algo de espazamento (padding): "-fx-padding: 5px; -fx-background-color:#eef;"
    O log debe incluír a hora, o método chamado e o nome do fío.
    A escena debe ter un tamaño de 300x200 píxeles.

Exercicio 7
Pista:

    Podes usar DateTimeFormatter.ofPattern("HH:mm:ss") para dar formato á hora actual.
    Crea una función para crear o log que sexa chamada en cada método sobreescrito para poder gardar todas as mensaxes nunha lista (List<String>).*/


package com.jdojo.exerciciosT2;

import javafx.scene.Scene;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import javafx.application.Application;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Exercicio07_Ciclodevidaconconsola extends Application {
	TextArea textArea = new TextArea();
	List<String> ListTexto = new ArrayList<String>();
	
	public Exercicio07_Ciclodevidaconconsola() {
		String name = Thread.currentThread().getName();
		System.out.println("[" + DateTimeFormatter.ofPattern("HH:mm:ss").format(LocalTime.now())
				+ "]" + "Fío do constructor: (" + name + ")"+ "\n");
		
		textArea.appendText("[" + DateTimeFormatter.ofPattern("HH:mm:ss").format(LocalTime.now()) 
				+ "]" + "Fío do constructor: (" + name + ")"+"\n");
	}

	public static void main(String[] args) {
		Application.launch(args);
	}
	
	@Override
    public void init() {
        String name = Thread.currentThread().getName();
        System.out.println("[" + DateTimeFormatter.ofPattern("HH:mm:ss").format(LocalTime.now()) 
        		+ "]"+ "Fío do init() (" + name + ")"+ "\n");
        
        textArea.appendText("[" + DateTimeFormatter.ofPattern("HH:mm:ss").format(LocalTime.now()) 
        		+ "]" + "Fío do init() (" + name + ")"+ "\n");
	}

	@Override
	public void start(Stage stage) throws Exception {
		String name = Thread.currentThread() .getName();
		System.out.println("[" + DateTimeFormatter.ofPattern("HH:mm:ss").format(LocalTime.now()) 
				+ "]" + "Fío do start() (" + name + ")" + "\n");
		
        textArea.appendText("[" + DateTimeFormatter.ofPattern("HH:mm:ss").format(LocalTime.now()) 
        		+ "]" + "Fío do start() (" + name + ")"+ "\n");
        
        VBox root = new VBox();
	
		root.setStyle("-fx-padding: 5px;");
		
		Button btn = new Button("Pechar aplicación");
		
		btn.setOnAction( e->{
			stage.close();
		});
		
		Label label1 = new Label("");
		
		label1.setStyle("-fx-padding: 5px; -fx-Text-fill:red;");
		label1.setText("Pechar a aplicación e comproba na consola a mensaxe");
		
					
		root.getChildren().addAll(textArea, label1, btn); 


		//Para ver la escena
		Scene scene = new Scene(root, 400, 200);
		stage.setTitle("Ciclo de vida con consola");
		stage.setScene(scene);
		stage.show();
	}
		@Override
	    public void stop() {
	        String name = Thread.currentThread().getName();
	        System.out.println("[" + DateTimeFormatter.ofPattern("HH:mm:ss").format(LocalTime.now())
	        		+ "]" + "Fío do stop() (" + name + ")" + "\n");
	        
	        textArea.appendText("[" + DateTimeFormatter.ofPattern("HH:mm:ss").format(LocalTime.now()) 
	        		+ "]" + "Fío do stop()  (" + name + ")" + "\n");

	}
}
/*
import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class Exercicio07 extends Application {

	// O TextField e a Lista de mensaxes
	// decláranse como atributo da clase para que poidan ser vistos dende o método
	// meulog()
	private TextArea consola = new TextArea();
	private final List<String> bufferMensaxes = new ArrayList<>();

	// Facemos explícito o constructor para mandar o log
	public Exercicio07() {
		meulog("Fío do constructor: ");
	}

	@Override
	public void init() {
		meulog("Fío do init()");
	}

	@Override
	public void start(Stage stage) {
		stage.setTitle("Ciclo de vida con log");
		
		meulog("Fío do start()");
		stage.setTitle("Ciclo de vida con consola");

		// Como controis precisamos un botón e o label da instrucción
		Button sairBtn = new Button("Pechar aplicación");
		Label msg = new Label("Pecha a aplicación e comproba na consola a mensaxe");
		msg.setStyle("-fx-text-fill: red;");
		

		// Indicamos o que debe realizar a apliación ao pulsar o botón
		sairBtn.setOnAction(e -> Platform.exit());
		// Como nó raíz imos colocar un VBox cunha cor e un padding dado
		VBox root = new VBox();
		root.setStyle("-fx-padding: 5px; -fx-background-color:#eef;");

		// Enlazamos o Botón e o TextArea ao nó raíz
		root.getChildren().addAll(consola, msg, sairBtn);

		Scene scene = new Scene(root, 300, 200);
		stage.setScene(scene);
		stage.show();

	}

	@Override
	public void stop() {
		System.out.println("Fío do stop: " + Thread.currentThread().getName());
	}

	private void meulog(String mensaxe) {
		// Meu log comeza cunha hora
		String hora = LocalTime.now().format(DateTimeFormatter.ofPattern("HH:mm:ss"));
		// Cada método init(),start(),stop() chama a función meulog co seu propio fío
		String fio = Thread.currentThread().getName();
		String msgConsola = String.format("[%s] %s (%s) ", hora, mensaxe, fio);
		bufferMensaxes.add(msgConsola);

		if (consola != null) {
			consola.clear();
			for (String line : bufferMensaxes) {
				consola.appendText(line + "\n");
			}
		}

	}

	public static void main(String[] args) {
		launch(args);
	}
}
*/