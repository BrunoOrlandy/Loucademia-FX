package br.com.loucademia.controller;

import java.net.URL;
import java.util.ResourceBundle;

import br.com.loucademia.startUp.NovoAluno;
import br.com.loucademia.startUp.StatUp;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class MenuController implements Initializable {

	private static Stage stageMenu;

	@FXML
	private Button btnNovoAluno;

	@FXML
	private Button btnPesquisaAluno;

	@FXML
	private Button btnControleDeAcesso;

	@FXML
	private Button btnRelatoriosDeEntradaEsaida;

	@FXML
	private Button btnRelatoriosDeSituacao;

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {

		btnNovoAluno.setOnMouseClicked((MouseEvent e) -> {
			try {
				NovoAluno novoAluno = new NovoAluno();
				novoAluno.start(new Stage());
			} catch (Exception e1) {
				e1.printStackTrace();
			}

		});

		btnPesquisaAluno.setOnMouseClicked((MouseEvent e) -> {

		});
		btnControleDeAcesso.setOnMouseClicked((MouseEvent e) -> {

		});
		btnRelatoriosDeSituacao.setOnMouseClicked((MouseEvent e) -> {

		});

	}

	public static Stage getStageMenu() {
		return stageMenu;
	}

	public static void setStageMenu(Stage stageMenu) {
		MenuController.stageMenu = stageMenu;
	}

	public void fechar() {
		StatUp.getStage().close();
	}

}
