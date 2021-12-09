package br.com.loucademia.controller;

import java.util.ArrayList;
import java.util.List;

import br.com.loucademia.initApp.App;
import br.com.loucademia.model.model.Aluno;
import br.com.loucademia.model.model.enums.NomeTelaEnum;
import br.com.loucademia.model.model.valueObject.AlunoEstadoVo;
import br.com.loucademia.model.serviceBean.PesquisaAlunoServiceBean;
import br.com.loucademia.model.util.DataValidation;
import br.com.loucademia.model.util.StringUtils;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.input.ScrollEvent;
import javafx.util.converter.IntegerStringConverter;

public class PesquisarAlunoController extends BaseController {

    private AlunoEstadoVo alunoEstadoVo;
    private AlunoEstadoVo alunoEstadoVoSelecionado;

    @FXML
    private TextField txtMatricula, txtNome, txtTelefone, txtCPF;

    @FXML
    private Label labelMatricula, labelNome, labelTelefone, labelCPF;

    @FXML
    private TableColumn<AlunoEstadoVo, Integer> matriculaColumn;
    @FXML
    private TableColumn<AlunoEstadoVo, String> nomeColumn;
    @FXML
    private TableColumn<AlunoEstadoVo, String> ruaColumn;
    @FXML
    private TableColumn<AlunoEstadoVo, String> telefoneColumn;
    @FXML
    private TableColumn<AlunoEstadoVo, Integer> numeroColumn;
    @FXML
    private TableColumn<AlunoEstadoVo, String> complementoColumn;
    @FXML
    private TableColumn<AlunoEstadoVo, String> cidadeColumn;
    @FXML
    private TableColumn<AlunoEstadoVo, String> estadoColumn;
    @FXML
    private TableColumn<AlunoEstadoVo, Integer> cepColumn;
    @FXML
    private TableView<AlunoEstadoVo> tabela;

    private ObservableList obsList;

    @FXML
    private ScrollPane scrollPane = new ScrollPane();

    @FXML
    void btnPesquisar(ActionEvent event) {

	Aluno alunoPesquisa = new Aluno();
	alunoEstadoVo = new AlunoEstadoVo();
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

	buildDataViewCellValue();
//	buildDataViewCellFactory();

	List<Aluno> alunosEncontrado = serviceBean.buscarAluno(alunoPesquisa);
	if (!alunosEncontrado.isEmpty()) {
	    this.setObsList(listaDeAlunos(alunosEncontrado));
	    tabela.setItems(this.getObsList());
	} else {
	    Alert alert = new Alert(AlertType.INFORMATION);
	    alert.setContentText("Não foram encotrados alunos partir dos dados informados");
	    alert.show();
	    limparCampos();
	}

	tabela.getSelectionModel().selectedItemProperty()
		.addListener((observable, oldValue, newValue) -> onSelectItemDataTable(newValue));

	tabela.scrollTo(alunoEstadoVo);
	tabela.addEventFilter(ScrollEvent.SCROLL, new EventHandler<ScrollEvent>() {
	    @Override
	    public void handle(ScrollEvent scrollEvent) {
		tabela.getAccessibleText();
	    }
	});
    }

    private void buildDataViewCellFactory() {
	nomeColumn.setCellFactory(TextFieldTableCell.forTableColumn());
	telefoneColumn.setCellFactory(TextFieldTableCell.forTableColumn());
	ruaColumn.setCellFactory(TextFieldTableCell.forTableColumn());
	numeroColumn.setCellFactory(TextFieldTableCell.forTableColumn(new IntegerStringConverter()));
	cepColumn.setCellFactory(TextFieldTableCell.forTableColumn(new IntegerStringConverter()));
	cidadeColumn.setCellFactory(TextFieldTableCell.forTableColumn());
	estadoColumn.setCellFactory(TextFieldTableCell.forTableColumn());
	complementoColumn.setCellFactory(TextFieldTableCell.forTableColumn());
    }

    private void buildDataViewCellValue() {
	matriculaColumn.setCellValueFactory(new PropertyValueFactory<>("id"));
	nomeColumn.setCellValueFactory(new PropertyValueFactory<>("Nome"));
	telefoneColumn.setCellValueFactory(new PropertyValueFactory<>("Telefone"));
	ruaColumn.setCellValueFactory(new PropertyValueFactory<>("Rua"));
	numeroColumn.setCellValueFactory(new PropertyValueFactory<>("Numero"));
	cepColumn.setCellValueFactory(new PropertyValueFactory<>("cep"));
	cidadeColumn.setCellValueFactory(new PropertyValueFactory<>("Cidade"));
	estadoColumn.setCellValueFactory(new PropertyValueFactory<>("Estado"));
	complementoColumn.setCellValueFactory(new PropertyValueFactory<>("Complemento"));
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
	App.changeScreen(NomeTelaEnum.MENU);
	limparCampos();
    }

    @FXML
    void btnEditar(ActionEvent event) {
	if (getAlunoEstadoVoSelecionado() != null) {
	    getApp().getAlunoController().editAluno(getAlunoEstadoVoSelecionado());
	    getObsList().clear();
	} else {
	    Alert alert = new Alert(AlertType.INFORMATION);
	    alert.setContentText("Não foi selecionado nenhum aluno para realizar a edição");
	    alert.show();
	}
    }

    @FXML
    void btnLimpar(ActionEvent event) {
	limparCampos();
    }

    public void onSelectItemDataTable(AlunoEstadoVo alunoEstadoVo) {
	setAlunoEstadoVoSelecionado(alunoEstadoVo);
    }

    private ObservableList<AlunoEstadoVo> listaDeAlunos(List<Aluno> alunosList) {

	List<AlunoEstadoVo> alunosVoList = new ArrayList<AlunoEstadoVo>();
	for (Aluno aluno : alunosList) {
	    AlunoEstadoVo vo = new AlunoEstadoVo();
	    vo.setId(aluno.getId());
	    vo.setNome(aluno.getNome());
	    vo.setDataNascimento(aluno.getDataNascimento().toString());
	    vo.setSituacao(aluno.getSituacao());
	    vo.setSexo(aluno.getSexo());
	    vo.setTelefone(aluno.getTelefone());
	    vo.setCpf(aluno.getCpf());
	    vo.setEmail(aluno.getEmail());

	    vo.setRua(aluno.getEndereco().getRua());
	    vo.setNumero(aluno.getEndereco().getNumero());
	    vo.setComplemento(aluno.getEndereco().getComplemento());
	    vo.setCidade(aluno.getEndereco().getCidade());
	    vo.setEstado(aluno.getEndereco().getEstado());
	    vo.setCep(aluno.getEndereco().getCep());
	    alunosVoList.add(vo);
	}
	return FXCollections.observableList(alunosVoList);

    }

    private void limparCampos() {
	txtMatricula.clear();
	txtNome.clear();
	txtTelefone.clear();
	txtCPF.clear();
	if (getObsList() != null) {
	    getObsList().clear();
	    tabela.getItems().clear();
	}

    }

    public AlunoEstadoVo getAlunoEstadoVoSelecionado() {
	return alunoEstadoVoSelecionado;
    }

    public void setAlunoEstadoVoSelecionado(AlunoEstadoVo alunoEstadoVoSelecionado) {
	this.alunoEstadoVoSelecionado = alunoEstadoVoSelecionado;
    }

    public ObservableList getObsList() {
	return obsList;
    }

    public void setObsList(ObservableList obsList) {
	this.obsList = obsList;
    }

}
