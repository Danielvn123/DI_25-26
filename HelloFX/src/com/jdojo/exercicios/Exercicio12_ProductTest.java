
// EmployeeTest.java
package com.jdojo.exercicios;
import java.beans.PropertyChangeEvent;

public class Exercicio12_ProductTest {
    public static void main(String[] args) {
        final Exercicio12_Product e1 = new Exercicio12_Product("Pan", 3.0);
        
        // Calcular o imposto
        prezoDesconto(e1.getPrice());

        // Engadir un escoitador de cambio de propiedade
        e1.addPropertyChangeListener(Exercicio12_ProductTest::handlePropertyChange);

        // Cambiar o salario
        e1.setPrice(3.00);
        e1.setPrice(4.00); // Non se lanza notificación
        e1.setPrice(6.00);
    }

    // Este método é o listener: un obxecto coa implementación do método propertyChange(PropertyChangeEvent evt) da interface PropertyChangeListener. Unha implementación en Java é considerada un obxecto
    public static void handlePropertyChange(PropertyChangeEvent e) {
        String propertyName = e.getPropertyName();
        if ("price".equals(propertyName)) {
            System.out.print("O precio cambiou. ");
            System.out.print("Anterior: " + e.getOldValue());
            System.out.println(", Novo: " + e.getNewValue());
            prezoDesconto((Double)e.getNewValue());
        }
    }

    public static void prezoDesconto(double price) {
        final double DESCONTO = 20.0;
        double desconto = price * DESCONTO / 100.0;
        double prezoFinal = price - desconto;
        System.out.println("Precio: " + price + ", Desconto: " + desconto + ", Precio final: " + prezoFinal + ".");
    }
}