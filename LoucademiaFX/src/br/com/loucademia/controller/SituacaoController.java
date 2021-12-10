package br.com.loucademia.controller;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import br.com.loucademia.model.model.Aluno;
import br.com.loucademia.model.model.enums.NomeTelaEnum;
import br.com.loucademia.model.model.enums.SituacaoEnum;
import br.com.loucademia.model.serviceBean.RelatorioSituacaoServiceBean;
import br.com.loucademia.model.util.DataValidation;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.input.ScrollEvent;

public class SituacaoController extends BaseController {

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

    private RelatorioSituacaoServiceBean relatorioSituacaoBean = new RelatorioSituacaoServiceBean();

    private String situacao;

    @FXML
    void btnPesquisarAction(ActionEvent event) {
	Integer id;
	try {
	    id = Integer.valueOf(txtMatricula.getText());
	} catch (NumberFormatException e) {
	    id = null;
	}

	List<Aluno> listaDeAlunos = relatorioSituacaoBean.gerarRelatorio(id, choiseSituacao.getValue());

	// Usando expressão lambda
	matriculaColumn.setCellValueFactory((param) -> new SimpleIntegerProperty(param.getValue().getId()));
	nomeColumn.setCellValueFactory((param) -> new SimpleStringProperty(param.getValue().getNome()));
	situacaoColumn.setCellValueFactory((param) -> new SimpleStringProperty(param.getValue().getSituacao()));
	telefoneColumn.setCellValueFactory((param) -> new SimpleStringProperty(param.getValue().getTelefone()));
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

    private ObservableList<Aluno> listaDeAlunos(List<Aluno> acessosList) {
	return FXCollections.observableList(acessosList);
    }

    @FXML
    void btnVoltar(ActionEvent event) {
	getApp().changeScreen(NomeTelaEnum.MENU);
	limparCampos();
	tabela.getItems().clear();
    }

    public void onSelectItemDataTable(Aluno newValue) {
    }

    private void limparCampos() {
	txtMatricula.clear();
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
