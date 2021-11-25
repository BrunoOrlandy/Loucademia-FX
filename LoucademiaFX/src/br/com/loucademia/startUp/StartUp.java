package br.com.loucademia.startUp;

import br.com.loucademia.domain.tela.NomeTelaEnum;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class StartUp extends Application {

	private static Stage stage;
	private static Scene loginScene;
	private static Scene menuScene;
	private static Scene novoAlunoScene;
	private static Scene pesquisarAlunoScene;
	private static Scene relatorio;
	private static Scene controleAcesso;

	public static void main(String[] args) {
//		JDBCMySql mysql = new JDBCMySql();
//		mysql.criaDataBase();
		launch(args);
	}

	public void start(Stage primaryStage) throws Exception {
		
		stage = primaryStage;
		
		Parent fxmlLogin = FXMLLoader.load(getClass().getResource("/br/com/loucademia/view/login.fxml"));
		loginScene = new Scene(fxmlLogin);
				
		Parent fxmlMenu = FXMLLoader.load(getClass().getResource("/br/com/loucademia/view/menu.fxml"));
		menuScene = new Scene(fxmlMenu);

		Parent fxmlNovoAluno = FXMLLoader.load(getClass().getResource("/br/com/loucademia/view/novo_aluno.fxml"));
		novoAlunoScene = new Scene(fxmlNovoAluno);
		
		Parent fxmlPesquisarAluno = FXMLLoader.load(getClass().getResource("/br/com/loucademia/view/pesquisar_aluno.fxml"));
		pesquisarAlunoScene = new Scene(fxmlPesquisarAluno);
		
		Parent fxmlControleAcesso = FXMLLoader.load(getClass().getResource("/br/com/loucademia/view/controle_acesso.fxml"));
		controleAcesso = new Scene(fxmlControleAcesso);
		
		Parent fxmlRelatrio = FXMLLoader.load(getClass().getResource("/br/com/loucademia/view/relatorio_entrada_saida.fxml"));
		relatorio = new Scene(fxmlRelatrio);
		
		primaryStage.setScene(loginScene);
		primaryStage.setTitle("Loucademia");
		primaryStage.setResizable(false);
		primaryStage.show();

	}

	public static void changeScreen(NomeTelaEnum nomeTela) {
			
		switch (nomeTela) {
		
			case LOGIN:
				stage.setScene(loginScene);
				break;
			case MENU:
				stage.setScene(menuScene);
				break;
			case NOVO_ALUNO:
				stage.setScene(novoAlunoScene);
				break;
			case PESQUISAR_ALUNO:
				stage.setScene(pesquisarAlunoScene);
				break;
			case CONTROLE_ACESSO:
				stage.setScene(controleAcesso);
				break;
			case RELATORIO_ENTRADA_SAIDA:
				stage.setScene(relatorio);
				break;
			case RELATORIO_SITUACAO:
//				stage.setScene(fxmlTela);
			default:
				break;
		}
	}
}
