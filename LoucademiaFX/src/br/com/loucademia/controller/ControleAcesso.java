package br.com.loucademia.controller;

import br.com.loucademia.domain.tela.NomeTelaEnum;
import br.com.loucademia.startUp.StatUp;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;

public class ControleAcesso {

    @FXML
    void btnRegistrarEntradaSaida(ActionEvent event) {

    }

    @FXML
    void btnVoltar(ActionEvent event) {
    	StatUp.changeScreen(NomeTelaEnum.MENU);
    }
}
