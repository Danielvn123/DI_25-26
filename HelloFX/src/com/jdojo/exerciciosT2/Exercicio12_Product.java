/*Imos crear unha clase JavaBean Product que representa un produto dunha tenda online. Este produto terá dúas propiedades:

    name
    price

    Crea a clase Product
        Deberá ter o campos privados name e price String e Double respectivamente.
        As propiedades públicas dacordo a convención JavaBean.
        A propiedade price debe estar ligada usando a clase PropertyChangeSupport
        Lembra os métodos para engadir e eliminar escoitadores.
    Crea unha clase ProductTest:
        Instancia un produto cun prezo inicial.
        Mostra o prezo e o desconto calculado.
        Engadimos un listerner que escoitará se o prezo cambiou e no caso de cambiar amose o valor anterior o novo e mais o novo desconto.
        Modifica o prezo tres veces, incluíndo unha repetición do mesmo valor para comprobar que non se lanza notificación.*/

package com.jdojo.exerciciosT2;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class Exercicio12_Product {
    private String name;
    private double price;
    // Obxecto auxiliar que xestiona os listeners que escoitan cambios nas propiedades
    private PropertyChangeSupport pcs = new PropertyChangeSupport(this);

    public Exercicio12_Product() {
        // Constructor baleiro onde asignamos valores por defecto ás propiedades.
        this.name = "Pan";
        this.price = 3.0;
    }

    public Exercicio12_Product(String name, double price ) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double newprice) {
        double oldPrice = this.price;
        this.price = newprice;
        // Se hai listeners rexistrados, notificaráselles que o salario cambiou cando chaman a setprice().
        // O método recibe o nome da propiedade, o valor antigo e o valor novo.
        pcs.firePropertyChange("price", oldPrice, newprice);
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
        return "name = " + name + ", price = " + price;
    }
}