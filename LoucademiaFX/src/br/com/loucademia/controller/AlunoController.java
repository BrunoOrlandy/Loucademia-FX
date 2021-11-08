package br.com.loucademia.controller;

import br.com.loucademia.application.service.AlunoService;
import br.com.loucademia.application.serviceBean.AlunoServiceBean;
import br.com.loucademia.application.util.DataValidation;
import br.com.loucademia.domain.aluno.Aluno;
import br.com.loucademia.domain.aluno.SexoEnum;
import br.com.loucademia.domain.aluno.SituacaoEnum;
import br.com.loucademia.domain.tela.NomeTelaEnum;
import br.com.loucademia.startUp.StartUp;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;

public class AlunoController {

    private final static String ERROR_CSS = "-fx-border-color: red ; -fx-border-width: 1px;";

    @FXML
    private TextField nome, identidade, rua, numero, estado, cidade, complemento, cep, email, telefoneCelular;

    @FXML
    private RadioButton rbMasculino, rbFeminino, rbInativo, rbAtivo;

    @FXML
    private Label labelNome, labelIdentidade, labelRua, labelNumero, labelEstado, labelCidade, labelComplemento,
	    labelCep, labelEmail, labelTelefoneCelular;

    @FXML
    private DatePicker dataDeNascimento;

    private Aluno aluno = new Aluno();

    @FXML
    protected void btnVoltar(ActionEvent eventC) {
	StartUp.changeScreen(NomeTelaEnum.MENU);
    }

    @FXML
    protected void btnSalvarAction(ActionEvent eventC) {

	AlunoService service = new AlunoServiceBean();

	if (dataDeNascimento.getValue() == null) {
	    dataDeNascimento.setStyle(ERROR_CSS);
	} else {
	    System.out.println(dataDeNascimento.getValue());
	    dataDeNascimento.setStyle(null);
	}

	boolean alphabetName = DataValidation.isName(nome, labelNome, "Nome incorreto! Informe apenas letras");
	boolean identidadeValition = DataValidation.isIdentidade(identidade, labelIdentidade,
		"Letras não são permitidas");
	boolean ruaValidation = DataValidation.isRua(rua, labelRua, "Informe apenas letras");
	boolean numeroValidation = DataValidation.isNumero(numero, labelNumero, "Informe apenas números");
	boolean estadooValidation = DataValidation.isEstado(estado, labelEstado, "Apenas letras");
	boolean cidadeValidation = DataValidation.isCidade(cidade, labelCidade, "Informe apenas letras");
//	boolean emailValidation = DataValidation.emailFormat(email, labelEmail,
//		"E-mail incorreto! Deve conter 'seuemail@seudom�nio.com.br'");
	boolean numericPhNumber = DataValidation.isPhone(telefoneCelular, labelTelefoneCelular,
		"Informe números de 0 - 9");
	boolean cepValidation = DataValidation.isCep(cep, labelCidade, "Informe apenas números");

	if (alphabetName && identidadeValition && ruaValidation && numeroValidation && estadooValidation
		&& cidadeValidation && cidadeValidation && cepValidation
//		&& emailValidation 
		&& numericPhNumber) {

	    aluno.setNome(nome.getText());
	    aluno.setCpf(Integer.valueOf(identidade.getText()));
	    aluno.setDataNascimento(dataDeNascimento.getValue());
	    aluno.getEndereco().setRua(rua.getText());
	    aluno.getEndereco().setNumero(Integer.valueOf(numero.getText()));
	    aluno.getEndereco().setEstado(estado.getText());
	    aluno.getEndereco().setNumero(Integer.valueOf(numero.getText()));
	    aluno.getEndereco().setCidade(cidade.getText());
	    aluno.getEndereco().setCep(Integer.valueOf(cep.getText()));
	    aluno.getEndereco().setComplemento(complemento.getText());
	    aluno.setEmail(email.getText());
	    aluno.setTelefone(telefoneCelular.getText());

	    String msgOperacao = service.validarAlunoESalvar(aluno);

	    if (msgOperacao != null) {
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setContentText(msgOperacao);
		alert.show();
		limparCamposPreenchidos();
	    } else {
		Alert alert = new Alert(AlertType.WARNING);
		alert.setContentText("Aluno informado já existe");
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
	estado.clear();
	cidade.clear();
	complemento.clear();
	cep.clear();
	email.clear();
	telefoneCelular.clear();
	dataDeNascimento.getEditor().clear();
    }

}
