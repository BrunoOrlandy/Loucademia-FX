package br.com.loucademia.application.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

public class LeitorScript {

	private String path;

	public LeitorScript() {
	}

	public static String getConteudoArquivo(String pathArquivo) throws IOException {

		String conteudo = new String();
		byte[] arrayBytes = new byte[8192];

		File arquivo = new File(pathArquivo);

		FileInputStream fileInputStream = new FileInputStream(new File(pathArquivo));

		while (fileInputStream.read(arrayBytes) != -1) {
			conteudo = (new String(arrayBytes, StandardCharsets.UTF_8));

		}

		return conteudo;
	}

	private static boolean isArquivoValido(File arquivo) {
		return arquivo.exists() && arquivo.isDirectory();
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

}