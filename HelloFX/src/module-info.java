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
    opens com.jdojo.exerciciosT2 to javafx.graphics, javafx.base;
    opens com.jdojo.exerciciosT3 to javafx.graphics, javafx.base;
    opens com.jdojo.stage to javafx.graphics, javafx.base;
    opens vilas_daniel to javafx.graphics, javafx.base;
    }
