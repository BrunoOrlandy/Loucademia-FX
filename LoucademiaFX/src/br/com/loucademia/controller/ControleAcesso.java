package br.com.loucademia.controller;

import javax.xml.bind.ParseConversionEvent;

import br.com.loucademia.application.service.ControleAcessoService;
import br.com.loucademia.application.serviceBean.ControleAcessoServiceBean;
import br.com.loucademia.application.util.DataValidation;
import br.com.loucademia.application.util.StringUtils;
import br.com.loucademia.domain.acesso.TipoAcesso;
import br.com.loucademia.domain.aluno.Aluno;
import br.com.loucademia.domain.tela.NomeTelaEnum;
import br.com.loucademia.startUp.StartUp;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;

public class ControleAcesso {

    @FXML
    private Button btnRegistrarAcesso;

    @FXML
    private Label labelMatricula, labelCPF;

    @FXML
    private TextField txtMatricula, txtCPF;
    
    private ControleAcessoServiceBean controleAcessoService = new ControleAcessoServiceBean();
    
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
	    	
    		if (controleAcessoService.existeAluno(Integer.valueOf(txtMatricula.getText()), txtCPF.getText())) {
    			result = controleAcessoService.registrarAcesso(Integer.valueOf(txtMatricula.getText()), txtCPF.getText());
        		alert.setContentText(result + " registrada");
    		    alert.show();
    		} else {
        		alert.setContentText("Os dados estão incorretos ou não pertencem ao mesmo aluno!");
    		    alert.show();
    		}    		

		    return;
    	}	
    	
    	
		if (!StringUtils.isEmpty(txtMatricula.getText())) {
			result = controleAcessoService.registrarAcesso((Integer.valueOf(txtMatricula.getText())), null);
		} else {
			result = controleAcessoService.registrarAcesso(null, txtCPF.getText());
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
    	StartUp.changeScreen(NomeTelaEnum.MENU);
    	limparCampos();
    }
    
    private void validarCamposPrenchidosCorretamente() {
    	if (!StringUtils.isEmpty(txtMatricula.getText())) {
		    DataValidation.isIntegerValid(txtMatricula, labelMatricula, "Informe apenas numeros",
			    "Matricula");
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
