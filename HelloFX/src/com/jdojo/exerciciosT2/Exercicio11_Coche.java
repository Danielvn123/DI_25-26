/*Crea unha clase JavaBean chamada Coche que represente un vehículo. Esta clase debe ter as seguintes características:

    Dous campos privados:
        String marca: Para gardar a marca do coche.
        int velocidade: Para gardar a velocidade actual do coche en km/h.
    Métodos públicos para acceder e modificar estes campos, seguindo a convención de nomeado de JavaBeans:
        Un getter e un setter para a propiedade marca.
        Un getter e un setter para a propiedade velocidade.
    Un construtor sen parámetros (construtor por defecto).
    Crea un método acelerar(int aumento) que incremente a velocidade do coche na cantidade especificada.
    No método main da clase Principal (que terás que crear ti), realiza o seguinte:
        Crea unha nova instancia da clase Coche.
        Usa o setter para establecer a marca en "Ford".
        Usa o getter para obter e imprimir a marca na consola.
        Usa o setter para establecer a velocidade inicial en 50 km/h.
        Usa o método acelerar para aumentar a velocidade en 20 km/h.
        Usa o getter para obter e imprimir a velocidade final do coche na consola.*/

package com.jdojo.exerciciosT2;

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
