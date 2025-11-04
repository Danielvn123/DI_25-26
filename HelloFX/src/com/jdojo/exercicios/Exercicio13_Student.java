package com.jdojo.exercicios;

import javafx.beans.property.ReadOnlyStringWrapper;
import javafx.beans.property.StringProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.ReadOnlyStringProperty;
import javafx.beans.property.SimpleDoubleProperty;

public class Exercicio13_Student {

	private ReadOnlyStringWrapper id = new ReadOnlyStringWrapper(this, "id");
	private StringProperty name = new SimpleStringProperty(this, "name");
	private DoubleProperty averageGrade = new SimpleDoubleProperty(this, "averageGrade");

	public Exercicio13_Student() {

	}

	public Exercicio13_Student(String id, String name, double averageGrade) {
		this.id.set(id);
		this.name.set(name);
		this.averageGrade.set(averageGrade);
	}

	public String getId() {
		return id.get();
	}

	public ReadOnlyStringProperty idProperty() {
		return id.getReadOnlyProperty();
	}

	public String getName() {
		return name.get();
	}

	public void setName(String name) {
		this.name.set(name);
	}

	public double getAverageGrade() {
		return averageGrade.get();
	}

	public void setAverageGrade(double averageGrade) {
		this.averageGrade.set(averageGrade);
	}

	public StringProperty nameProperty() {
		return this.name;
	}

	public DoubleProperty averageGradeProperty() {
		return this.averageGrade;
	}
}
