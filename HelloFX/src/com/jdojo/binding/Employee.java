package com.jdojo.binding;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class Employee {
    private String name;
    private double salary;
    // Obxecto auxiliar que xestiona os listeners que escoitan cambios nas propiedades
    private PropertyChangeSupport pcs = new PropertyChangeSupport(this);

    public Employee() {
        // Constructor baleiro onde asignamos valores por defecto ás propiedades.
        this.name = "John Doe";
        this.salary = 1000.0;
    }

    public Employee(String name, double salary) {
        this.name = name;
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double newSalary) {
        double oldSalary = this.salary;
        this.salary = newSalary;
        // Se hai listeners rexistrados, notificaráselles que o salario cambiou cando chaman a setSalary().
        // O método recibe o nome da propiedade, o valor antigo e o valor novo.
        pcs.firePropertyChange("salary", oldSalary, newSalary);
    }

    // Método para rexistrar un listener (escoitador) que será notificado cando cambie unha propiedade
    public void addPropertyChangeListener(PropertyChangeListener listener) {
        pcs.addPropertyChangeListener(listener);
    }
    // Método para eliminar un listener rexistrado anteriormente
    public void removePropertyChangeListener(PropertyChangeListener listener) {
        pcs.removePropertyChangeListener(listener);
    }

    @Override
    public String toString() {
        return "name = " + name + ", salary = " + salary;
    }
}