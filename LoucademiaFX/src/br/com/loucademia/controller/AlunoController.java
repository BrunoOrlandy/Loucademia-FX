package br.com.aplication.controller;

import br.aplication.domain.NomeTelaEnum;
import br.com.application.startUp.StatUp;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;

public class AlunoController {
	
	@FXML
	protected void btnCancelarAction(ActionEvent eventC) {
		StatUp.changeScreen(NomeTelaEnum.MENU);
	}

	@FXML
	protected void btnSalvarAction(ActionEvent eventC) {
		System.out.println("Registro Salvo");
	}
}
