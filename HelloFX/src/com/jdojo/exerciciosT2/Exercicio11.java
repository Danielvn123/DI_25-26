package com.jdojo.exerciciosT2;

public class Exercicio11 {
	
	public static void main(String[] args) {

	Exercicio11_Coche Coche = new Exercicio11_Coche();

    Coche.setMarca("Ford");
    System.out.println("Marca del coche: " + Coche.getMarca());

    Coche.setVelocidad(50);
    System.out.println("Velocidad inicial: " + Coche.getVelocidad() + "km/h");

    Coche.acelerar(20);
    System.out.println("Velocidad final: " + Coche.getVelocidad() + " km/h");
}
}
