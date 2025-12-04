package com.jdojo.stage;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.collections.ObservableList;
import javafx.geometry.Rectangle2D;
import javafx.stage.Screen;
import javafx.stage.Stage;

public class ScreenDetailsApp extends Application {
    public static void main(String[] args) {
        Application.launch(args);
    }

    public void start(Stage stage) {
        ObservableList<Screen> screenList = Screen.getScreens();
        System.out.println("Número de pantallas: " + screenList.size());

        // Imprimir os detalles de cada pantalla
        for(Screen screen: screenList) {
            print(screen);
        }
        Platform.exit();
    }

    public void print(Screen s) {
        System.out.println("DPI: " + s.getDpi());

        System.out.print("Bounds da pantalla: ");
        Rectangle2D bounds = s.getBounds();
        print(bounds);

        System.out.print("Visual Bounds da pantalla: ");
        Rectangle2D visualBounds = s.getVisualBounds();
        print(visualBounds);

        System.out.println("-----------------------");
    }

    public void print(Rectangle2D r) {
        System.out.format(
            "minX=%.2f, minY=%.2f, width=%.2f, height=%.2f%n",
            r.getMinX(), r.getMinY(),
            r.getWidth(), r.getHeight()
        );
    }
}