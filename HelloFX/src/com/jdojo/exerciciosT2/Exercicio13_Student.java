/*
    Crea unha clase Student con propiedades JavaFX para id, nome e nota media.
        id (ReadOnlyStringProperty).
        nome (StringProperty).
        averageGrade (DoubleProperty).
    Constructores:
        Un constructor baleiro seguindo a convención JavaBeans.
        Un constructor con parámetros que inicializará id, name e averageGrade cando se instancie.
    Implementa os métodos públicos de acceso para:
        Para id:
            Accesor clásico getter para retrocompatibilidade (o setter non procede por ser só lectura).
            Accesor de JavaFx devolve a propiedade de só lectura (getReadOnlyProperty() do wrapper).
        Para name e averageGrade:
            Accesores clásicos getter e setter.
            Accesores JavaFx para devolver os obxecto-propiedade.
    Noutra clase denominada StudentTest.java:
        Implementa un método utilitario estático printDetails(ReadOnlyProperty<?> property) que para cada propiedade:
            Imprima o nome da propiedade.
            Imprima o valor actual da propiedade.
            Imprima a clase do bean.
            Nos indique o tipo concreto da propiedade.
        Método main de proba:
            Instancia un Student e dalle os valores iniciais: "S000","Descoñecido" e 0.0.
            Imprime os detalles das propiedades cos valores iniciais.
            Modifica os valores facendo uso do accesores das propiedades JavaFx (Ollo: non as clásicas).
                name = "Ana"
                averageGrade = 10.0
        Volve a imprimir os detalles das propiedades para ver os cambios.
        Intenta modificar o id facendo uso os accesor da propiedade JavaFX, ¿que ocorre?.

Pistas:

    Usa as clases SimpleStringProperty, SimpleIntegerProperty e SimpleDoubleProperty.
    Lembra usar os métodos get(), set() e XXXProperty() para cada propiedade.*/

package com.jdojo.exerciciosT2;

import javafx.beans.property.ReadOnlyStringWrapper;
import javafx.beans.property.StringProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.ReadOnlyStringProperty;
import javafx.beans.property.SimpleDoubleProperty;

public class Exercicio13_Student {

	private ReadOnlyStringWrapper id = new ReadOnlyStringWrapper(this, "id");
	private StringProperty name = new SimpleStringProperty(this, "name");
	private DoubleProperty averageGrade = new SimpleDoubleProperty(this, "averageGrade");

	public Exercicio13_Student() {

	}

	public Exercicio13_Student(String id, String name, double averageGrade) {
		this.id.set(id);
		this.name.set(name);
		this.averageGrade.set(averageGrade);
	}

	public String getId() {
		return id.get();
	}

	public ReadOnlyStringProperty idProperty() {
		return id.getReadOnlyProperty();
	}

	public String getName() {
		return name.get();
	}

	public void setName(String name) {
		this.name.set(name);
	}

	public double getAverageGrade() {
		return averageGrade.get();
	}

	public void setAverageGrade(double averageGrade) {
		this.averageGrade.set(averageGrade);
	}

	public StringProperty nameProperty() {
		return this.name;
	}

	public DoubleProperty averageGradeProperty() {
		return this.averageGrade;
	}
}
