package br.com.loucademia.application.util;

import java.util.ResourceBundle;

public class MessageUtils {

	static final String PATH_PROPERTIES = "src/ResourceBundle/messages";
	private static ResourceBundle BUNDLE = ResourceBundle.getBundle("messages");

	public static String getMensagem(String labelMensagem) {
		if (BUNDLE.containsKey(labelMensagem)) {
			return BUNDLE.getString(labelMensagem);
		}
		return "";
	}

}
