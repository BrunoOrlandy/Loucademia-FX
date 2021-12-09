package br.com.loucademia.controller;

import java.sql.SQLException;

import br.com.loucademia.initApp.App;
import br.com.loucademia.model.model.enums.NomeTelaEnum;
import br.com.loucademia.model.serviceBean.LoginServiceBean;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class LoginController extends BaseController {

    private final static String ERROR_CSS = "-fx-border-color: red ; -fx-border-width: 1px;";

    @FXML
    private Button btnLogar;

    @FXML
    private TextField login;

    @FXML
    private PasswordField senha;

    @FXML
    protected void btnLogarAction(ActionEvent event) {
	LoginServiceBean service = new LoginServiceBean();
	Alert alert = new Alert(AlertType.NONE);

	validarCamposPreenchidos(login, senha);
	boolean usuarioExiste = false;
	try {
	    usuarioExiste = service.existeUsuario(login.getText(), senha.getText());
	} catch (SQLException e) {
	    e.printStackTrace();
	}

	if (usuarioExiste) {
	    alert.setAlertType(AlertType.INFORMATION);
	    alert.setContentText("Login realizado com sucesso");
	    alert.show();
	    App.changeScreen(NomeTelaEnum.MENU);
	} else {
	    alert.setAlertType(AlertType.WARNING);
	    alert.setContentText("Login ou Senha invalidos");
	    alert.show();
	    limparCampos();
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

    public void limparCampos() {
	login.clear();
	senha.clear();

    }
}
