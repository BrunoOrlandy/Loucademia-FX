package br.com.loucademia.controller;

import java.time.LocalDateTime;
import java.util.List;

import br.com.loucademia.application.serviceBean.RelatorioEntradaSaidaBean;
import br.com.loucademia.application.util.DataValidation;
import br.com.loucademia.application.util.StringUtils;
import br.com.loucademia.domain.aluno.Acesso;
import br.com.loucademia.domain.tela.NomeTelaEnum;
import br.com.loucademia.startUp.StartUp;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.ScrollEvent;

public class RelatorioController {
	
	@FXML
    private Button btnPesquisar;

    @FXML
    private Label labelMatricula, labelDataInicial, labelDataFinal;

    @FXML
    private DatePicker txtDataInicial, txtDataFinal;

    @FXML
    private TextField txtMatricula;
    
    @FXML
    private TableColumn<Acesso, Number> matriculaColumn;
    
    @FXML
    private TableColumn<Acesso, String> nomeColumn;
    
    @FXML
    private TableColumn<Acesso, LocalDateTime> dataEntradaColumn, dataSaidaColumn;

    @FXML
    private TableColumn<Acesso, String> duracaoColumn;
        
    @FXML
    private TableView<Acesso> tabela;
    
    //private List<Acesso> acessos;

    @FXML
    void btnPesquisarAction(ActionEvent event) {
    	
    	RelatorioEntradaSaidaBean relatorioEntradaSaidaBean = new RelatorioEntradaSaidaBean();
    	    	
    	
		if (validarCamposPrenchidosCorretamente(!StringUtils.isEmpty(txtMatricula.getText()))) {
			relatorioEntradaSaidaBean.setId(Integer.valueOf(txtMatricula.getText()));
		}
	
		if (txtDataInicial.getValue() != null) {
			relatorioEntradaSaidaBean.setDataInicial(txtDataInicial.getValue());
		}
		
		if (txtDataFinal.getValue() != null) {
			relatorioEntradaSaidaBean.setDataFinal(txtDataFinal.getValue());
		}		
		
		//relatorioEntradaSaidaBean.setId(Integer.valueOf(txtMatricula.getText()));
		relatorioEntradaSaidaBean.setDataInicial(txtDataInicial.getValue());
		relatorioEntradaSaidaBean.setDataFinal(txtDataFinal.getValue());		
		relatorioEntradaSaidaBean.gerarRelatorio();			
		
		List<Acesso> listAcessosAlunos = relatorioEntradaSaidaBean.getAcessos();
				
		// Usando expressão lambda
		matriculaColumn.setCellValueFactory((param) -> new SimpleIntegerProperty(param.getValue().getAluno().getId()));
				
		// Usando expressão lambda
		nomeColumn.setCellValueFactory((param) -> new SimpleStringProperty(param.getValue().getAluno().getNome()));			
		
		dataEntradaColumn.setCellValueFactory(new PropertyValueFactory<>("entrada"));
		dataSaidaColumn.setCellValueFactory(new PropertyValueFactory<>("saida"));
		
		// Usando expressão lambda
		duracaoColumn.setCellValueFactory((param) -> new SimpleStringProperty(param.getValue().calcularDuracao()));
		
		if (!listAcessosAlunos.isEmpty()) {
		    tabela.setItems(listaDeAcessos(listAcessosAlunos));
		} else {
		    Alert alert = new Alert(AlertType.INFORMATION);
		    alert.setContentText("Não foram encotrados alunos partir dos dados informados");
		    alert.show();
		    limparCampos();
		}	
		
		tabela.getSelectionModel().selectedItemProperty()
				.addListener((observable, oldValue, newValue) -> onSelectItemDataTable(newValue));
		
		tabela.addEventFilter(ScrollEvent.SCROLL, new EventHandler<ScrollEvent>() {
		    @Override
		    public void handle(ScrollEvent scrollEvent) {
		    	tabela.getAccessibleText();
		    }
		});    	
    }
    
    private ObservableList<Acesso> listaDeAcessos(List<Acesso> acessosList) {
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
    	txtDataInicial.getEditor().clear();
    	txtDataFinal.getEditor().clear();
    }
    
    private boolean validarCamposPrenchidosCorretamente(boolean matricula) {
    	boolean isValidMatricula = false;

		if (matricula) {
		    isValidMatricula = DataValidation.isIntegerValid(txtMatricula, labelMatricula, "Informe apenas Numeros",
			    "Matricula");
		}
    		
    	return isValidMatricula;
    }
    
    public void onSelectItemDataTable(Acesso acesso) {
    	System.err.println(acesso.getAluno().getNome());
    }
}

