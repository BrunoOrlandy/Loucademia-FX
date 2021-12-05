package br.com.loucademia.controller;

import java.net.URL;
import java.util.ResourceBundle;

import br.com.loucademia.initApp.App;
import javafx.fxml.Initializable;
import javafx.scene.Scene;

public class BaseController implements Initializable {

    private App app;
    private Scene scene;

    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
	System.out.println("teste");
    }

    public void configurarNavegacao(App app, Scene scene) {
	this.app = app;
	this.scene = scene;
    }

    public App getApp() {
	return app;
    }

    public Scene getScene() {
	return scene;
    }

}