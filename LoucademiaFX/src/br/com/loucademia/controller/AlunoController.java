package br.com.loucademia.controller;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class AlunoController {
	

    @FXML
    private TextField idNome;

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
