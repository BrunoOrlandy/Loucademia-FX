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
    private TextField nome, identidade, rua, numero, estado, cidade, complemento, cep, email, telefoneCelular;


    @FXML
    private DatePicker dataDeNascimento;

    @FXML
    private Label labelNome, labelIdentidade, labelRua, labelNumero, labelEstado, labelCidade,
    				labelComplemento, labelCep, labelEmail, labelTelefoneCelular;
    
    private AlunoBean alunoBean;

	
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
    		System.out.println(dataDeNascimento.getValue());
    		dataDeNascimento.setStyle(null);
    	}
    	
    	boolean alphabetName = DataValidation.isName(nome, labelNome, "Nome incorreto! Informe apenas letras");
        boolean identidadeValition = DataValidation.isIdentidade(identidade, labelIdentidade, "Letras não são permitidas");
        boolean ruaValidation = DataValidation.isRua(rua, labelRua, "Informe apenas letras");
        boolean numeroValidation = DataValidation.isNumero(numero, labelNumero, "Informe apenas números");
        boolean estadooValidation = DataValidation.isEstado(estado, labelEstado, "Apenas letras");
        boolean cidadeValidation = DataValidation.isCidade(cidade, labelCidade, "Informe apenas letras");
        boolean emailValidation = DataValidation.emailFormat(email, labelEmail, "E-mail incorreto! Deve conter 'seuemail@seudomínio.com.br'");
        boolean numericPhNumber = DataValidation.isPhone(telefoneCelular, labelTelefoneCelular, "Informe números de 0 - 9");
      
        
        if(alphabetName && identidadeValition && ruaValidation
        		&& numeroValidation && estadooValidation && cidadeValidation
        		&& cidadeValidation && emailValidation && numericPhNumber) {
        	
        	System.out.println("GRAVANDO DADOS!");
        	
        	// Chama o método gravar() na classe AlunoBean
        	// alunoBean.gravar();
        	
        }
	}
}
