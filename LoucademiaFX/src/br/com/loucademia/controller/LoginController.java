package br.com.loucademia.controller;

import br.com.loucademia.domain.tela.NomeTelaEnum;
import br.com.loucademia.startUp.StatUp;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class LoginController {
	
    @FXML
    private Button btnLogar;
	
    @FXML
    private TextField login;

    @FXML
    private PasswordField senha;    

	
	@FXML
	protected void btnLogarAction(ActionEvent event) {
					
    	if(login.getText().length() == 0)
    	{	
    		login.setStyle("-fx-border-color: red ; -fx-border-width: 1px;");
    		
    	} else if(senha.getText().length() == 0) {	
    		senha.setStyle("-fx-border-color: red ; -fx-border-width: 1px;");
    		
    	} else {
    		System.out.println("Logar");
    		StatUp.changeScreen(NomeTelaEnum.MENU);   		
    	}		
	}

	@FXML
	protected void btnCancelarAction(ActionEvent eventC) {
		Platform.exit();
	}
}
