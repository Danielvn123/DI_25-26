package com.jdojo.exerciciosT2;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Exercicio15 extends Application{

	@Override
	public void start(Stage stage) throws Exception {
		
		Exercicio15_CocheFx meuCoche = new Exercicio15_CocheFx();
		meuCoche.setMarca("McLaren");
		meuCoche.setVelocidad(100);
		
		Label marcaLabel = new Label();
		Label velocidadLabel = new Label();
		
		Button botonacelerar = new Button ("Acelerar +25km/h");
		botonacelerar.setOnAction(event -> meuCoche.acelerar(25));
		
		//Vinculamos propiedades
		marcaLabel.textProperty().bind(meuCoche.marcaProperty());
		velocidadLabel.textProperty().bind(meuCoche.velocidadProperty().asString("Velocidad: %d km/h"));
		
		VBox root = new VBox(15, marcaLabel, velocidadLabel, botonacelerar);
		Scene scene = new Scene(root, 300, 200);
		stage.setScene(scene);
		stage.show();
	}
	
	public static void main(String[] args) {
		Application.launch(args);
	}
}
/*import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class CocheFxApp extends Application {
    
    @Override
    public void start(Stage stage) {
        Coche meuCoche = new Coche();
        meuCoche.setMarca("McLaren");
        meuCoche.setVelocidade(100);
        
        Label marcaLabel = new Label();
        Label velocidadeLabel = new Label();
        
        // VINCULACIÓN: o texto dos labels está ligado ás propiedades do coche.
        marcaLabel.textProperty().bind(meuCoche.marcaProperty());
        velocidadeLabel.textProperty().bind(meuCoche.velocidadeProperty().asString("Velocidade: %d km/h"));
        
        Button botonAcelerar = new Button("Acelerar (+25 km/h)");
        botonAcelerar.setOnAction(event -> meuCoche.acelerar(25));
        
        VBox root = new VBox(15, marcaLabel, velocidadeLabel, botonAcelerar);
        root.setAlignment(Pos.CENTER);
        
        Scene scene = new Scene(root, 300, 200);
        stage.setScene(scene);
        stage.setTitle("Coche Dinámico");
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}*/

