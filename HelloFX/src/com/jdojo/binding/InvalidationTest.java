package com.jdojo.binding;

import javafx.beans.Observable;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;

public class InvalidationTest {
	public static void main(String[] args) {
		// Crease unha propiedade
		IntegerProperty counter = new SimpleIntegerProperty(100);
		
		// Engádese un invalidation listener addListener() á propiedade counter usando unha
		// referencia a un método da propia clase. O método invalidated() desta clase será
		// chamado cando a propiedade counter se invalide.
		// Basicamente aquí estamos dicindo: cando counter este invalidade executa o método que che paso
		
		counter.addListener(InvalidationTest::invalidated);

		System.out.println("Antes de cambiar o valor de counter - 1");
		counter.set(101);
		System.out.println("Despois de cambiar o valor de counter - 1");

		/*
		 * Neste punto, a propiedade counter está invalidada e posteriores cambios
		 * no seu valor non xerarán eventos de invalidación.
		 */

		System.out.println("\nAntes de cambiar o valor de counter - 2");
		counter.set(102);
		System.out.println("Despois de cambiar o valor de counter - 2");

		// Validamos a propiedade counter chamando ao seu método get()
		int value = counter.get();
		System.out.println("Counter value = " + value);

		/*
		 * Neste punto, a propiedade counter está validada e posteriores cambios
		 * no seu valor xerarán eventos de invalidación.
		 */

		// Probar a asignar o mesmo valor
		System.out.println("\nAntes de cambiar o valor de counter - 3");
		counter.set(102);
		System.out.println("Despois de cambiar o valor de counter - 3");

		// Probar a asignar un valor diferente
		System.out.println("\nAntes de cambiar o valor de counter - 4");
		counter.set(103);
		System.out.println("Despois de cambiar o valor de counter - 4");
	}
	
	// InvalidationListener é unha interface que só ten o método invalidated() que debemos sobreesscribir
	public static void invalidated(Observable prop) {
		System.out.println("A propiedade counter está invalidada.");
	}
}