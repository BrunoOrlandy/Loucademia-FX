package br.com.loucademia.controller;

import br.com.loucademia.domain.tela.NomeTelaEnum;
import br.com.loucademia.startUp.StatUp;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;

public class LoginController {
	@FXML
	protected void btnLogarAction(ActionEvent event) {
		StatUp.changeScreen(NomeTelaEnum.MENU);
		System.out.println("Logar");
	}

	@FXML
	protected void btnCancelarAction(ActionEvent eventC) {
		Platform.exit();
	}
}
