/*Deberemos crear unha aplicación en JavaFX cunha xanela que conteña un único botón no centro. O fondo da xanela debe cambiar automaticamente de cor dependendo de se o botón está sendo presionado ou non.
Instrucións

    Crea o botón e establece o seu texto.
    Engade o botón a un contedor raíz, este contedor terá un background setBackground(Background.EMPTY)
    Crea a escena será de 300x250.
    Vincula (bind) a propiedade fill da escena á propiedade pressed do botón empregando unha das seguintes técnicas:
        Opción 1: Crear unha clase anónima que extenda ObjectBinding<Paint> e que faga o bind() a btn.pressedProperty().
        Opción 2: Empregar Bindings.createObjectBinding(...) cunha expresión lambda.
        Opción 3: Empregar Bindings.when(...).then(...).otherwise(...).
    Proba que o cambio de estado do botón (presionado / non presionado) actualiza o fondo automaticamente.

Requisitos técnicos:

Vincular a propiedade scene.fillProperty() á propiedade btn.pressedProperty() empregando algunha das técnicas de binding vistas.

    Propiedades do Button que imos usar:
        btn.pressedProperty(): é un observable, un obxecto que "emite" eventos cando o estado cambia. Non é directamente o valor true ou false, senón unha propiedade que pode ser observada.
        btn.isPressed(): é o getter que devolve o valor booleano actual (true ou false) desa propiedade.
    Propiedades da Scene
        fillProperty() : define a cor ou o patrón de recheo do fondo da escena. Pode tomar valores do tipo Paint (por exemplo: Color.RED, Color.BLUE, etc.).*/


package com.jdojo.exerciciosT2;

import javafx.application.Application;
import javafx.beans.binding.Bindings;
import javafx.beans.binding.ObjectBinding;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Background;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.stage.Stage;

public class Exercicio21_XanelaBindinghelper extends Application{
		
		public void start(Stage stage) throws Exception {
				
			//Creamos boton 
			Button btn = new Button("Pulsa");
			
			VBox root = new VBox(btn);
			root.setBackground(Background.EMPTY);
			root.setAlignment(Pos.CENTER);
			
			/*/ObjectBinding<Paint> objectBindingPaint = Bindings.createObjectBinding(
					() -> btn.isPressed() ? Color.MAGENTA :Color.AQUA,
					btn.pressedProperty()
			);*/
			
			//Creamos la escena
			Scene scene = new Scene(root, 300, 250);
			//scene.fillProperty().bind(objectBindingPaint);
			
			//Hacemos que la escena cambie los colores al pulsar el boton
			scene.fillProperty().bind(Bindings.when(btn.pressedProperty()).then(Color.AQUA).otherwise(Color.MAGENTA));
			stage.setTitle("Exercicio 21 Binding helper");
			stage.setScene(scene);
			stage.show();
		}

		public static void main(String[] args) {
			launch();
		}
	}
/*import javafx.application.Application;
import javafx.beans.binding.Bindings;
import javafx.beans.binding.ObjectBinding;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Background;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.stage.Stage;

public class Exercicio21 extends Application {

	@Override
	public void start(Stage stage) {

		// Creamos o botón e establecemos o texto
		Button btn = new Button("Click me");

		VBox root = new VBox(btn);
		//Metemos un background
		root.setBackground(Background.EMPTY);

		Scene scene = new Scene(root, 300, 250);

		ObjectBinding<Paint> objectBinding = Bindings.createObjectBinding(
				()-> btn.isPressed()? Color.MAGENTA : Color.AQUA, 
				btn.pressedProperty() // Dependencia
				);

		// O Binding o vinculamos á propiedade fillProperty
		scene.fillProperty().bind(objectBinding);
		// Outra opción con when-then-otherwise
		// scene.fillProperty().bind(
		// 		Bindings.when(btn.pressedProperty())
		// 		.then(Color.MAGENTA)
		// 		.otherwise(Color.AQUA)
		// 		);
		stage.setScene(scene);
		stage.setTitle("Xanela con Binding helper");
		stage.show();
	}
    public static void main(String[] args) {
        launch(args);
    }
}*/

