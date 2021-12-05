package br.com.loucademia.controller;

import br.com.loucademia.domain.tela.NomeTelaEnum;
import br.com.loucademia.initApp.App;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class ControleAcesso extends BaseController {

    @FXML
    private Label labelMatricula, labelRg;

    @FXML
    private TextField txtMatricula, txtRg;

    @FXML
    void btnRegistrarEntradaSaida(ActionEvent event) {

    }

    @FXML
    void btnVoltar(ActionEvent event) {
	App.changeScreen(NomeTelaEnum.MENU);
    }
}
