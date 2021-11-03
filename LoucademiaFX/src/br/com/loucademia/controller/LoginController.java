package br.com.loucademia.controller;

import br.com.loucademia.application.service.LoginService;
import br.com.loucademia.domain.tela.NomeTelaEnum;
import br.com.loucademia.startUp.StartUp;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class LoginController {

    private final static String ERROR_CSS = "-fx-border-color: red ; -fx-border-width: 1px;";

    @FXML
    private Button btnLogar;

    @FXML
    private TextField login;

    @FXML
    private PasswordField senha;

    @FXML
    protected void btnLogarAction(ActionEvent event) {
	LoginService service = new LoginService();
	Alert alert = new Alert(AlertType.NONE);

	validarCamposPreenchidos(login, senha);

	boolean usuarioExiste = service.existeUsuario(login.getText(), senha.getText());

	if (usuarioExiste) {
	    alert.setAlertType(AlertType.INFORMATION);
	    alert.setContentText("Login realizado com sucesso");
	    alert.show();
	    StartUp.changeScreen(NomeTelaEnum.MENU);
	} else {
	    alert.setAlertType(AlertType.WARNING);
	    alert.setContentText("login ou Senha invalidos");
	    alert.show();
	}
    }

    @FXML
    protected void btnCancelarAction(ActionEvent eventC) {
	Platform.exit();
    }

    private void validarCamposPreenchidos(TextField login, PasswordField senha) {

	if (login.getText().isBlank()) {
	    login.setStyle(ERROR_CSS);
	}
	if (senha.getText().isBlank()) {
	    senha.setStyle(ERROR_CSS);
	}
    }
}
