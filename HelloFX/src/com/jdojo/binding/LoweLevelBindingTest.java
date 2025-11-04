package com.jdojo.binding;

import javafx.beans.binding.DoubleBinding;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;

public class LoweLevelBindingTest {
	
	public static void main(String[] args) {
		
	//Esta é a propiedade da que dependemos	
		final DoubleProperty radius = new SimpleDoubleProperty();
		
		
		//
		DoubleBinding areaBinding = new DoubleBinding() {
			
			//Paso 2
			{
				this.bind(radius);
			}

			@Override
			protected double computeValue() {
				//Paso 3 lóxica propia
				return radius.get() * radius.get() * Math.PI;
			}
		};
	}

}