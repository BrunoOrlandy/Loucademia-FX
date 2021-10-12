package br.com.loucademia.startUp;

import br.com.loucademia.domain.tela.NomeTelaEnum;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class StatUp extends Application {

	private static Stage stage;

	private static Scene loginScene;
	private static Scene menuScene;
	private static Scene novoAlunoScene;

	public static void main(String[] args) {
//		JDBCMySql mysql = new JDBCMySql();
//		mysql.criaDataBase();
		launch(args);
	}

	public void start(Stage primaryStage) throws Exception {
		stage = primaryStage;
		primaryStage.setTitle("Loucademia");

		Parent fxmlLogin = FXMLLoader.load(getClass().getResource("/br/com/loucademia/view/login.fxml"));
		loginScene = new Scene(fxmlLogin);

		Parent fxmlNovoAluno = FXMLLoader.load(getClass().getResource("/br/com/loucademia/view/novo_aluno.fxml"));
		novoAlunoScene = new Scene(fxmlNovoAluno);
		
		primaryStage.setScene(loginScene);
		primaryStage.show();
	}

	public static void changeScreen(NomeTelaEnum nomeTela, Scene fxmlTela) throws Exception {
			
		switch (nomeTela) {
		case LOGIN:
			stage.setScene(loginScene);
			break;
		case MENU:
			stage.setScene(menuScene);
			break;
		case NOVO_ALUNO:
			stage.setScene(fxmlTela);
			break;
		case PESQUISAR_ALUNO:
			stage.setScene(fxmlTela);
			break;
		case CONTROLE_ACESSO:
			stage.setScene(fxmlTela);
			break;
		case RELATORIO_ENTRADA_SAIDA:
			stage.setScene(fxmlTela);
			break;
		case RELATORIO_SITUACAO:
			stage.setScene(fxmlTela);
			break;
		default:
			break;
		}
	}

	public static void changeScreen(NomeTelaEnum nomeTela) {

//		if (nomeTela.equals(NomeTelaEnum.MENU.getNome())) {
//			th = menuScene;
//		} else if (nomeTela.equals(NomeTelaEnum.LOGIN.getNome())) {
//			fxmlTela = loginScene;
//		}
		switch (nomeTela) {
		case LOGIN:
			stage.setScene(loginScene);
		case MENU:
			stage.setScene(menuScene);
		case NOVO_ALUNO:
			stage.setScene(novoAlunoScene);
		case PESQUISAR_ALUNO:
//			stage.setScene(fxmlTela);
		case CONTROLE_ACESSO:
//			stage.setScene(fxmlTela);
		case RELATORIO_ENTRADA_SAIDA:
//			stage.setScene(fxmlTela);
		case RELATORIO_SITUACAO:
//			stage.setScene(fxmlTela);
		default:
			break;
		}
	}
}
