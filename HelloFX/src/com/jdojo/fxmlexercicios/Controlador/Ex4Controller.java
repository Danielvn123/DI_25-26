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
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;

public class Ex4Controller implements Initializable {

	@FXML
	private Button Boton;

	@FXML
	private Button Boton2;

	@FXML
	private Button Boton3;

	@FXML
	private TableColumn<?, ?> Apelidos;

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

	
	@FXML
	void ModificarPersona(ActionEvent event) {
		Persona p = this.Tabla.getSelectionModel().getSelectedItem();
		
		if(p!=null) {
			
			try {
			String nome = this.TxNome.getText();
			String apelidos = this.TxApelidos.getText();
			int idade = Integer.parseInt(this.TxIdade.getText());
			
			Persona aux = new Persona(nome, apelidos, idade);		
			
			if(!this.personas.contains(aux)) {
				
				p.setNome(aux.getNome());
				p.setApelidos(aux.getApelidos());
				p.setIdade(aux.getIdade());
				
				//Informacion éxito
				this.Tabla.refresh();
				
				amosarAlerta(AlertType.INFORMATION, "A persoa se modificou correctamente");
				
				this.TxNome.clear();
				this.TxApelidos.clear();
				this.TxIdade.clear();
			}else {
				//Erro no se modificaron datos
				amosarAlerta(AlertType.ERROR,"Non hai datos que modificar");
			}

			}catch(NumberFormatException e) {
				//Formato de idade incorrecto
			amosarAlerta(AlertType.ERROR,"Formato de idade incorrecto");
			}
			
		}else {
			
			//Erro debes selccionar una persona para modificar
			amosarAlerta(AlertType.ERROR, "Debes seleccionar unha persoa para modificar");
		}
	}
	
	@FXML
	void BorrarPersona(ActionEvent event) {

	}
	
	@FXML
	void seleccionar(MouseEvent event) {
		
		//Ex4 Paso 1. Coller a persoa da táboa 
		
		Persona p = this.Tabla.getSelectionModel().getSelectedItem();
		
		if(p!=null) {
			this.TxNome.setText(p.getNome());
			this.TxApelidos.setText(p.getApelidos());
			this.TxIdade.setText(String.valueOf(p.getIdade()));
		}
	}
	
	private void amosarAlerta(AlertType tipo, String msg) {
		
		Alert alerta = new Alert(tipo);
		alerta.setHeaderText(null);
		alerta.setTitle(tipo.toString());
		alerta.setContentText(msg);
		alerta.showAndWait();
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
