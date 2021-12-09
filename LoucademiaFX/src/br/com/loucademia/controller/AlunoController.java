package br.com.loucademia.controller;

import java.net.URL;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ResourceBundle;

import br.com.loucademia.initApp.App;
import br.com.loucademia.model.model.Aluno;
import br.com.loucademia.model.model.enums.EstadoEnum;
import br.com.loucademia.model.model.enums.NomeTelaEnum;
import br.com.loucademia.model.model.enums.SexoEnum;
import br.com.loucademia.model.model.enums.SituacaoEnum;
import br.com.loucademia.model.model.valueObject.AlunoEstadoVo;
import br.com.loucademia.model.service.AlunoService;
import br.com.loucademia.model.serviceBean.AlunoServiceBean;
import br.com.loucademia.model.util.DataValidation;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;

public class AlunoController extends BaseController {

    private final static String ERROR_CSS = "-fx-border-color: red ; -fx-border-width: 1px;";

    private Aluno aluno = new Aluno();

    @FXML
    private TextField nome, identidade, rua, numero, cidade, complemento, cep, email, telefoneCelular;

    @FXML
    private RadioButton rbMasculino, rbFeminino, rbInativo, rbAtivo;

    @FXML
    private Label labelNome, labelIdentidade, labelRua, labelNumero, labelEstado, labelCidade, labelComplemento,
	    labelCep, labelEmail, labelTelefoneCelular;

    @FXML
    private ChoiceBox<String> choiseEstado;

    @FXML
    private DatePicker dataDeNascimento;

    @FXML
    protected void btnVoltar(ActionEvent eventC) {
	limparCamposPreenchidos();
	App.changeScreen(NomeTelaEnum.MENU);
    }

    @FXML
    protected void btnSalvarAction(ActionEvent eventC) {

	AlunoService service = new AlunoServiceBean();

	if (dataDeNascimento.getValue() == null) {
	    dataDeNascimento.setStyle(ERROR_CSS);
	} else {
	    System.out.println(dataDeNascimento.getValue().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));
	    dataDeNascimento.setStyle(null);
	}

