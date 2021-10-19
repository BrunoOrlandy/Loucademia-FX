package br.com.loucademia.controller;

import br.com.loucademia.application.util.DataValidation;
import br.com.loucademia.interfaces.aluno.AlunoBean;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class AlunoController {	
	
	@FXML
    private TextField cep;

    @FXML
    private TextField cidade;

    @FXML
    private TextField complemento;

    @FXML
    private DatePicker dataDeNascimento;

    @FXML
    private TextField email;

    @FXML
    private TextField estado;

    @FXML
    private Label labelCelular;

    @FXML
    private Label labelCep;

    @FXML
    private Label labelCidade;

    @FXML
    private Label labelComplemento;

    @FXML
    private Label labelEmail;

    @FXML
    private Label labelEstado;

    @FXML
    private Label labelIdentidade;

    @FXML
    private Label labelNome;

    @FXML
    private Label labelNumero;

    @FXML
    private Label labelRua;
    
    @FXML
    private Label labelTelefoneCelular;

    @FXML
    private TextField nome;

    @FXML
    private TextField numero;

    @FXML
    private TextField identidade;

    @FXML
    private TextField rua;

    @FXML
    private TextField telefoneCelular;

    
    private AlunoBean alunoBean;

    
    
//    Label lblNome = new Label("Nome");
//    TextField tfNome = new TextField();
//        
//    Label lblContract = new Label("Contract");
//    TextField tfContract = new TextField(); 
	
	@FXML
	protected void btnVoltar(ActionEvent eventC) {
		System.out.println("Voltar");
		Platform.exit();
	}

	@FXML
	protected void btnSalvarAction(ActionEvent eventC) {
		
    	
    	// Data de nascimento
    	if(dataDeNascimento.getValue() == null)
    	{	
    		dataDeNascimento.setStyle("-fx-border-color: red ; -fx-border-width: 1px;");
    	} else {
    		nome.setStyle(null);
    	}    	
    	    	
    	// Nome da rua
    	if(rua.getText().length() == 0)
    	{	
    		rua.setStyle("-fx-border-color: red ; -fx-border-width: 1px;");
    	} else {
    		nome.setStyle(null);
    	}
    	
    	// Número da residência
    	if(numero.getText().length() == 0)
    	{	
    		numero.setStyle("-fx-border-color: red ; -fx-border-width: 1px;");
    	} else {
    		nome.setStyle(null);
    	}
    	
    	// Estado
    	if(estado.getText().length() == 0)
    	{	
    		estado.setStyle("-fx-border-color: red ; -fx-border-width: 1px;");
    	} else {
    		nome.setStyle(null);
    	}
    	
    	// Complemento
    	if(complemento.getText().length() == 0)
    	{	
    		complemento.setStyle("-fx-border-color: red ; -fx-border-width: 1px;");
    	} else {
    		nome.setStyle(null);
    	}
    	
    	boolean alphabetName = DataValidation.isName(nome, labelNome, "Nome incorreto! Informe apenas letras");
        boolean identidadeValition = DataValidation.isIdentidade(identidade, labelIdentidade, "Letras não são permitidas");
        boolean ruaValidation = DataValidation.isRua(rua, labelRua, "Informe apenas letras");
        boolean cidadeValidation = DataValidation.isCidade(cidade, labelCidade, "Informe apenas letras");
        boolean emailValidation = DataValidation.emailFormat(email, labelEmail, "E-mail incorreto! Deve conter 'seuemail@seudomínio.com.br'");
        boolean numericPhNumber = DataValidation.isPhone(telefoneCelular, labelTelefoneCelular, "Informe números de 0 - 9");


        
        System.out.println("GRAVANDO DADOS!");
        
    	// Chama o método gravar() na classe AlunoBean
    	//alunoBean.gravar();
        
	}
}
