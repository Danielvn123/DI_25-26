package com.jdojo.intro;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class HelloFXApp extends Application {

	public static void main(String[] args) {
		Application.launch(args);
	}

	@Override
	public void start(Stage stage) throws Exception {
		Text msg = new Text("Ola JavaFX");
		VBox root = new VBox();
		root.getChildren().add(msg);

		Scene scene = new Scene(root, 300, 50);
		stage.setScene(scene);
		stage.setTitle("Aplicación JavaFX de Exemplo");
		stage.show();

	}

}