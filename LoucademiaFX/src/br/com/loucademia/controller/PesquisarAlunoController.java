package br.com.loucademia.controller;

import java.io.IOException;


import br.com.loucademia.domain.tela.NomeTelaEnum;
import br.com.loucademia.startUp.StatUp;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class PesquisarAlunoController {

    @FXML
    void btnPesquisar(ActionEvent event) {
    	System.out.println("Pesquisar aluno!");
    }

    @FXML
    void btnVoltar(ActionEvent event) {
    	StatUp.changeScreen(NomeTelaEnum.MENU);
    }
	

}
