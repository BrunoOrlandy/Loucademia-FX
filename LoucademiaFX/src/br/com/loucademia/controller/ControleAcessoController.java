package br.com.loucademia.controller;

import br.com.loucademia.application.service.ControleAcessoService;
import br.com.loucademia.application.serviceBean.ControleAcessoServiceBean;
import br.com.loucademia.application.util.DataValidation;
import br.com.loucademia.application.util.StringUtils;
import br.com.loucademia.domain.aluno.Aluno;
import br.com.loucademia.domain.tela.NomeTelaEnum;
import br.com.loucademia.initApp.App;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class ControleAcessoController extends BaseController {

    @FXML
    private Button btnRegistrarAcesso;

    @FXML
    private Label labelMatricula, labelCPF;

    @FXML
    private TextField txtMatricula, txtCPF;

    @FXML
    void btnRegistrarAcessoAction(ActionEvent event) {

	Aluno alunoPesquisa = new Aluno();
	validarCamposPrenchidosCorretamente();

	ControleAcessoService controleAcessoService = new ControleAcessoServiceBean();

	if (StringUtils.isEmpty(txtMatricula.getText()) && StringUtils.isEmpty(txtCPF.getText())) {
	    Alert alert = new Alert(AlertType.INFORMATION);
	    alert.setContentText("E preciso fornecer a matricula ou o RG do aluno");
	    alert.show();
	}

	if (!StringUtils.isEmpty(txtMatricula.getText())) {
	    System.out.println("Procurando aluno pelo ID");
	    alunoPesquisa.setId(Integer.valueOf(txtMatricula.getText()));

	} else {
	    System.out.println("Procurando aluno pelo CPF");
	    alunoPesquisa.setCpf(txtCPF.getText());
	}

	Alert alert = new Alert(AlertType.INFORMATION);
	alert.setContentText(
		controleAcessoService.registrarAcesso((Integer.valueOf(txtMatricula.getText())), txtCPF.getText())
			+ " registrada!");
	alert.show();

    }

    @FXML
    void btnVoltar(ActionEvent event) {
	App.changeScreen(NomeTelaEnum.MENU);
	limparCampos();
    }

    private void validarCamposPrenchidosCorretamente() {
	boolean isValidTelefone, isValidMatricula, isValidCPF, isNomeValido = false;

	if (!StringUtils.isEmpty(txtMatricula.getText())) {
	    isValidMatricula = DataValidation.isIntegerValid(txtMatricula, labelMatricula, "Informe apenas Numeros",
		    "Matricula");
	}

	if (!StringUtils.isEmpty(txtCPF.getText())) {
	    isValidCPF = DataValidation.isCPF(txtCPF, labelCPF, "Informe apenas números");
	}
    }

    private void limparCampos() {
	txtMatricula.clear();
	txtCPF.clear();
    }

}
