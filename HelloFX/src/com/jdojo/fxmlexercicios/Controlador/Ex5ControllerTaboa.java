package com.jdojo.fxmlexercicios.Controlador;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import com.jdojo.fxmlexercicios.Modelo.Persona;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class Ex5ControllerTaboa implements Initializable {

    @FXML private TableColumn<Persona, String> ApelidosColum;
    @FXML private Button BotonAgregar;
    @FXML private TableColumn<Persona, Integer> IdadeColum;
    @FXML private TableColumn<Persona, String> NomeColum;
    @FXML private TableView<Persona> Tabla;

    private ObservableList<Persona> persoas;

    @FXML
    void seleccionar(MouseEvent event) {}

    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        persoas = FXCollections.observableArrayList();
        Tabla.setItems(persoas);

        NomeColum.setCellValueFactory(new PropertyValueFactory<>("nome"));
        ApelidosColum.setCellValueFactory(new PropertyValueFactory<>("apelidos"));
        IdadeColum.setCellValueFactory(new PropertyValueFactory<>("idade"));
    }

    @FXML
    void agregar(ActionEvent event) {
    	
        String ruta = "/com/jdojo/fxmlexercicios/Vista/Ex5VistaAgregarPersona.fxml";

        if (getClass().getResource(ruta) == null) {
            Alert a = new Alert(Alert.AlertType.ERROR);
            a.setHeaderText(null);
            a.setTitle("Error");
            a.setContentText("No se encuentra el FXML en: " + ruta);
            a.showAndWait();
            return;
        }

        FXMLLoader loader = new FXMLLoader(getClass().getResource(ruta));

        try {
            Parent root = loader.load();

            Ex5ControllerAgregarPersona controlador = loader.getController();
            controlador.cargarDatos(persoas);

            Stage stage = new Stage();
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.setScene(new Scene(root));
            stage.setTitle("Crear persoa");
            stage.showAndWait();

            Persona p = controlador.getPersoa();
            if (p != null) {
                persoas.add(p);
                Tabla.refresh();
            }

        } catch (IOException e) {
            e.printStackTrace();
            Alert a = new Alert(Alert.AlertType.ERROR);
            a.setHeaderText(null);
            a.setTitle("Error");
            a.setContentText("Error cargando el FXML: " + e.getMessage());
            a.showAndWait();
        }
    }
}