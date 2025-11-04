package com.jdojo.binding;

//BoundProperty.java
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;

public class BoundProperty {
 public static void main(String[] args) {
     IntegerProperty x = new SimpleIntegerProperty(10);
     IntegerProperty y = new SimpleIntegerProperty(20);
     IntegerProperty z = new SimpleIntegerProperty(60);

     z.bind(x.add(y));
     System.out.println("Despois de vincular z: Bound = " + z.isBound() + ", z = " + z.get());

     // Cambiar x e y
     x.set(15);
     y.set(19);
     System.out.println("Despois de cambiar x e y: Bound = " + z.isBound() + ", z = " + z.get());

     // Desvincular z
     z.unbind();

     // Non afectará a z, xa que non está vinculada a x e y
     x.set(100);
     y.set(200);
     System.out.println("Despois de desvincular z: Bound = " + z.isBound() + ", z = " + z.get());
 }
}