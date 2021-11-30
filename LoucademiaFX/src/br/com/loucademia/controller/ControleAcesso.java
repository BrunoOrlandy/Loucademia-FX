package br.com.loucademia.controller;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import br.com.loucademia.application.serviceBean.AlunoServiceBean;
import br.com.loucademia.application.serviceBean.ControleAcessoServiceBean;
import br.com.loucademia.application.serviceBean.PesquisaAlunoServiceBean;
import br.com.loucademia.application.util.DataValidation;
import br.com.loucademia.application.util.StringUtils;
import br.com.loucademia.domain.aluno.Acesso;
import br.com.loucademia.domain.aluno.Aluno;
import br.com.loucademia.domain.tela.NomeTelaEnum;
import br.com.loucademia.startUp.StartUp;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.ScrollEvent;

public class ControleAcesso {

    @FXML
    private Button btnRegistrarEntrada, btnRegistrarSaida;

    @FXML
    private Label labelMatricula, labelCPF;

    @FXML
    private TextField txtMatricula, txtCPF;

    @FXML
    private TableColumn<Aluno, Integer> matriculaColumn;

    @FXML
    private TableColumn<Aluno, String> nomeColumn;
    
    @FXML
    private TableColumn<Acesso, LocalDateTime> entradaColumn;

    @FXML
    private TableColumn<Acesso, LocalDateTime> saidaColumn;
    
    @FXML
    private TableView<Aluno> tabela;
    
    private List<Acesso> acessos;

    @FXML
    void btnRegistrarEntradaAction(ActionEvent event) {
    	
    	Aluno alunoPesquisa = new Aluno();
    	validarCamposPrenchidosCorretamente();
    	PesquisaAlunoServiceBean serviceBean = new PesquisaAlunoServiceBean();
    	AlunoServiceBean alunoServiceBean = new AlunoServiceBean();
    	ControleAcessoServiceBean controleAcessoServiceBean = new ControleAcessoServiceBean();
    	
    	if (StringUtils.isEmpty(txtMatricula.getText()) && StringUtils.isEmpty(txtCPF.getText())) {    	
	    	Alert alert = new Alert(AlertType.INFORMATION);
		    alert.setContentText("E preciso fornecer a matricula ou o RG do aluno");
		    alert.show();		    
    	}  		    
		    
		if (!StringUtils.isEmpty(txtMatricula.getText())) {
			System.out.println("Procurando aluno pelo ID");
			alunoPesquisa.setId(Integer.valueOf(txtMatricula.getText()));
			
		} else {
			System.out.println("Procurando aluno pelo CPF");
			alunoPesquisa.setCpf(txtCPF.getText());
		}
		
    	Alert alert = new Alert(AlertType.INFORMATION);
	    alert.setContentText(controleAcessoServiceBean.registrarAcesso((Integer.valueOf(txtMatricula.getText())), txtCPF.getText()) + " registrada!");
	    alert.show();
		
		//controleAcessoServiceBean.registrarAcesso((Integer.valueOf(txtMatricula.getText())), txtCPF.getText());
		
		matriculaColumn.setCellValueFactory(new PropertyValueFactory<>("id"));
		nomeColumn.setCellValueFactory(new PropertyValueFactory<>("nome"));
				
		
		//List<Acesso> listAcessosAlunos = null;	//alunoServiceBean.listAcessosAlunos(null, null, null);
		
		List<Aluno> alunosEncontrado = serviceBean.buscarAluno(alunoPesquisa);
		if (!alunosEncontrado.isEmpty()) {
		    tabela.setItems(listaDeAlunos(alunosEncontrado));
		} else {
		    //Alert alert = new Alert(AlertType.INFORMATION);
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

    
    @FXML
    void btnRegistrarSaidaAction(ActionEvent event) {
    	    	
    	Aluno alunoPesquisa = new Aluno();
    	validarCamposPrenchidosCorretamente();
    	PesquisaAlunoServiceBean serviceBean = new PesquisaAlunoServiceBean();
    	AlunoServiceBean alunoServiceBean = new AlunoServiceBean();
    	ControleAcessoServiceBean controleAcessoServiceBean = new ControleAcessoServiceBean();
    	
    	if (StringUtils.isEmpty(txtMatricula.getText()) && StringUtils.isEmpty(txtCPF.getText())) {    	
	    	Alert alert = new Alert(AlertType.INFORMATION);
		    alert.setContentText("E preciso fornecer a matricula ou o RG do aluno");
		    alert.show();		    
    	}  		    
		    
		if (!StringUtils.isEmpty(txtMatricula.getText())) {
			System.out.println("Procurando aluno pelo ID");
			alunoPesquisa.setId(Integer.valueOf(txtMatricula.getText()));
			
		} else {
			System.out.println("Procurando aluno pelo CPF");
			alunoPesquisa.setCpf(txtCPF.getText());
		}
		
    	Alert alert = new Alert(AlertType.INFORMATION);
	    alert.setContentText(controleAcessoServiceBean.registrarAcesso((Integer.valueOf(txtMatricula.getText())), txtCPF.getText()) + " registrada!");
	    alert.show();
		
		
    }

    @FXML
    void btnVoltar(ActionEvent event) {
    	StartUp.changeScreen(NomeTelaEnum.MENU);
    	limparCampos();
    	tabela.getItems().clear();
    }
    
    private void validarCamposPrenchidosCorretamente() {
    	boolean isValidTelefone, isValidMatricula, isValidCPF, isNomeValido = false;

		if (!StringUtils.isEmpty(txtMatricula.getText())) {
		    isValidMatricula = DataValidation.isIntegerValid(txtMatricula, labelMatricula, "Informe apenas Numeros",
			    "Matricula");
		}
	
		if (!StringUtils.isEmpty(txtCPF.getText())) {
		    isValidCPF = DataValidation.isCPF(txtCPF, labelCPF, "Informe apenas números");
		}
    }
    
    private void limparCampos() {
    	txtMatricula.clear();
    	txtCPF.clear();
    }
    
    public void onSelectItemDataTable(Aluno aluno) {
    	System.err.println(aluno.getNome());
    }
    
    private ObservableList<Aluno> listaDeAlunos(List<Aluno> alunosList) {
    	return FXCollections.observableList(alunosList);
    }
}
