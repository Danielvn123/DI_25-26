module HelloFX {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.graphics;
    requires javafx.media;
    requires javafx.web;
    requires javafx.swing;
    requires java.desktop;
    requires jdk.jsobject;
	requires javafx.base;

    opens com.jdojo.intro to javafx.graphics, javafx.base;
    opens com.jdojo.binding to javafx.graphics, javafx.base;
    opens com.jdojo.exercicios to javafx.graphics, javafx.base;
    }