	if (isCamposPreenchidosCorretamente()) {

	    aluno.setNome(nome.getText());
	    aluno.setCpf(identidade.getText());
	    aluno.setDataNascimento(dataDeNascimento.getValue());
	    aluno.setSexo(rbMasculino.getText());
	    aluno.setSituacao(rbInativo.getText());
	    aluno.setEmail(email.getText());
	    aluno.setTelefone(telefoneCelular.getText());
	    aluno.getEndereco().setRua(rua.getText());
	    aluno.getEndereco().setNumero(Integer.valueOf(numero.getText()));
	    aluno.getEndereco().setEstado(choiseEstado.getValue());
	    aluno.getEndereco().setNumero(Integer.valueOf(numero.getText()));
	    aluno.getEndereco().setCidade(cidade.getText());
	    aluno.getEndereco().setCep(Integer.valueOf(cep.getText()));
	    aluno.getEndereco().setComplemento(complemento.getText());

	    String msg = service.validarAlunoESalvar(aluno);

	    if (msg != null) {
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setContentText(msg);
		alert.show();
	    } else {
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setContentText("Aluno " + aluno.getNome() + " savlo com sucesso");
		alert.show();
	    }
	}
    }

    public void getSexo(ActionEvent e) {
	if (rbMasculino.isSelected()) {
	    aluno.setSexo(SexoEnum.MASCULINO.getId());
	} else if (rbFeminino.isSelected()) {
	    aluno.setSexo(SexoEnum.FEMININO.getId());
	}
    }

    public void getSituacao(ActionEvent e) {
	if (rbAtivo.isSelected()) {
	    aluno.setSituacao(SituacaoEnum.ATIVO.getId());
	} else if (rbInativo.isSelected()) {
	    aluno.setSituacao(SituacaoEnum.INATIVO.getId());
	}

    }

    public void limparCamposPreenchidos() {
	nome.clear();
	identidade.clear();
	rua.clear();
	numero.clear();
	choiseEstado.setValue(null);
	cidade.clear();
	complemento.clear();
	cep.clear();
	email.clear();
	telefoneCelular.clear();
	dataDeNascimento.getEditor().clear();
	AlunoController a = new AlunoController();
    }

    private ObservableList<String> listaEstadoEnums() {
	return FXCollections.observableList(EstadoEnum.getSiglasEstados());
    }

    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
	choiseEstado.getItems().addAll(listaEstadoEnums());
	choiseEstado.setOnAction(this::getEstado);
	getSexo(null);
	getSituacao(null);

    }

    public void getEstado(ActionEvent e) {
	String sigla = choiseEstado.getValue();
	aluno.getEndereco().setEstado(sigla);
    }

    public boolean isCamposPreenchidosCorretamente() {

	boolean alphabetName = DataValidation.isName(nome, labelNome, "Nome incorreto! Informe apenas letras");
	boolean identidadeValition = DataValidation.isIdentidade(identidade, labelIdentidade,
		"Letras não são permitidas");
	boolean ruaValidation = DataValidation.isRua(rua, labelRua, "Informe apenas letras");
	boolean numeroValidation = DataValidation.isNumero(numero, labelNumero, "Informe apenas números");
	boolean estadoValidation = DataValidation.isEstado(choiseEstado, labelEstado, "Não deve ser vazio");
	boolean cidadeValidation = DataValidation.isCidade(cidade, labelCidade, "Informe apenas letras");
	boolean emailValidation = DataValidation.emailFormat(email, labelEmail,
		"E-mail incorreto! Deve conter 'seuemail@dominio.com.br'");
	boolean numericPhNumber = DataValidation.isPhone(telefoneCelular, labelTelefoneCelular,
		"Informe números de 0 - 9");
	boolean cepValidation = DataValidation.isCep(cep, labelCidade, "Informe apenas números");

	boolean dataNascimento = dataDeNascimento.getValue() != null;

	return alphabetName && identidadeValition && ruaValidation && numeroValidation && cidadeValidation
		&& cidadeValidation && cepValidation && estadoValidation && emailValidation && numericPhNumber;
    }

//	LocalDate s = dataDeNascimento.getValue();
//	s.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
//	dataDeNascimento.setValue(s);

    public void editAluno(AlunoEstadoVo alunoEstadoVo) {
	preencherCamposDaTela(alunoEstadoVo);
	getApp().changeScreen(NomeTelaEnum.NOVO_ALUNO);
    }

    private void preencherCamposDaTela(AlunoEstadoVo alunoEstadoVo) {

	nome.setText(alunoEstadoVo.getNome());
	identidade.setText(alunoEstadoVo.getCpf());
	if (alunoEstadoVo.getSexo().equals(SexoEnum.MASCULINO.getName())) {
	    rbMasculino.isSelected();
	} else {
	    rbFeminino.isSelected();
	}
	if (alunoEstadoVo.getSituacao().equals(SituacaoEnum.ATIVO.getNome())) {
	    rbAtivo.isSelected();
	} else {
	    rbInativo.isSelected();
	}
	email.setText(alunoEstadoVo.getEmail());
	telefoneCelular.setText(alunoEstadoVo.getTelefone());
	rua.setText(alunoEstadoVo.getRua());
	numero.setText(alunoEstadoVo.getNumero().toString());
	cidade.setText(alunoEstadoVo.getCidade());
	complemento.setText(alunoEstadoVo.getComplemento());
	cep.setText(alunoEstadoVo.getCep().toString());
	email.setText(alunoEstadoVo.getEmail());
	choiseEstado.setValue(alunoEstadoVo.getEstado());
	dataDeNascimento.setValue(LocalDate.parse(alunoEstadoVo.getDataNascimento()));
	dataDeNascimento.getValue().format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));

	aluno.setId(alunoEstadoVo.getId());
	aluno.getEndereco().setId(alunoEstadoVo.getId());
    }

}
