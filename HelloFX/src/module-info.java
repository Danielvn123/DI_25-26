module HelloFX {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.graphics;
    requires javafx.media;
    requires javafx.web;
    requires javafx.swing;
    requires java.desktop;
    requires jdk.jsobject;

    opens com.jdojo.intro to javafx.fxml, javafx.graphics;
    }
