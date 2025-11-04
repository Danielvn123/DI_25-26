package com.jdojo.binding;

//BindingTest.java
import javafx.beans.binding.NumberBinding;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;

public class BindingTest {
 public static void main(String[] args) {
     IntegerProperty x = new SimpleIntegerProperty(100);
     IntegerProperty y = new SimpleIntegerProperty(200);

     // Crear un binding: sum = x + y
     NumberBinding sum = x.add(y);

     System.out.println("Despois de crear sum");
     System.out.println("sum.isValid(): " + sum.isValid());

     // Solicitamos o valor de sum, calcúlao e márcase como válido
     int value = sum.intValue();
     System.out.println("\nDespois de solicitar o valor");
     System.out.println("sum.isValid(): " + sum.isValid());
     System.out.println("sum = " + value);

     // Cambiar o valor de x
     x.set(250);
     System.out.println("\nDespois de cambiar x");
     System.out.println("sum.isValid(): " + sum.isValid());

     // Solicitar de novo o valor de sum
     value = sum.intValue();
     System.out.println("\nDespois de solicitar o valor");
     System.out.println("sum.isValid(): " + sum.isValid());
     System.out.println("sum = " + value);
 }
}