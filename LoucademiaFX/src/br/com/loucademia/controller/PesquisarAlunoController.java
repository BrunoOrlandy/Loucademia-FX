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
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.util.converter.IntegerStringConverter;

public class PesquisarAlunoController {

    @FXML
    private TextField txtMatricula, txtNome, txtTelefone, txtCPF;

    @FXML
    private Label labelMatricula, labelNome, labelTelefone, labelCPF;

    @FXML
    private TableColumn<Aluno, Integer> matriculaColumn;
    @FXML
    private TableColumn<Aluno, String> nomeColumn;
    @FXML
    private TableColumn<Aluno, String> cpfColumn;
    @FXML
    private TableColumn<Aluno, String> ruaColumn;
    @FXML
    private TableColumn<Aluno, String> telefoneColumn;
    @FXML
    private TableColumn<Aluno, Integer> numeroColumn;
    @FXML
    private TableColumn<Aluno, String> complementoColumn;
    @FXML
    private TableColumn<Aluno, String> cidadeColumn;
    @FXML
    private TableColumn<Aluno, String> estadoColumn;
    @FXML
    private TableColumn<Aluno, Integer> cepColumn;

    @FXML
    private TableView<Aluno> tabela;

    @FXML
    void btnPesquisar(ActionEvent event) {

	Aluno alunoPesquisa = new Aluno();
	PesquisaAlunoServiceBean serviceBean = new PesquisaAlunoServiceBean();

	validarCamposPrenchidosCorretamente();

	if (!StringUtils.isEmpty(txtMatricula.getText())) {
	    alunoPesquisa.setId(Integer.valueOf(txtMatricula.getText()));
	}

	if (!StringUtils.isEmpty(txtNome.getText())) {
	    alunoPesquisa.setNome(txtNome.getText());
	}

	if (!StringUtils.isEmpty(txtTelefone.getText())) {
	    alunoPesquisa.setTelefone(txtTelefone.getText());
	}

	if (!StringUtils.isEmpty(txtCPF.getText())) {
	    alunoPesquisa.setCpf(txtCPF.getText());
	}

	matriculaColumn.setCellValueFactory(new PropertyValueFactory<>("id"));
	nomeColumn.setCellValueFactory(new PropertyValueFactory<>("nome"));
	cpfColumn.setCellValueFactory(new PropertyValueFactory<>("cpf"));
	telefoneColumn.setCellValueFactory(new PropertyValueFactory<>("telefone"));

	nomeColumn.setCellFactory(TextFieldTableCell.forTableColumn());
//	cpfColumn.setCellFactory(TextFieldTableCell.forTableColumn(new IntegerStringConverter()));
	telefoneColumn.setCellFactory(TextFieldTableCell.forTableColumn());
	cpfColumn.setCellFactory(TextFieldTableCell.forTableColumn());
//	nomeColumn.setCellFactory(TextFieldTableCell.forTableColumn());
//	nomeColumn.setCellFactory(TextFieldTableCell.forTableColumn());

	List<Aluno> alunosEncontrado = serviceBean.buscarAluno(alunoPesquisa);
	if (!alunosEncontrado.isEmpty()) {
	    tabela.setItems(listaDeAlunos(alunosEncontrado));
	} else {
	    Alert alert = new Alert(AlertType.INFORMATION);
	    alert.setContentText("Não foram encotrados alunos partir dos dados informados");
	    alert.show();
	    limparCampos();
	}

	tabela.getSelectionModel().selectedItemProperty()
		.addListener((observable, oldValue, newValue) -> onSelectItemDataTable(newValue));

    }

    private void validarCamposPrenchidosCorretamente() {
	boolean isValidTelefone, isValidMatricula, isValidCPF, isNomeValido = false;

	if (!StringUtils.isEmpty(txtMatricula.getText())) {
	    isValidMatricula = DataValidation.isIntegerValid(txtMatricula, labelMatricula, "Informe apenas Numeros",
		    "Matricula");
	}

	if (!StringUtils.isEmpty(txtNome.getText())) {
	    isNomeValido = DataValidation.isStringValid(txtNome, labelNome, " Informe apenas letras", "Nome");
	}

	if (!StringUtils.isEmpty(txtTelefone.getText())) {
	    isValidTelefone = DataValidation.isTelefone(txtTelefone, labelTelefone, "Informe apenas Numeros");
	}

	if (!StringUtils.isEmpty(txtCPF.getText())) {
	    isValidCPF = DataValidation.isCPF(txtCPF, labelCPF, "Informe apenas números");
	}
    }

    @FXML
    void btnVoltar(ActionEvent event) {
    	StartUp.changeScreen(NomeTelaEnum.MENU);
    }

    @FXML
    void btnLimpar(ActionEvent event) {
    	limparCampos();
    }

    public void onSelectItemDataTable(Aluno aluno) {
    	System.err.println(aluno.getNome());

    }

    private ObservableList<Aluno> listaDeAlunos(List<Aluno> alunosList) {
    	return FXCollections.observableList(alunosList);
    }

    private void limparCampos() {
		txtMatricula.clear();
		txtNome.clear();
		txtTelefone.clear();
		txtCPF.clear();
		tabela.getItems().clear();
    }

}
