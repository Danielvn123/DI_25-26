/*Adapta a clase Coche do Exercicio 11 e usar as súas propiedades observables en JavaFX para crear unha interface de usuario que se actualice automaticamente.

Instrucións:

    Modifica a clase Coche (Exercicio 11) e chámaa CocheFx:
        Modifica os campos privados como private String marca e private int velocidade para que usen as clases de propiedades de JavaFX:
        Asegúrate de que os métodos getMarca(), setMarca(), getVelocidade() e setVelocidade() usen os novos campos de propiedade.
        Engade os dous novos métodos necesarios para a vinculación en JavaFX.

    public StringProperty marcaProperty() que devolva a propiedade da marca.
    public IntegerProperty velocidadeProperty() que devolva a propiedade da velocidade.

        Adapta o método acelerar(int aumento) para que chame ao método set da propiedade velocidade.

    Crea a aplicación JavaFX:
        Dentro do método start(Stage stage):
            Crea unha instancia da túa clase Coche.
            Asigna un valor inicial para a marca ("McLaren") e a velocidade (100).
            Crea un Label para mostrar a marca e outro para a velocidade.
            Vincula o texto do Label da marca á propiedade marcaProperty() do teu obxecto Coche.
            Vincula o texto do Label da velocidade á propiedade velocidadeProperty(), usando .asString() para converter o número en texto.
            Crea un Button cunha etiqueta "Acelerar (+25 km/h)".
            Programa a acción do botón para que chame ao método acelerar(25) do teu obxecto Coche.
            Organiza os compoñentes nun contedor (VBox ou similar), crea a Scene e mostra a ventá.

Preguntas para reflexionar:

    Se non tivésemos modificado a clase Coche para usar propiedades de JavaFX, que teríamos que facer no setOnAction do botón "Acelerar" para que o Label da velocidade se actualizase?
    Explica porque, despois de usar bind(), non necesitamos actualizar manualmente o Label da velocidade cando o coche acelera.

A ter en conta

Do mesmo xeito que no exemplo do circulo a clase Circle ten tres propiedades — centerXProperty, centerYProperty, e radiusProperty — a clase Label ten as propiedades :

    textProperty() - Propiedade do texto mostrado.
    fontProperty() - Propiedade da fonte do texto (un ObjectProperty<Font>).
    visibleProperty() - Propiedade booleana para visibilidade. entre outras*/


package com.jdojo.exerciciosT2;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Exercicio15_CocheFx {
	private StringProperty marca = new SimpleStringProperty();
	private IntegerProperty velocidad = new SimpleIntegerProperty();

	public Exercicio15_CocheFx() {
	}

	public String getMarca() {
		return marca.get();
	}

	public void setMarca(String marca) {
		this.marca.set(marca);
	}
	
	public int getVelocidad() {
		return velocidad.get();
	}
	
	public void setVelocidad(int velocidad) {
		this.velocidad.set(velocidad);
	}
	
	public StringProperty marcaProperty() {
		return marca;
	}
	
	public IntegerProperty velocidadProperty() {
		return velocidad;
	}
	
	public void acelerar(int incrementar) {
		this.velocidad.set(this.velocidad.get() + incrementar);
	}
}
