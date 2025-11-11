package com.jdojo.exercicios;

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
