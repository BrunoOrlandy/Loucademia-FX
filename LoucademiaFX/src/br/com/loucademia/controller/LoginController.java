package br.com.loucademia.controller;

import java.net.URL;
import java.util.ResourceBundle;

import br.com.loucademia.domain.tela.NomeTelaEnum;
import br.com.loucademia.startUp.Menu;
import br.com.loucademia.startUp.NovoAluno;
import br.com.loucademia.startUp.StatUp;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class LoginController implements Initializable {

	@FXML
	private TextField login;

	@FXML
	private PasswordField senha;

	@FXML
	private Button btnLogarAction;

	@FXML
	private Button btnCancelarAction;

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		if (login.getText().length() == 0) {
			login.setStyle("-fx-border-color: red ; -fx-border-width: 1px;");
		} else if (senha.getText().length() == 0) {
			senha.setStyle("-fx-border-color: red ; -fx-border-width: 1px;");
		} else {
			btnLogarAction.setOnMouseClicked((MouseEvent e) -> {
				try {
					Menu menu = new Menu();
					menu.start(new Stage());
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			});

		}
	}

	
}
