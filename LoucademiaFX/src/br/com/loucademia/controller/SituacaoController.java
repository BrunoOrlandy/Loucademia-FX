package br.com.loucademia.controller;

import java.net.URL;
import java.time.LocalDateTime;
import java.util.List;
import java.util.ResourceBundle;

import br.com.loucademia.application.serviceBean.RelatorioEntradaSaidaBean;
import br.com.loucademia.application.serviceBean.RelatorioSituacoesBean;
import br.com.loucademia.application.util.DataValidation;
import br.com.loucademia.application.util.StringUtils;
import br.com.loucademia.domain.aluno.Acesso;
import br.com.loucademia.domain.aluno.Aluno;
import br.com.loucademia.domain.aluno.SituacaoEnum;
import br.com.loucademia.domain.tela.NomeTelaEnum;
import br.com.loucademia.startUp.StartUp;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.ScrollEvent;
import javafx.scene.control.RadioButton;

public class SituacaoController implements Initializable {
	
	@FXML
    private Button btnPesquisar;

    @FXML
    private Label labelMatricula;

    @FXML
    private TextField txtMatricula;
    
    @FXML
    private TableColumn<Aluno, Number> matriculaColumn;
    
    @FXML
    private TableColumn<Aluno, String> nomeColumn, situacaoColumn, telefoneColumn;
    
    @FXML
    private TableView<Aluno> tabela;
    
    @FXML
    private ChoiceBox<String> choiseSituacao;
    
    private RelatorioSituacoesBean relatorioSituacaoBean = new RelatorioSituacoesBean();
    
    private String situacao;

    @FXML
    void btnPesquisarAction(ActionEvent event) {    	    	   
    	

    	
    	//SituacaoEnum.getSituacaoes();
    	
//		if (validarCamposPrenchidosCorretamente(!StringUtils.isEmpty(txtMatricula.getText()))) {
//			relatorioSituacaoBean.gerarRelatorio(txtMatricula.getText());
//		}
		
		//List<Aluno> listaDeAlunos = relatorioSituacaoBean.listaAlunosById(Integer.valueOf(txtMatricula.getText()));
		List<Aluno> listaDeAlunos = relatorioSituacaoBean.gerarRelatorio(Integer.valueOf(txtMatricula.getText()), choiseSituacao.getValue());
	

//		relatorioEntradaSaidaBean.gerarRelatorio();			
//		
//		List<Acesso> listAcessosAlunos = relatorioEntradaSaidaBean.getAcessos();
//				
//		// Usando expressão lambda
		matriculaColumn.setCellValueFactory((param) -> new SimpleIntegerProperty(param.getValue().getId()));
//				
//		// Usando expressão lambda
//		nomeColumn.setCellValueFactory((param) -> new SimpleStringProperty(param.getValue().getAluno().getNome()));			
//		
//		dataEntradaColumn.setCellValueFactory(new PropertyValueFactory<>("entrada"));
//		dataSaidaColumn.setCellValueFactory(new PropertyValueFactory<>("saida"));
//		
//		// Usando expressão lambda
//		duracaoColumn.setCellValueFactory((param) -> new SimpleStringProperty(param.getValue().calcularDuracao()));
//		
//		if (!listAcessosAlunos.isEmpty()) {
//		    tabela.setItems(listaDeAcessos(listAcessosAlunos));
//		    
//		} else {
//		    Alert alert = new Alert(AlertType.INFORMATION);
//		    alert.setContentText("Não foram encotrados alunos partir dos dados informados");
//		    alert.show();
//		    limparCampos();
//		}
		
		tabela.setItems(listaDeAlunos(listaDeAlunos));
		
		tabela.getSelectionModel().selectedItemProperty()
				.addListener((observable, oldValue, newValue) -> onSelectItemDataTable(newValue));
		
		tabela.addEventFilter(ScrollEvent.SCROLL, new EventHandler<ScrollEvent>() {
		    @Override
		    public void handle(ScrollEvent scrollEvent) {
		    	tabela.getAccessibleText();
		    }
		});    	
    }
    
//    private ObservableList<Acesso> listaDeAcessos(List<Acesso> acessosList) {
//    	return FXCollections.observableList(acessosList);
//    }
    
    private ObservableList<Aluno> listaDeAlunos(List<Aluno> acessosList) {
    	return FXCollections.observableList(acessosList);
    }

	@FXML
    void btnVoltar(ActionEvent event) {
    	StartUp.changeScreen(NomeTelaEnum.MENU);
    	limparCampos();
    	tabela.getItems().clear();
    }
    
    private void limparCampos() {
    	txtMatricula.clear();
    }
    
    private boolean validarCamposPrenchidosCorretamente(boolean matricula) {
    	boolean isValidMatricula = false;

		if (matricula) {
		    isValidMatricula = DataValidation.isIntegerValid(txtMatricula, labelMatricula, "Informe apenas Numeros",
			    "Matricula");
		}
    		
    	return isValidMatricula;
    }
    
    public void onSelectItemDataTable(Aluno newValue) {
    	//System.err.println(newValue.gerarRelatorio(txtMatricula.getText()));
    }
    
    public void getSituacao(ActionEvent e) {
		situacao = choiseSituacao.getValue();
    }
    
    private ObservableList<String> listaSituacaoEnums() {
    	return FXCollections.observableList(SituacaoEnum.getSituacaoes()).sorted();
    }
    
    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
    	choiseSituacao.setStyle(situacao);
    	choiseSituacao.getItems().addAll(listaSituacaoEnums());    	
    	choiseSituacao.setOnAction(this::getSituacao);
    }
    
}

