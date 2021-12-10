package br.com.loucademia.controller;

import java.net.URL;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import br.com.loucademia.initApp.App;
import br.com.loucademia.model.model.Acesso;
import br.com.loucademia.model.model.Aluno;
import br.com.loucademia.model.model.enums.NomeTelaEnum;
import br.com.loucademia.model.serviceBean.AlunoServiceBean;
import br.com.loucademia.model.serviceBean.PesquisaAlunoServiceBean;
import br.com.loucademia.model.serviceBean.RelatorioEntradaSaidaServiceBean;
import br.com.loucademia.model.util.DataValidation;
import br.com.loucademia.model.util.StringUtils;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.ScrollEvent;

public class RelatorioEntradaSaidaController extends BaseController {

    private final static String ERROR_CSS = "-fx-border-color: red ; -fx-border-width: 1px;";

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
    private TableColumn<Acesso, String> dtEntradaColString, dtSaidaColString;

    @FXML
    private TableColumn<Acesso, String> duracaoColumn;

    @FXML
    private TableView<Acesso> tabela;

    private LocalDate dataInicial;
    private LocalDate dataFinal;
    private Integer id;

    @FXML
    void btnPesquisarAction(ActionEvent event) {

	RelatorioEntradaSaidaServiceBean relatorioEntradaSaidaBean = new RelatorioEntradaSaidaServiceBean();

	if (validarCamposPrenchidosCorretamente(!StringUtils.isEmpty(txtMatricula.getText()))) {
	    setId(Integer.valueOf(txtMatricula.getText()));
	}

	if (txtDataInicial.getValue() != null) {
	    setDataInicial(txtDataInicial.getValue());
	}

	if (txtDataFinal.getValue() != null) {
	    setDataFinal(txtDataFinal.getValue());
	}

	List<Acesso> listAcessosAlunos = new ArrayList<Acesso>();
	listAcessosAlunos = relatorioEntradaSaidaBean.gerarRelatorio(id, txtDataInicial.getValue(),
		txtDataFinal.getValue());

	

	formatarCamposDeData(listAcessosAlunos);

	if (listAcessosAlunos != null) {
	    if (!listAcessosAlunos.isEmpty()) {
		tabela.setItems(listaDeAcessos(listAcessosAlunos));
		setCellValueDataView();
		tabela.getSelectionModel().selectedItemProperty()
			.addListener((observable, oldValue, newValue) -> onSelectItemDataTable(newValue));

		tabela.addEventFilter(ScrollEvent.SCROLL, new EventHandler<ScrollEvent>() {
		    @Override
		    public void handle(ScrollEvent scrollEvent) {
			tabela.getAccessibleText();
		    }
		});
	    }
	} else {
	    Alert alert = new Alert(AlertType.INFORMATION);
	    alert.setContentText("Não existem alunos para gerar Relatório de ENTRADA e SAÍDA");
	    alert.show();
	    limparCampos();
	}
    }

    private void formatarCamposDeData(List<Acesso> listAcessosAlunos) {
	DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
	for (Acesso acesso : listAcessosAlunos) {
	    if (acesso.getEntrada() != null) {
		acesso.setEntradaString(formatter.format(acesso.getEntrada()));
	    }
	    if (acesso.getSaida() != null) {
		acesso.setSaidaString(formatter.format(acesso.getSaida()));
	    }
	}
    }

    private void setCellValueDataView() {
	matriculaColumn.setCellValueFactory((param) -> new SimpleIntegerProperty(param.getValue().getAluno().getId()));
	nomeColumn.setCellValueFactory((param) -> new SimpleStringProperty(param.getValue().getAluno().getNome()));
	duracaoColumn.setCellValueFactory((param) -> new SimpleStringProperty(param.getValue().calcularDuracao()));
//	dataEntradaColumn.setCellValueFactory(new PropertyValueFactory<>("entrada"));
//	dataSaidaColumn.setCellValueFactory(new PropertyValueFactory<>("saida"));
	dtEntradaColString
		.setCellValueFactory((param) -> new SimpleStringProperty(param.getValue().getEntradaString()));
	dtSaidaColString.setCellValueFactory((param) -> new SimpleStringProperty(param.getValue().getSaidaString()));

    }

    private ObservableList<Acesso> listaDeAcessos(List<Acesso> acessosList) {
	return FXCollections.observableList(acessosList);
    }

    @FXML
    void btnVoltar(ActionEvent event) {
	getApp().changeScreen(NomeTelaEnum.MENU);
	limparCampos();
    }

    private void limparCampos() {
	txtMatricula.clear();
	txtMatricula.setText(null);
	setId(null);
	txtDataInicial.getEditor().clear();
	txtDataInicial.setValue(null);
	txtDataFinal.getEditor().clear();
	txtDataFinal.setValue(null);
	tabela.getItems().clear();
    }

    private boolean validarCamposPrenchidosCorretamente(boolean matricula) {
	boolean isValidMatricula = false;

	if (matricula) {
	    isValidMatricula = DataValidation.isIntegerValid(txtMatricula, labelMatricula, "Informe apenas Numeros",
		    "Matricula");
	}

	return isValidMatricula;
    }

    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {

    }

    public void onSelectItemDataTable(Acesso acesso) {
	System.err.println(acesso.getAluno().getNome());
    }

    public Integer getId() {
	return id;
    }

    public void setId(Integer id) {
	this.id = id;
    }

    public LocalDate getDataInicial() {
	return dataInicial;
    }

    public void setDataInicial(LocalDate dataInicial) {
	this.dataInicial = dataInicial;
    }

    public LocalDate getDataFinal() {
	return dataFinal;
    }

    public void setDataFinal(LocalDate dataFinal) {
	this.dataFinal = dataFinal;
    }

}
