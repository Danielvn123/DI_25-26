package com.jdojo.binding;

import javafx.beans.property.SimpleDoubleProperty;

import java.util.Locale;

import javafx.beans.binding.Bindings;
import javafx.beans.binding.StringExpression;
import javafx.beans.property.DoubleProperty;

public class BindingClassTest {

	public static void main(String [] args) {
		
		DoubleProperty radius = new SimpleDoubleProperty(7.0);
		DoubleProperty area = new SimpleDoubleProperty(0.0);
		
		area.bind(Bindings.multiply(Bindings.multiply(radius, radius), Math.PI));
		
		StringExpression desc = Bindings.format(Locale.US,
				"Radio = %.2f, Area = %.2f", radius, area
				);
		
		//Cando cambiamos o radio, a 'area' actualizase automaticamente
		radius.set(14.0);
		System.out.print(desc.getValue());
		//Saída: Radio = 14.0, Area = 615.7521601035994
	}
	
}
