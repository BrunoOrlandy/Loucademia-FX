package br.com.loucademia.controller;

import br.com.loucademia.initApp.App;
import br.com.loucademia.model.model.enums.NomeTelaEnum;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;

public class MenuController extends BaseController {

    @FXML
    protected void btnNovoAluno(ActionEvent event) {
	getApp().getAlunoController().novoAluno();
    }

    @FXML
    protected void btnPesquisaAluno(ActionEvent event) {
	App.changeScreen(NomeTelaEnum.PESQUISAR_ALUNO);
    }

    @FXML
    protected void btnControleDeAcesso(ActionEvent event) {
	App.changeScreen(NomeTelaEnum.CONTROLE_ACESSO);
    }

    @FXML
    protected void btnRelatoriosDeEntradaEsaida(ActionEvent event) {
	App.changeScreen(NomeTelaEnum.RELATORIO_ENTRADA_SAIDA);
    }

    @FXML
    protected void btnRelatoriosDeSituacao(ActionEvent event) {
	App.changeScreen(NomeTelaEnum.RELATORIO_SITUACAO);
    }

    public void nextPage(NomeTelaEnum nextPage) {
	if (nextPage.equals(nextPage)) {
	    nextPage = null;
	}
	App.changeScreen(nextPage);
    }

}
