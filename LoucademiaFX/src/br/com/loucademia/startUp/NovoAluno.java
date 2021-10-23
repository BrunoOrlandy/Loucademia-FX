package br.com.loucademia.startUp;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class NovoAluno extends Application {

	private static Stage stage;

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage stageNovoAluno) throws Exception {
		Parent fxmlNovoAluno = FXMLLoader.load(getClass().getResource("/br/com/loucademia/view/novo_aluno.fxml"));
		Scene novoAlunoScene = new Scene(fxmlNovoAluno);
		stageNovoAluno.setTitle("Loucademia");
		stageNovoAluno.setScene(novoAlunoScene);
		stageNovoAluno.show();
		this.setStageNovoAluno(stageNovoAluno);
	}

	public static Stage getStageNovoAluno() {
		return stage;
	}

	public static void setStageNovoAluno(Stage stage) {
		NovoAluno.stage = stage;
	}
}
