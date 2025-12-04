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
        Modifica o prezo tres veces, incluíndo unha repetición do mesmo valor para comprobar que non se lanza notificación.
*/

// EmployeeTest.java
package com.jdojo.exerciciosT2;
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
/*
import java.beans.PropertyChangeEvent;

public class ProductTest {

	public static void main (String[] args) {
		Product newProduct = new Product();
		
		System.out.println(newProduct);
		computeDiscount(newProduct.getPrice());
		
		//4. Suscribimos un listener ao prezo do produto.
		newProduct.addPropertyChangeListener(ProductTest::handlePropertyChange);
		
		//6. Modificamos o prezo para comprobar se lanzamos o listener.
		newProduct.setPrice(20.0);
		newProduct.setPrice(20.0);
		newProduct.setPrice(30.0);
	}
	
	
	//5. O listener é a implementación da interface
	public static void handlePropertyChange(PropertyChangeEvent e) {
	      String propertyName= e.getPropertyName();
	      if("price".equals(propertyName)) {
	    	  System.out.println("Precio novo " + e.getNewValue());
	    	  System.out.println("Precio antigo " + e.getOldValue());
	    	  computeDiscount((Double)e.getNewValue());
	      }
	}


	private static void computeDiscount(Double newValue) {
		final double DISCOUNT = 10.0;
		double discount = newValue - (newValue * DISCOUNT /100);
		System.out.println("--------- Calculo desconto -----------");
  	  	System.out.println("Precio novo: " + newValue + " Precio con desconto: " + discount);
  	  	System.out.println("-------------------------------------");
	}
}
*/