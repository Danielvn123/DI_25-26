
// EmployeeTest.java
package com.jdojo.binding;
import java.beans.PropertyChangeEvent;

public class EmployeeTest {
    public static void main(String[] args) {
        final Employee e1 = new Employee("John Jacobs", 2000.0);
        
        // Calcular o imposto
        computeTax(e1.getSalary());

        // Engadir un escoitador de cambio de propiedade
        e1.addPropertyChangeListener(EmployeeTest::handlePropertyChange);

        // Cambiar o salario
        e1.setSalary(3000.00);
        e1.setSalary(3000.00); // Non se lanza notificación
        e1.setSalary(6000.00);
    }

    // Este método é o listener: un obxecto coa implementación do método propertyChange(PropertyChangeEvent evt) da interface PropertyChangeListener. Unha implementación en Java é considerada un obxecto
    public static void handlePropertyChange(PropertyChangeEvent e) {
        String propertyName = e.getPropertyName();
        if ("salary".equals(propertyName)) {
            System.out.print("O salario cambiou. ");
            System.out.print("Anterior: " + e.getOldValue());
            System.out.println(", Novo: " + e.getNewValue());
            computeTax((Double)e.getNewValue());
        }
    }

    public static void computeTax(double salary) {
        final double TAX_PERCENT = 20.0;
        double tax = salary * TAX_PERCENT / 100.0;
        System.out.println("Salario: " + salary + ", Imposto: " + tax);
    }
}