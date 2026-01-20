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
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;

public class Ex2Controller implements Initializable{

	    @FXML
	    private Button Boton1;

	    @FXML
	    private Button Boton2;

	    @FXML
	    private Label Label1;

	    @FXML
	    private Label Label2;

	    @FXML
	    private Label Label3;

	    @FXML
	    private RadioButton RadioButtonDivision;

	    @FXML
	    private RadioButton RadioButtonMultiplicacion;

	    @FXML
	    private RadioButton RadioButtonResta;

	    @FXML
	    private RadioButton RadioButtonSuma;

	    @FXML
	    private TextField TextField1;

	    @FXML
	    private TextField TextField2;

	    @FXML
	    private TextField TextField3;

	    @FXML
	    void limpar(ActionEvent event) {
	    	this.TextField1.clear();
	    	this.TextField2.clear();
	    	this.TextField3.clear();

	    }

	    @FXML
	    void operar(ActionEvent event) {

	    	try {
				int op1 = Integer.parseInt(this.TextField1.getText());
				int op2 = Integer.parseInt(this.TextField2.getText());
				
				OperacionesEx2 Op = new OperacionesEx2(op1,op2);
				
				if(RadioButtonSuma.isSelected()) {
					this.TextField3.setText(String.valueOf(Op.suma(op1)));
				}else if(RadioButtonResta.isSelected()) {
					this.TextField3.setText(String.valueOf(Op.resta(op1)));
				}else if(RadioButtonMultiplicacion.isSelected()) {
					this.TextField3.setText(String.valueOf(Op.multiplicacion(op1)));
				}else if(RadioButtonDivision.isSelected()) {
					this.TextField3.setText(String.valueOf(Op.division(op1)));
				}else {
					Alert alerta = new Alert (Alert. AlertType. INFORMATION) ;
					alerta. setHeaderText (null) ;
					alerta. setTitle ("Información") ;
					alerta.setContentText ("Selecciona unha operación") ;
					alerta. showAndWait () ;
				}

			} catch (NumberFormatException e) {
				
				Alert alerta = new Alert(Alert.AlertType.ERROR);
				alerta.setHeaderText(null);
				alerta.setTitle("Erro");
				alerta.setContentText("Formato incorrecto");
				alerta.showAndWait();
				
			} catch (ArithmeticException e) {
				Alert alerta = new Alert (Alert. AlertType. ERROR) ;
				alerta. setHeaderText (null) ;
				alerta.setTitle ("Erro") ;
				alerta.setContentText (e.getMessage () );
				alerta. showAndWait () ;
			}
	    }

	    ToggleGroup tg;

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		tg = new ToggleGroup();
		this.RadioButtonSuma.setToggleGroup(tg);
		this.RadioButtonResta.setToggleGroup(tg);
		this.RadioButtonMultiplicacion.setToggleGroup(tg);
		this.RadioButtonDivision.setToggleGroup(tg);
	}

}
