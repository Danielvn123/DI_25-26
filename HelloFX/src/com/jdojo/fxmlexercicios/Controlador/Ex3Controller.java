package com.jdojo.fxmlexercicios.Controlador;

import java.net.URL;
import java.util.ResourceBundle;

import com.jdojo.fxmlexercicios.Modelo.Persona;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

public class Ex3Controller implements Initializable{

    @FXML
    private TableColumn<?, ?> Apelidos;

    @FXML
    private Button Boton;

    @FXML
    private TableColumn<?, ?> Idade;

    @FXML
    private TableColumn<?, ?> Nome;

    @FXML
    private TableView<Persona> Tabla;

    @FXML
    private TextField TxApelidos;

    @FXML
    private TextField TxIdade;

    @FXML
    private TextField TxNome;

	// Ex3 Paso 4 Debemos crear un ObservableList para vincular este á táboa
	ObservableList<Persona> personas;

	@FXML
	void AgregarPersona(ActionEvent event) {

		// Ex3 Paso 7 Coller datos do TextField e gardalos na lista persoas
		try {
			String nome = this.TxNome.getText();
			String apelidos = this.TxApelidos.getText();
			int idade = Integer.parseInt(this.TxIdade.getText());

			Persona p = new Persona(nome, apelidos, idade);

			if (!this.personas.contains(p)) {
				this.personas.add(p);

				this.Tabla.refresh();
			} else {
				Alert alerta = new Alert(Alert.AlertType.ERROR);
				alerta.setHeaderText(null);
				alerta.setTitle("Erro");
				alerta.setContentText("Persoa xa existe na táboa");
				alerta.showAndWait();
			}
		} catch (NumberFormatException e) {
			Alert alerta = new Alert(Alert.AlertType.ERROR);
			alerta.setHeaderText(null);
			alerta.setTitle("Erro");
			alerta.setContentText("O formato da idade non é correcto");
			alerta.showAndWait();
		}
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		personas = FXCollections.observableArrayList();

		// Ex3 Paso 6 Sincronizar táboa con lista persoas
		this.Tabla.setItems(personas);

		// EX3 Paso 5.Vinculamos cada columna da táboa con un atributo dunha clase, no
		// noso caso persoa
		// Este método traballa por reflexión, é dicir, inspecciona nos paquetes se
		// existe
		// 1. Busca algún nomeProperty()
		// 2. getNome()
		this.Nome.setCellValueFactory(new PropertyValueFactory("nome"));
		this.Apelidos.setCellValueFactory(new PropertyValueFactory("apelidos"));
		this.Idade.setCellValueFactory(new PropertyValueFactory("idade"));

	}
}
