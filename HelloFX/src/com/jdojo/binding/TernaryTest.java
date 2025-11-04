package com.jdojo.binding;

import javafx.beans.binding.Bindings;
import javafx.beans.binding.StringBinding;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;

public class TernaryTest {
    public static void main(String[] args) {
        IntegerProperty num = new SimpleIntegerProperty(10);

        // Creamos un StringBinding que indica se o número é par ou impar usando Binding.when()
        StringBinding desc = Bindings.when(num.divide(2).multiply(2).isEqualTo(num))
                                   .then("par")
                                   .otherwise("impar");

        System.out.println(num.get() + " é " + desc.get());
        // Saída: 10 é par

        num.set(19);
        System.out.println(num.get() + " é " + desc.get());
        // Saída: 19 é impar
    }
}