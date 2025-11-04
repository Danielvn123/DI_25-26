package com.jdojo.binding;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.value.ObservableValue;

public class ChangeTest {
    public static void main(String[] args) {
        IntegerProperty counter = new SimpleIntegerProperty(100);

        // Engadir un ChangeListener á propiedade counter en vez dun InvalidationListener
        counter.addListener(ChangeTest::changed);

        System.out.println("\nAntes de cambiar o valor do contador-1");
        counter.set(101);
        System.out.println("Despois de cambiar o valor do contador-1");

        System.out.println("\nAntes de cambiar o valor do contador-2");
        counter.set(102);
        System.out.println("Despois de cambiar o valor do contador-2");

        // Intentar asignar o mesmo valor
        System.out.println("\nAntes de cambiar o valor do contador-3");
        counter.set(102); // Non se disprégase evento de cambio
        System.out.println("Despois de cambiar o valor do contador-3");

        // Cambiar a un valor distinto
        System.out.println("\nAntes de cambiar o valor do contador-4");
        counter.set(103);
        System.out.println("Despois de cambiar o valor do contador-4");
    }

    // ChangeListener é unha interface co método changed(ObservableValue<? extends T> observable, T oldValue, T newValue) que debemos sobreescribir
    public static void changed(ObservableValue<? extends Number> prop,
                                Number oldValue,
                                Number newValue) {
        System.out.print("O contador cambiou: ");
        System.out.println("Antigo = " + oldValue + ", novo = " + newValue);
    }
}