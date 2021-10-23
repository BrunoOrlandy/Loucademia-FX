package br.com.loucademia.startUp;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class StatUp extends Application {

	private static Stage stage;

	public static void main(String[] args) {
//		JDBCMySql mysql = new JDBCMySql();
//		mysql.criaDataBase();
		launch(args);
	}

	public void start(Stage stageStartUp) throws Exception {

		Parent fxmlLogin = FXMLLoader.load(getClass().getResource("/br/com/loucademia/view/login.fxml"));
		Scene loginScene = new Scene(fxmlLogin);
		stageStartUp.setTitle("Loucademia");
		stageStartUp.setScene(loginScene);
		stageStartUp.show();
		this.setStage(stageStartUp);
	}

	public static Stage getStage() {
		return stage;
	}

	public static void setStage(Stage stage) {
		StatUp.stage = stage;
	}

}
