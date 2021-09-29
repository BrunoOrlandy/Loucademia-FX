package br.com.aplication.controller;

import br.aplication.domain.NomeTelaEnum;
import br.com.application.startUp.StatUp;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;

public class LoginController {
	@FXML
	protected void btnLogarAction(ActionEvent event) {
		System.out.println("Logar");
		// if(is usuarioExiste())
		StatUp.changeScreen(NomeTelaEnum.MENU);
		// else{
		// retorna erro;
	}

	@FXML
	protected void btnCancelarAction(ActionEvent eventC) {
		Platform.exit();
	}
}
