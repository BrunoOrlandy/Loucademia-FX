package br.com.loucademia.controller;

import br.com.loucademia.domain.tela.NomeTelaEnum;
import br.com.loucademia.initApp.App;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;

public class RelatorioController extends BaseController {

    @FXML
    void btnPesquisar(ActionEvent event) {

    }

    @FXML
    void btnVoltar(ActionEvent event) {
	App.changeScreen(NomeTelaEnum.MENU);
    }
}
