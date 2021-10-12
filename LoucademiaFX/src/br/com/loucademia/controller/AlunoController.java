package br.com.loucademia.controller;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;

public class AlunoController {	

	@FXML
    private TextField cep;

    @FXML
    private TextField cidade;

    @FXML
    private TextField complemento;

    @FXML
    private DatePicker dataDeNascimento;

    @FXML
    private TextField estado;

    @FXML
    private TextField nome;

    @FXML
    private TextField numero;

    @FXML
    private TextField rg;

    @FXML
    private TextField rua;

    @FXML
    private TextField telefoneCelular;

    @FXML
    private TextField telefoneFixo;

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
