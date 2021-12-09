package br.com.loucademia.controller;

import br.com.loucademia.initApp.App;
import br.com.loucademia.model.model.Aluno;
import br.com.loucademia.model.model.enums.NomeTelaEnum;
import br.com.loucademia.model.model.enums.TipoAcesso;
import br.com.loucademia.model.service.AcessoService;
import br.com.loucademia.model.serviceBean.AcessoServiceBean;
import br.com.loucademia.model.util.DataValidation;
import br.com.loucademia.model.util.StringUtils;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class AcessoController extends BaseController {

    @FXML
    private Button btnRegistrarAcesso;

    @FXML
    private Label labelMatricula, labelCPF;

    @FXML
    private TextField txtMatricula, txtCPF;

    private AcessoServiceBean acessoService = new AcessoServiceBean();

    @FXML
    void btnRegistrarAcessoAction(ActionEvent event) {

	validarCamposPrenchidosCorretamente();

	Alert alert = new Alert(AlertType.INFORMATION);

	if (StringUtils.isEmpty(txtMatricula.getText()) && StringUtils.isEmpty(txtCPF.getText())) {
	    alert.setContentText("E preciso fornecer a matricula ou o CPF do aluno");
	    alert.show();
	    return;
	}

	TipoAcesso result;

	if (!StringUtils.isEmpty(txtMatricula.getText()) && !StringUtils.isEmpty(txtCPF.getText())) {

	    if (acessoService.existeAluno(Integer.valueOf(txtMatricula.getText()), txtCPF.getText())) {
		result = acessoService.registrarAcesso(Integer.valueOf(txtMatricula.getText()), txtCPF.getText());
		alert.setContentText(result + " registrada");
		alert.show();
	    } else {
		alert.setContentText("Os dados estão incorretos ou não pertencem ao mesmo aluno!");
		alert.show();
	    }

	    return;
	}

	if (!StringUtils.isEmpty(txtMatricula.getText())) {
	    result = acessoService.registrarAcesso((Integer.valueOf(txtMatricula.getText())), null);
	} else {
	    result = acessoService.registrarAcesso(null, txtCPF.getText());
	}

	if (result == null) {
	    alert.setContentText("O aluno nao foi encontrado");
	    alert.show();
	} else {
	    alert.setContentText(result + " registrada");
	    alert.show();
	}

    }

    @FXML
    void btnVoltar(ActionEvent event) {
	getApp().changeScreen(NomeTelaEnum.MENU);
	limparCampos();
    }

    private void validarCamposPrenchidosCorretamente() {
	if (!StringUtils.isEmpty(txtMatricula.getText())) {
	    DataValidation.isIntegerValid(txtMatricula, labelMatricula, "Informe apenas numeros", "Matricula");
	    return;

	} else {
	    DataValidation.showDinamico(txtMatricula, labelMatricula, true);
	}

	if (!StringUtils.isEmpty(txtCPF.getText())) {
	    DataValidation.isCPF(txtCPF, labelCPF, "Informe apenas numeros");
	    return;

	} else {
	    DataValidation.showDinamico(txtCPF, labelCPF, true);
	}
    }

    private void limparCampos() {
	txtMatricula.clear();
	txtCPF.clear();
    }
}
