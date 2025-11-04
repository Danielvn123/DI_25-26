package com.jdojo.exercicios;

public class Exercicio11_Coche {
	private String marca;
	private int velocidad;

	public Exercicio11_Coche() {
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getMarca() {
		return marca;
	}

	public void setVelocidad(int velocidad) {
		this.velocidad = velocidad;
	}

	public int getVelocidad() {
		return velocidad;
	}
	public void acelerar(int acelerar) {
		this.velocidad += acelerar;
	}
}
