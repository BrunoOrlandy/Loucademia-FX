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

public class MenuController {

	@FXML
	protected void btnNovoAluno(ActionEvent event) {
//		Parent fxmlNovoAluno = FXMLLoader.load(getClass().getResource("/br/com/loucademia/view/novo_aluno.fxml"));
		StatUp.changeScreen(NomeTelaEnum.NOVO_ALUNO);
	}

	@FXML
	protected void btnPesquisaAluno(ActionEvent event) {
		StatUp.changeScreen(NomeTelaEnum.PESQUISAR_ALUNO);
	}

	@FXML
	protected void btnControleDeAcesso(ActionEvent event) {
		StatUp.changeScreen(NomeTelaEnum.CONTROLE_ACESSO);
	}

	@FXML
	protected void btnRelatoriosDeEntradaEsaida(ActionEvent event) {
		StatUp.changeScreen(NomeTelaEnum.RELATORIO_ENTRADA_SAIDA);
	}

	@FXML
	protected void btnRelatoriosDeSituacao(ActionEvent event) {
		StatUp.changeScreen(NomeTelaEnum.RELATORIO_SITUACAO);
	}

	public void nextPage(NomeTelaEnum nextPage) {
		if (nextPage.equals(nextPage)) {
			nextPage = null;
		}
		
		StatUp.changeScreen(nextPage);
	}

}
