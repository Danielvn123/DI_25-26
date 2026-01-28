package com.jdojo.fxmlexercicios.Controlador;

import java.net.URL;
import java.util.ResourceBundle;

import com.jdojo.fxmlexercicios.Modelo.Persona;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class Ex5ControllerAgregarPersona implements Initializable {

    @FXML private Button BotonCrearPersona;
    @FXML private Button BotonSair;
    @FXML private TextField TxtApelidos;
    @FXML private TextField TxtIdade;
    @FXML private TextField TxtNome;

    private Persona persoa;
    private ObservableList<Persona> persoas;

    @FXML
    void crearpersona(ActionEvent event) {
        try {
            String nome = TxtNome.getText();
            String apelidos = TxtApelidos.getText();

            if (nome == null || nome.trim().isEmpty()
                    || apelidos == null || apelidos.trim().isEmpty()) {
                throw new IllegalArgumentException("O nome e os apelidos son obrigatorios");
            }

            int idade = Integer.parseInt(TxtIdade.getText().trim());

            Persona p = new Persona(nome.trim(), apelidos.trim(), idade);

            if (persoas != null && persoas.contains(p)) {
                Alert alerta = new Alert(Alert.AlertType.ERROR);
                alerta.setHeaderText(null);
                alerta.setTitle("Error");
                alerta.setContentText("A persoa xa existe");
                alerta.showAndWait();
                return;
            }

            this.persoa = p;

            Alert alerta = new Alert(Alert.AlertType.INFORMATION);
            alerta.setHeaderText(null);
            alerta.setTitle("Información");
            alerta.setContentText("Persoa engadida");
            alerta.showAndWait();

            ((Stage) BotonCrearPersona.getScene().getWindow()).close();

        } catch (NumberFormatException e) {
            Alert alerta = new Alert(Alert.AlertType.ERROR);
            alerta.setHeaderText(null);
            alerta.setTitle("Error");
            alerta.setContentText("O formato da idade é incorrecto");
            alerta.showAndWait();

        } catch (IllegalArgumentException e) {
            Alert alerta = new Alert(Alert.AlertType.ERROR);
            alerta.setHeaderText(null);
            alerta.setTitle("Error");
            alerta.setContentText(e.getMessage());
            alerta.showAndWait();
        }
    }

    @FXML
    void sair(ActionEvent event) {
        ((Stage) BotonSair.getScene().getWindow()).close();
    }

    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {}

    public void cargarDatos(ObservableList<Persona> persoas) {
        this.persoas = persoas;
    }

    public Persona getPersoa() {
        return persoa;
    }
}