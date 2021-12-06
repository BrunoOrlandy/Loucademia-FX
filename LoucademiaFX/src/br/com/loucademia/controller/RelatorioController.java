package br.com.loucademia.controller;

import java.time.LocalDateTime;
import java.util.List;

import br.com.loucademia.application.serviceBean.AlunoServiceBean;
import br.com.loucademia.application.serviceBean.PesquisaAlunoServiceBean;
import br.com.loucademia.application.serviceBean.RelatorioEntradaSaidaBean;
import br.com.loucademia.application.util.DataValidation;
import br.com.loucademia.application.util.StringUtils;
import br.com.loucademia.domain.aluno.Acesso;
import br.com.loucademia.domain.aluno.Aluno;
import br.com.loucademia.domain.tela.NomeTelaEnum;
import br.com.loucademia.initApp.App;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.ScrollEvent;

public class RelatorioController extends BaseController {

    @FXML
    private Button btnPesquisar;

    @FXML
    private Label labelMatricula, labelDataInicial, labelDataFinal;

    @FXML
    private DatePicker txtDataInicial, txtDataFinal;

    @FXML
    private TextField txtMatricula;

    @FXML
    private TableColumn<Aluno, Integer> matriculaColumn;

    @FXML
    private TableColumn<Aluno, String> nomeColumn;

    @FXML
    private TableColumn<Acesso, LocalDateTime> dataEntradaColumn, dataSaidaColumn;

    @FXML
    private TableColumn<Acesso, String> duracaoColumn;

    @FXML
    private TableView<Aluno> tabela;

    private List<Acesso> acessos;

    @FXML
    void btnPesquisarAction(ActionEvent event) {

	Aluno alunoPesquisa = new Aluno();
	PesquisaAlunoServiceBean serviceBean = new PesquisaAlunoServiceBean();
	AlunoServiceBean alunoServiceBean = new AlunoServiceBean();
	RelatorioEntradaSaidaBean relatorioEntradaSaidaBean = new RelatorioEntradaSaidaBean();

	validarCamposPrenchidosCorretamente();

	if (!StringUtils.isEmpty(txtMatricula.getText())) {
	    alunoPesquisa.setId(Integer.valueOf(txtMatricula.getText()));
	}

	if (txtDataInicial.getValue() != null) {
	    relatorioEntradaSaidaBean.setDataInicial(txtDataInicial.getValue());
	}

	if (txtDataFinal.getValue() != null) {
	    relatorioEntradaSaidaBean.setDataFinal(txtDataFinal.getValue());
	}

	// aluno
	matriculaColumn.setCellValueFactory(new PropertyValueFactory<>("id"));
	nomeColumn.setCellValueFactory(new PropertyValueFactory<>("nome"));
	dataEntradaColumn.setCellValueFactory(new PropertyValueFactory<>("dataInicial"));
	dataSaidaColumn.setCellValueFactory(new PropertyValueFactory<>("dataFinal"));
	duracaoColumn.setCellValueFactory(new PropertyValueFactory<>("duracao"));

	List<Aluno> alunosEncontrado = serviceBean.buscarAluno(alunoPesquisa);
	List<Acesso> listAcessosAlunos = relatorioEntradaSaidaBean.getAcessos();

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
	tabela.scrollTo(alunoPesquisa);
	tabela.addEventFilter(ScrollEvent.SCROLL, new EventHandler<ScrollEvent>() {
	    @Override
	    public void handle(ScrollEvent scrollEvent) {
		tabela.getAccessibleText();
	    }
	});

    }

    private ObservableList<Aluno> listaDeAlunos(List<Aluno> alunosList) {
	return FXCollections.observableList(alunosList);
    }

    @FXML
    void btnVoltar(ActionEvent event) {
	getApp().changeScreen(NomeTelaEnum.MENU);
	limparCampos();
	tabela.getItems().clear();
    }

    private void limparCampos() {
	txtMatricula.clear();
	txtDataInicial.getEditor().clear();
	txtDataFinal.getEditor().clear();
    }

    private void validarCamposPrenchidosCorretamente() {
	boolean isValidTelefone, isValidMatricula, isValidCPF, isNomeValido = false;

	if (!StringUtils.isEmpty(txtMatricula.getText())) {
	    isValidMatricula = DataValidation.isIntegerValid(txtMatricula, labelMatricula, "Informe apenas Numeros",
		    "Matricula");
	}
    }

    public void onSelectItemDataTable(Aluno aluno) {
	System.err.println(aluno.getNome());
    }
}
