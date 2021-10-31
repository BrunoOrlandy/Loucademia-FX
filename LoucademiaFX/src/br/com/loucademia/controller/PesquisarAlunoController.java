package br.com.loucademia.controller;

import br.com.loucademia.application.util.DataValidation;
import br.com.loucademia.domain.aluno.Aluno;
import br.com.loucademia.domain.tela.NomeTelaEnum;
import br.com.loucademia.startUp.StartUp;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class PesquisarAlunoController {

    @FXML
    private TextField txtMatricula, txtNome, txtTelefone, txtRG;

    @FXML
    private Label labelMatricula, labelNome, labelTelefone, labelRg;

    @FXML
    void btnPesquisar(ActionEvent event) {

	// PesquisaService pesquisaService = new PesquisaService()

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
	    Aluno alunoPesquisar = new Aluno();
	    alunoPesquisar.setMatricula(txtMatricula.getText());
	    alunoPesquisar.setNome(txtNome.getText());
	    alunoPesquisar.setRg(Integer.valueOf(txtRG.getText()));
	    alunoPesquisar.setTelefone(txtTelefone.getText());

	    System.err.println(alunoPesquisar.getMatricula());
	    System.err.println(alunoPesquisar.getNome());
	    System.err.println(alunoPesquisar.getRg());
	    System.err.println(alunoPesquisar.getTelefone());

//	    // pesquisaService.buscarAlunos(alunoPesquisar);
	}
    }

    @FXML
    void btnVoltar(ActionEvent event) {
	StartUp.changeScreen(NomeTelaEnum.MENU);
    }

}
