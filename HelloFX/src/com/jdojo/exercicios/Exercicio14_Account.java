package com.jdojo.exercicios;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;

public class Exercicio14_Account {
	
	private DoubleProperty balance = new SimpleDoubleProperty(this,"balance",100);
	
	public Exercicio14_Account() {
		
	}
	
	public Exercicio14_Account(double balance){
		this.balance.set(balance);
	}
	
	public final double getBalance() {
		return balance.get();
	}
	
	public final void setBalance(double balance) {
		this.balance.set(balance);
	}
	
	public final DoubleProperty balanceProperty() {
		return this.balance;
	}

}
