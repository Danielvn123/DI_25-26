package com.jdojo.binding;

import javafx.beans.property.ReadOnlyIntegerProperty;
import javafx.beans.property.ReadOnlyIntegerWrapper;

public class ReadOnlyExample {
    public static void main(String[] args) {
        ReadOnlyIntegerWrapper idWrapper = new ReadOnlyIntegerWrapper(100);
        ReadOnlyIntegerProperty id = idWrapper.getReadOnlyProperty();

        System.out.println("idWrapper: " + idWrapper.get());
        System.out.println("id: " + id.get());

        // Cambiar o valor a través da propiedade de lectura/escritura → FUNCIONA
        idWrapper.set(101);

        System.out.println("idWrapper: " + idWrapper.get());
        System.out.println("id: " + id.get());

        // Intentar cambiar o valor a través da propiedade só de lectura → ERRO DE COMPILACIÓN
        // The method set(int) is undefined for the type ReadOnlyIntegerProperty
        //id.set(102);  // Isto NON compila
    }
}