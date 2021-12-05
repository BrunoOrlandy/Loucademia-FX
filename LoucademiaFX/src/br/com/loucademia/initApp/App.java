package br.com.loucademia.initApp;

import java.io.IOException;

import br.com.loucademia.controller.AlunoController;
import br.com.loucademia.controller.BaseController;
import br.com.loucademia.controller.ControleAcesso;
import br.com.loucademia.controller.LoginController;
import br.com.loucademia.controller.MenuController;
import br.com.loucademia.controller.PesquisarAlunoController;
import br.com.loucademia.controller.RelatorioController;
import br.com.loucademia.domain.tela.NomeTelaEnum;
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

    private static AlunoController alunoController;
    private static PesquisarAlunoController pesquisarAlunoController;
    private static ControleAcesso controleAcessoAlunoController;
    private static RelatorioController relatorioController;
    private static MenuController menuController;
    private static LoginController loginController;

    private static Stage stage;
//    private static Scene loginScene;
//    private static Scene menuScene;
//    private static Scene novoAlunoScene;
//    private static Scene pesquisarAlunoScene;
//    private static Scene relatorio;
//    private static Scene controleAcesso;

    public static void main(String[] args) {
	launch(args);
    }

    public void start(Stage primaryStage) throws Exception {

	stage = primaryStage;

	alunoController = loadController(PATH_VIEW_NOVO_ALUNO);// "/br/com/loucademia/view/novo_aluno.fxml");
	pesquisarAlunoController = loadController("/br/com/loucademia/view/pesquisar_aluno.fxml");
	loginController = loadController(PATH_VIEW_LOGIN);
	menuController = loadController(PATH_VIEW_MENU);
	controleAcessoAlunoController = loadController(PATH_VIEW_CONTROLE_ACESSO);
	relatorioController = loadController(PATH_VIEW_REL_ENTRADA_SAIDA);

//	Parent fxmlLogin = FXMLLoader.load(getClass().getResource("/br/com/loucademia/view/login.fxml"));
//	loginScene = new Scene(fxmlLogin);

//	Parent fxmlMenu = FXMLLoader.load(getClass().getResource("/br/com/loucademia/view/menu.fxml"));
//	menuScene = new Scene(fxmlMenu);

//	Parent fxmlNovoAluno = FXMLLoader.load(getClass().getResource("/br/com/loucademia/view/novo_aluno.fxml"));
//	novoAlunoScene = new Scene(fxmlNovoAluno);

//	Parent fxmlPesquisarAluno = FXMLLoader
//		.load(getClass().getResource("/br/com/loucademia/view/pesquisar_aluno.fxml"));
//	pesquisarAlunoScene = new Scene(fxmlPesquisarAluno);

//	Parent fxmlControleAcesso = FXMLLoader
//		.load(getClass().getResource("/br/com/loucademia/view/controle_acesso.fxml"));
//	controleAcesso = new Scene(fxmlControleAcesso);
//
//	Parent fxmlRelatrio = FXMLLoader
//		.load(getClass().getResource("/br/com/loucademia/view/relatorio_entrada_saida.fxml"));
//	relatorio = new Scene(fxmlRelatrio);

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
//				stage.setScene(fxmlTela);
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
