/*Como se indicou no apartado 1.10 Que é un Binding no que se explicou as vinculacións, nas aplicacións de interface gráfica empregase a vinculación bidireccional para manter sincronizados os valores do modelo de datos e o valor da interface gráfica.

Imos crear unha pequena aplicación JavaFX con un campo de texto para introducir o nome dun usuario. Este campo estará vinculado bidireccionalmente cunha propiedade do modelo de datos.
Instruccións

    Crear unha propiedade StringProperty chamada nome.
    Crear un TextField que permita modificar o valor da propiedade nome.
    Vincular bidireccionalmente o TextField coa propiedade nome.
    Crear un Label que estea vinculado unidireccionalmente á propiedade nome.
    Engadir un botón que ao ser premido cambie o valor da propiedade nome a un texto fixo (exemplo: "Invitado") vendo así a bidireccionalidade, xa que ao cambiar a propiedade nome debería tamén cambiar o texto do TextField.
    Observar como o campo de texto se actualiza automaticamente cando cambia a propiedade.*/

package com.jdojo.exerciciosT2;

import javafx.application.Application;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Exercicio16_Y extends Application {

    @Override
    public void start(Stage stage) {
        // 1. Crear a propiedade nome
        StringProperty nome = new SimpleStringProperty();
        
        // 2. Crear o campo de texto
        TextField campoTexto = new TextField();

        // 3. Vincular bidireccionalmente o campo de texto coa propiedade nome
        campoTexto.textProperty().bindBidirectional(nome);
        
        //4. Crea un Label que estea vinculado á propiedade nome
        Label etiqueta = new Label("");
        etiqueta.textProperty().bind(nome);
        
        // 5. Crear un botón para cambiar o valor de nome a "Invitado"
        Button botonCambiar = new Button("Cambiar a Invitado");
        botonCambiar.setOnAction(e -> nome.set("Invitado"));  

        VBox root = new VBox(10, campoTexto, etiqueta, botonCambiar);
        Scene scene = new Scene(root, 300, 100);

        stage.setScene(scene);
        stage.setTitle("Exercicio Vinculación Bidireccional");
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}
/*import javafx.application.Application;
import javafx.beans.property.StringProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Exercicio16 extends Application {

    @Override
    public void start(Stage stage) {
        // 1. Crear a propiedade nome
        StringProperty nome = new SimpleStringProperty("Usuario");

        // 2. Crear o campo de texto
        TextField campoTexto = new TextField();

        // 3. Vincular bidireccionalmente o campo de texto coa propiedade nome
        campoTexto.textProperty().bindBidirectional(nome);

        // 4. Crear un botón para cambiar o valor de nome a "Invitado"
        Button botonCambiar = new Button("Cambiar a Invitado");
        botonCambiar.setOnAction(e -> {
            nome.set("Invitado");
        });

        VBox root = new VBox(10, campoTexto, botonCambiar);
        Scene scene = new Scene(root, 300, 100);

        stage.setScene(scene);
        stage.setTitle("Exercicio Vinculación Bidireccional");
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}*/