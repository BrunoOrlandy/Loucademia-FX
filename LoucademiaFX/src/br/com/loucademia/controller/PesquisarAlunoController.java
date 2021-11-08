package br.com.loucademia.controller;

import br.com.loucademia.application.serviceBean.PesquisaAlunoServiceBean;
import br.com.loucademia.application.util.DataValidation;
import br.com.loucademia.domain.aluno.Aluno;
import br.com.loucademia.domain.tela.NomeTelaEnum;
import br.com.loucademia.startUp.StartUp;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class PesquisarAlunoController {

    private PesquisaAlunoServiceBean pesquisaService;

    @FXML
    private TextField txtMatricula, txtNome, txtTelefone, txtRG;

    @FXML
    private Label labelMatricula, labelNome, labelTelefone, labelRg;

    @FXML
    void btnPesquisar(ActionEvent event) {

//	boolean isValidNome = DataValidation.isName(txtNome, labelNome, "Nome incorreto! Informe apenas letras");
//	boolean isValidTelefone = DataValidation.isTelefone(txtTelefone, labelTelefone,
//		"Telefone incorreto! Informe apenas Numeros");
//	boolean isValidMatricula = DataValidation.isRg(txtRG, labelRg, "Rg incorreto! Informe apenas Numeros");

	if (txtRG.getText() != null) {
	    boolean isValidRG = DataValidation.isIdentidade(txtRG, labelRg, "Rg incorreto! Informe apenas números");
	}

	if (txtMatricula.getText() != null || txtNome.getText() != null || txtTelefone.getText() != null
		|| txtRG.getText() != null) {
//
	    Aluno alunoPesquisa = new Aluno();
	    alunoPesquisa.setNome(txtNome.getText());
	    alunoPesquisa.setCpf(Integer.valueOf(txtRG.getText()));
	    alunoPesquisa.setTelefone(txtTelefone.getText());

	    System.err.println(alunoPesquisa.getNome());
	    System.err.println(alunoPesquisa.getCpf());
	    System.err.println(alunoPesquisa.getTelefone());

	    pesquisaService.buscarAluno(alunoPesquisa);

	}
    }

    @FXML
    void btnVoltar(ActionEvent event) {
	StartUp.changeScreen(NomeTelaEnum.MENU);
    }

}
