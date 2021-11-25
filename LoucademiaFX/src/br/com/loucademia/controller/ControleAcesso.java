package br.com.loucademia.controller;

import java.time.LocalDateTime;

import br.com.loucademia.application.serviceBean.ControleAcessoServiceBean;
import br.com.loucademia.application.util.StringUtils;
import br.com.loucademia.domain.aluno.Acesso;
import br.com.loucademia.domain.aluno.Aluno;
import br.com.loucademia.domain.tela.NomeTelaEnum;
import br.com.loucademia.startUp.StartUp;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TextField;

public class ControleAcesso {

    @FXML
    private Button btnRegistrarEntrada, btnRegistrarSaida;

    @FXML
    private Label labelMatricula, labelCpf;

    @FXML
    private TextField txtMatricula, txtCpf;

    @FXML
    private TableColumn<Aluno, Integer> matriculaColumn;

    @FXML
    private TableColumn<Aluno, String> nomeColumn;
    
    @FXML
    private TableColumn<Acesso, LocalDateTime> entradaColumn;

    @FXML
    private TableColumn<Acesso, LocalDateTime> saidaColumn;
    

    @FXML
    void btnRegistrarEntradaAction(ActionEvent event) {
    	ControleAcessoServiceBean controleAcessoServiceBean = new ControleAcessoServiceBean();
    		    
		if (!StringUtils.isEmpty(txtMatricula.getText())) {
			controleAcessoServiceBean.setId(Integer.valueOf(txtMatricula.getText()));
		}
		
		if (!StringUtils.isEmpty(txtCpf.getText())) {
			controleAcessoServiceBean.setCpf(txtCpf.getText());
		}
    }

    @FXML
    void btnRegistrarSaidaAction(ActionEvent event) {
    	ControleAcessoServiceBean controleAcessoServiceBean = new ControleAcessoServiceBean();
	    
		if (!StringUtils.isEmpty(txtMatricula.getText())) {
			controleAcessoServiceBean.setId(Integer.valueOf(txtMatricula.getText()));
		}
		
		if (!StringUtils.isEmpty(txtCpf.getText())) {
			controleAcessoServiceBean.setCpf(txtCpf.getText());
		}
    }

    @FXML
    void btnVoltar(ActionEvent event) {
    	StartUp.changeScreen(NomeTelaEnum.MENU);
    }
}
