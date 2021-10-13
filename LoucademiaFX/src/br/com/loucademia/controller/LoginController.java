package br.com.loucademia.controller;

import br.com.loucademia.domain.tela.NomeTelaEnum;
import br.com.loucademia.startUp.StatUp;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class LoginController {
	
	
    @FXML
    private TextField login;

    @FXML
    private TextField senha;
    
	
	@FXML
	protected void btnLogarAction(ActionEvent event) {
					
    	if(login.getText().length() == 0)
    	{	
    		login.setStyle("-fx-border-color: red ; -fx-border-width: 1px;");
    	} else if(senha.getText().length() == 0) {	
    		senha.setStyle("-fx-border-color: red ; -fx-border-width: 1px;");
    	} else {
    		StatUp.changeScreen(NomeTelaEnum.MENU);
    	}
		
		System.out.println("Logar");
	}

	@FXML
	protected void btnCancelarAction(ActionEvent eventC) {
		Platform.exit();
	}
}
