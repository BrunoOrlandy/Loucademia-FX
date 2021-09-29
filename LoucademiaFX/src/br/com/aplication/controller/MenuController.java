package br.com.aplication.controller;

import br.aplication.domain.NomeTelaEnum;
import br.com.application.startUp.StatUp;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.stage.Stage;

public class MenuController {

	@FXML
	protected void btnNovoAluno(ActionEvent event) {
		StatUp.changeScreen(NomeTelaEnum.NOVO_ALUNO);
	}

	@FXML
	protected void btnPesquisaAluno(ActionEvent event) {
		nextPage(NomeTelaEnum.PESQUISAR_ALUNO);
	}

	@FXML
	protected void btnControleDeAcesso(ActionEvent event) {
		nextPage(NomeTelaEnum.CONTROLE_ACESSO);
	}

	@FXML
	protected void btnRelatoriosDeEntradaEsaida(ActionEvent event) {
		nextPage(NomeTelaEnum.RELATORIO_ENTRADA_SAIDA);
	}

	@FXML
	protected void btnRelatoriosDeSituacao(ActionEvent event) {
		nextPage(NomeTelaEnum.RELATORIO_SITUACAO);
	}

	public void nextPage(NomeTelaEnum nextPage) {
		if (nextPage.equals(nextPage)) {
			nextPage = null;
		}
		StatUp.changeScreen(nextPage);
	}

}
