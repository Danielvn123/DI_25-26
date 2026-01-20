package com.jdojo.fxmlexercicios.Controlador;

import java.net.URL;
import java.util.ResourceBundle;

import com.jdojo.fxmlexercicios.Modelo.OperacionesEx2;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class Ex1Controller implements Initializable {

	@FXML
	private Button Boton1;

	@FXML
	private Label Label1;

	@FXML
	private Label Label2;

	@FXML
	private Label Label3;

	@FXML
	private TextField TextField1;

	@FXML
	private TextField TextField2;

	@FXML
	private TextField TextField3;

	@FXML
	void sumar(ActionEvent event) {

		try {
			int op1 = Integer.parseInt(this.TextField1.getText());
			int op2 = Integer.parseInt(this.TextField2.getText());

			this.TextField3.setText(String.valueOf(op1 + op2));
		} catch (NumberFormatException e) {
			
			Alert alerta = new Alert(Alert.AlertType.ERROR);
			alerta.setHeaderText(null);
			alerta.setTitle("Erro");
			alerta.setContentText("Formato incorrecto");
			alerta.showAndWait();
		}

	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub

	}

}
