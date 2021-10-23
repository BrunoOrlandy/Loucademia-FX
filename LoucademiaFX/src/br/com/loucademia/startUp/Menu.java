package br.com.loucademia.startUp;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Menu extends Application {

	private static Stage stage;

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage stageMenu) throws Exception {
		Parent fxmlMenu = FXMLLoader.load(getClass().getResource("/br/com/loucademia/view/menu.fxml"));
		Scene menuScene = new Scene(fxmlMenu);
		stageMenu.setTitle("Loucademia");
		stageMenu.setScene(menuScene);
		stageMenu.show();
		this.setStageMenu(stageMenu);
	}

	public static Stage getStageMenu() {
		return stage;
	}

	public static void setStageMenu(Stage stage) {
		Menu.stage = stage;
	}

}
