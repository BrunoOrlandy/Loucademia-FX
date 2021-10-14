package br.com.loucademia.controller;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class AlunoController {	
	
    @FXML
    private TextField nome;
    
    @FXML
    private DatePicker dataDeNascimento;
    
    @FXML
    private TextField rg;

    @FXML
    private TextField rua;
    
    @FXML
    private TextField numero;
    
    @FXML
    private TextField estado;
    
    @FXML
    private TextField cidade;
    
    @FXML
    private TextField complemento;
    
	@FXML
    private TextField cep;
	
    @FXML
    private TextField email;

    @FXML
    private TextField telefoneCelular;


    
    
//    Label lblNome = new Label("Nome");
//    TextField tfNome = new TextField();
//        
//    Label lblContract = new Label("Contract");
//    TextField tfContract = new TextField();
    
    

	public TextField getNome() {
		return nome;
	}

	public void setNome(TextField nome) {
		this.nome = nome;
	}

	public DatePicker getDataDeNascimento() {
		return dataDeNascimento;
	}

	public void setDataDeNascimento(DatePicker dataDeNascimento) {
		this.dataDeNascimento = dataDeNascimento;
	}

	public TextField getRg() {
		return rg;
	}

	public void setRg(TextField rg) {
		this.rg = rg;
	}

	public TextField getRua() {
		return rua;
	}

	public void setRua(TextField rua) {
		this.rua = rua;
	}

	public TextField getNumero() {
		return numero;
	}

	public void setNumero(TextField numero) {
		this.numero = numero;
	}

	public TextField getEstado() {
		return estado;
	}

	public void setEstado(TextField estado) {
		this.estado = estado;
	}

	public TextField getCidade() {
		return cidade;
	}

	public void setCidade(TextField cidade) {
		this.cidade = cidade;
	}

	public TextField getComplemento() {
		return complemento;
	}

	public void setComplemento(TextField complemento) {
		this.complemento = complemento;
	}

	public TextField getCep() {
		return cep;
	}

	public void setCep(TextField cep) {
		this.cep = cep;
	}

	public TextField getTelefoneCelular() {
		return telefoneCelular;
	}

	public void setTelefoneCelular(TextField telefoneCelular) {
		this.telefoneCelular = telefoneCelular;
	}

	public TextField getEmail() {
		return email;
	}

	public void setTelefoneFixo(TextField email) {
		this.email = email;
	}
	
	@FXML
	protected void btnVoltar(ActionEvent eventC) {
		System.out.println("Voltar");
		Platform.exit();
	}

	@FXML
	protected void btnSalvarAction(ActionEvent eventC) {
		
    	if(nome.getText().length() == 0)
    	{	
    		nome.setStyle("-fx-border-color: red ; -fx-border-width: 1px;");
    	}
    	
    	if(dataDeNascimento.getValue() == null)
    	{	
    		dataDeNascimento.setStyle("-fx-border-color: red ; -fx-border-width: 1px;");
    	}
    	
    	if(rg.getText().length() == 0)
    	{	
    		rg.setStyle("-fx-border-color: red ; -fx-border-width: 1px;");
    	}
    	
    	if(rua.getText().length() == 0)
    	{	
    		rua.setStyle("-fx-border-color: red ; -fx-border-width: 1px;");
    	}
    	
    	if(numero.getText().length() == 0)
    	{	
    		numero.setStyle("-fx-border-color: red ; -fx-border-width: 1px;");
    	}
    	
    	if(estado.getText().length() == 0)
    	{	
    		estado.setStyle("-fx-border-color: red ; -fx-border-width: 1px;");
    	}
    	
    	if(cidade.getText().length() == 0)
    	{	
    		cidade.setStyle("-fx-border-color: red ; -fx-border-width: 1px;");
    	}
    	
    	if(complemento.getText().length() == 0)
    	{	
    		complemento.setStyle("-fx-border-color: red ; -fx-border-width: 1px;");
    	}
    	
    	if(email.getText().length() == 0)
    	{	
    		email.setStyle("-fx-border-color: red ; -fx-border-width: 1px;");
    	}
    	
    	if(telefoneCelular.getText().length() == 0)
    	{	
    		telefoneCelular.setStyle("-fx-border-color: red ; -fx-border-width: 1px;");
    	}
    	   	
    	
    	
		System.out.println("Registro Salvo");
	}
}
