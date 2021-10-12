package br.com.loucademia.controller;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class AlunoController {	
	
    @FXML
    private TextField nome;
    
    @FXML
    private DatePicker dataDeNascimento;
    
    @FXML
    private TextField rg;

    @FXML
    private TextField rua;
    
    @FXML
    private TextField numero;
    
    @FXML
    private TextField estado;
    
    @FXML
    private TextField cidade;
    
    @FXML
    private TextField complemento;
    
	@FXML
    private TextField cep;

    @FXML
    private TextField telefoneCelular;

    @FXML
    private TextField telefoneFixo;
    
    
//    Label lblNome = new Label("Nome");
//    TextField tfNome = new TextField();
//
//    Label lblContract = new Label("Contract");
//    TextField tfContract = new TextField();
    

	@FXML
	protected void btnVoltar(ActionEvent eventC) {
		System.out.println("Voltar");
		Platform.exit();
	}

	@FXML
	protected void btnSalvarAction(ActionEvent eventC) {
		System.out.println("Registro Salvo");
	}
}
