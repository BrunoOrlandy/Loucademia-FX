package br.com.loucademia.initApp;

import java.io.IOException;

import br.com.loucademia.controller.AlunoController;
import br.com.loucademia.controller.BaseController;
import br.com.loucademia.controller.AcessoController;
import br.com.loucademia.controller.LoginController;
import br.com.loucademia.controller.MenuController;
import br.com.loucademia.controller.PesquisarAlunoController;
import br.com.loucademia.controller.RelatorioEntradaSaidaController;
import br.com.loucademia.controller.SituacaoController;
import br.com.loucademia.model.model.enums.NomeTelaEnum;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class App extends Application {

    private static String PATH_VIEW_NOVO_ALUNO = "/br/com/loucademia/view/novo_aluno.fxml";
    private static String PATH_VIEW_PESQUISA_NOVO_ALUNO = "/br/com/loucademia/view/pesquisar_aluno.fxml";
    private static String PATH_VIEW_LOGIN = "/br/com/loucademia/view/login.fxml";
    private static String PATH_VIEW_MENU = "/br/com/loucademia/view/menu.fxml";
    private static String PATH_VIEW_CONTROLE_ACESSO = "/br/com/loucademia/view/controle_acesso.fxml";
    private static String PATH_VIEW_REL_ENTRADA_SAIDA = "/br/com/loucademia/view/relatorio_entrada_saida.fxml";
    private static String PATH_VIEW_RELATORIO_SITUACAO = "/br/com/loucademia/view/relatorio_situacao.fxml";

    private static AlunoController alunoController;
    private static PesquisarAlunoController pesquisarAlunoController;
    private static AcessoController controleAcessoAlunoController;
    private static RelatorioEntradaSaidaController relatorioController;
    private static MenuController menuController;
    private static LoginController loginController;
    private static SituacaoController situacaoController;

    private static Stage stage;

    public static void main(String[] args) {
	launch(args);
    }

    public void start(Stage primaryStage) throws Exception {

	stage = primaryStage;

	alunoController = loadController(PATH_VIEW_NOVO_ALUNO);
	pesquisarAlunoController = loadController(PATH_VIEW_PESQUISA_NOVO_ALUNO);
	loginController = loadController(PATH_VIEW_LOGIN);
	menuController = loadController(PATH_VIEW_MENU);
	controleAcessoAlunoController = loadController(PATH_VIEW_CONTROLE_ACESSO);
	relatorioController = loadController(PATH_VIEW_REL_ENTRADA_SAIDA);
	situacaoController = loadController(PATH_VIEW_RELATORIO_SITUACAO);

	primaryStage.setScene(loginController.getScene());
	primaryStage.setTitle("Loucademia");
	primaryStage.setResizable(false);
	primaryStage.show();

    }

    public <T extends BaseController> T loadController(String url) throws IOException {
	FXMLLoader loader = new FXMLLoader(getClass().getResource(url));
	Parent root = loader.load();
	T baseController = loader.<T>getController();
	baseController.configurarNavegacao(this, new Scene(root));
	return baseController;

    }

    public static void changeScreen(NomeTelaEnum nomeTela) {

	switch (nomeTela) {

	case LOGIN:
	    stage.setScene(loginController.getScene());
	    break;
	case MENU:
	    stage.setScene(menuController.getScene());
	    break;
	case NOVO_ALUNO:
	    stage.setScene(alunoController.getScene());
	    break;
	case PESQUISAR_ALUNO:
	    stage.setScene(pesquisarAlunoController.getScene());
	    break;
	case CONTROLE_ACESSO:
	    stage.setScene(controleAcessoAlunoController.getScene());
	    break;
	case RELATORIO_ENTRADA_SAIDA:
	    stage.setScene(relatorioController.getScene());
	    break;
	case RELATORIO_SITUACAO:
	    stage.setScene(situacaoController.getScene());
	default:
	    break;
	}
    }

    public AlunoController getAlunoController() {
	return alunoController;
    }

    public PesquisarAlunoController getPesquisarAlunoController() {
	return pesquisarAlunoController;
    }

}
