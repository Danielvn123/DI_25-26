package com.jdojo.binding; 
import javafx.beans.property.StringProperty;
import javafx.beans.property.SimpleStringProperty;

public class Person {
	// Definimos a propiedade name como unha StringProperty
	private StringProperty name = new SimpleStringProperty(this, "name", "Li");

    // Contructor baleiro para mater a convención JavaBeans
    public void Person(){
    }

	// Definimos a propiedade name como unha StringProperty
	public StringProperty nameProperty() {
		return name;
	}

	
	// Método main para probar a clase
	public static void main(String[] args) {
		Person p = new Person();
		
		// Información do bean asociado
		System.out.println("Bean asociado: " + p.nameProperty().getBean());
		System.out.println("Nome da propiedade: " + p.nameProperty().getName());
	}
	
}