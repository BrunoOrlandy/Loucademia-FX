package br.com.loucademia.controller;

import java.util.List;

import br.com.loucademia.application.serviceBean.PesquisaAlunoServiceBean;
import br.com.loucademia.application.util.DataValidation;
import br.com.loucademia.application.util.StringUtils;
import br.com.loucademia.domain.aluno.Aluno;
import br.com.loucademia.domain.tela.NomeTelaEnum;
import br.com.loucademia.startUp.StartUp;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;

public class PesquisarAlunoController {

    @FXML
    private TextField txtMatricula, txtNome, txtTelefone, txtRG;

    @FXML
    private Label labelMatricula, labelNome, labelTelefone, labelRg;

    @FXML
    private TableColumn<Aluno, Integer> matriculaColumn;
    @FXML
    private TableColumn<Aluno, String> nomeColumn;
    @FXML
    private TableColumn<Aluno, Integer> cpfColumn;
    @FXML
    private TableColumn<Aluno, String> telefoneColumn;

    @FXML
    private TableView<Aluno> tabela;

    @FXML
    void btnPesquisar(ActionEvent event) {

	Aluno alunoPesquisa = new Aluno();
	PesquisaAlunoServiceBean serviceBean = new PesquisaAlunoServiceBean();

//	boolean isValidNome = DataValidation.isName(txtNome, labelNome, "Nome incorreto! Informe apenas letras");
//	boolean isValidTelefone = DataValidation.isTelefone(txtTelefone, labelTelefone,
//		"Telefone incorreto! Informe apenas Numeros");
//	boolean isValidMatricula = DataValidation.isRg(txtRG, labelRg, "Rg incorreto! Informe apenas Numeros");

//	if (StringUtils.isEmpty(txtRG.getText())) {
//	    boolean isValidRG = DataValidation.isIdentidade(txtRG, labelRg, "Rg incorreto! Informe apenas números");
//	}

	if (!StringUtils.isEmpty(txtMatricula.getText())) {
	    alunoPesquisa.setId(Integer.valueOf(txtMatricula.getText()));
	}

	if (!StringUtils.isEmpty(txtNome.getText())) {
	    alunoPesquisa.setNome(txtNome.getText());
	}

	if (!StringUtils.isEmpty(txtTelefone.getText())) {
	    alunoPesquisa.setTelefone(txtTelefone.getText());
	}

	if (!StringUtils.isEmpty(txtRG.getText())) {
	    alunoPesquisa.setCpf(Integer.valueOf(txtRG.getText()));
	}

	matriculaColumn.setCellValueFactory(new PropertyValueFactory<>("id"));
	nomeColumn.setCellValueFactory(new PropertyValueFactory<>("nome"));
	cpfColumn.setCellValueFactory(new PropertyValueFactory<>("cpf"));
	telefoneColumn.setCellValueFactory(new PropertyValueFactory<>("telefone"));

	List<Aluno> alunosEncontrado = serviceBean.buscarAluno(alunoPesquisa);
	if (!alunosEncontrado.isEmpty()) {
	    tabela.setItems(listaDeAlunos(alunosEncontrado));
	} else {
	    Alert alert = new Alert(AlertType.INFORMATION);
	    alert.setContentText("Não foram encotrados alunos partir dos dados informados");
	    alert.show();
	}

	tabela.getSelectionModel().selectedItemProperty()
		.addListener((observable, oldValue, newValue) -> onSelectItemDataTable(newValue));

    }

    private ObservableList<Aluno> listaDeAlunos(List<Aluno> alunosList) {
	return FXCollections.observableList(alunosList);
    }

    @FXML
    void btnVoltar(ActionEvent event) {
	StartUp.changeScreen(NomeTelaEnum.MENU);
    }

    public void onSelectItemDataTable(Aluno aluno) {
	System.err.println(aluno.getNome());
    }

    @FXML
    void btnEditar(ActionEvent event) {
	Aluno aluno = tabela.getSelectionModel().getSelectedItem();
	//chamar Edição
    }

}
