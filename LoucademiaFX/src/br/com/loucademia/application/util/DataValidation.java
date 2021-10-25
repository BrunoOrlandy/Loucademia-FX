package br.com.loucademia.application.util;

import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DataValidation {

	// Método que valida o campo do nome
	public static boolean isName(TextField inputTextField, Label inputLabel, String validationText) {
        boolean isAlphabet = true;        
        
        if(inputTextField.getText().length() == 0) {
        	isAlphabet = false;
        	showDinamico(inputTextField, inputLabel, isAlphabet);
        
        } else if (!inputTextField.getText().matches("[a-z A-Z]+")) {
            isAlphabet = false;
            inputLabel.setText(validationText);
            showDinamico(inputTextField, inputLabel, isAlphabet);
            
        } else {        	
        	isAlphabet = true;
        	inputLabel.setText("Nome");
        	showDinamico(inputTextField, inputLabel, isAlphabet);
        }    

        //System.out.println(isAlphabet);
        return isAlphabet;

    }	
	
	// Método que valida o campo da identidade
	public static boolean isIdentidade(TextField inputTextField, Label inputLabel, String validationText) {
		boolean isIdentidade = true;
		
		if(inputTextField.getText().length() == 0) {
			isIdentidade = false;
			showDinamico(inputTextField, inputLabel, isIdentidade);
			
		} else if (!inputTextField.getText().matches("[0-9]+")) {
			isIdentidade = false;
            inputLabel.setText(validationText);
            showDinamico(inputTextField, inputLabel, isIdentidade);

		} else {
			isIdentidade = true;
        	inputLabel.setText("CPF");
        	showDinamico(inputTextField, inputLabel, isIdentidade);
		}
		
		return isIdentidade;
	}
	
	// Método que valida o campo da rua
	public static boolean isRua(TextField inputTextField, Label inputLabel, String validationText) {
		boolean isRua = true;		
		
		if(inputTextField.getText().length() == 0) {
			isRua = false;
			showDinamico(inputTextField, inputLabel, isRua);
		} else {
			isRua = true;
        	inputLabel.setText("Rua");
        	showDinamico(inputTextField, inputLabel, isRua);
		}
		
		return isRua;
	}
	
	// Método que valida o campo número da residência
	public static boolean isNumero(TextField inputTextField, Label inputLabel, String validationText) {
		boolean isNumero = true;
		
		if(inputTextField.getText().length() == 0) {
			isNumero = false;
			showDinamico(inputTextField, inputLabel, isNumero);
			
		} else if (!inputTextField.getText().matches("[0-9]+")) {
			isNumero = false;
            inputLabel.setText(validationText);
            showDinamico(inputTextField, inputLabel, isNumero);

		} else {
			isNumero = true;
        	inputLabel.setText("Número");
        	showDinamico(inputTextField, inputLabel, isNumero);
		}
		
		return isNumero;
	}
	
	// Método que valida o campo referene ao estado
	public static boolean isEstado(TextField inputTextField, Label inputLabel, String validationText) {
		boolean isEstado = true;
		
		if(inputTextField.getText().length() == 0) {
			isEstado = false;
			showDinamico(inputTextField, inputLabel, isEstado);
			
		} else if (!inputTextField.getText().matches("[a-z A-Z]+")) {
			isEstado = false;
            inputLabel.setText(validationText);
            showDinamico(inputTextField, inputLabel, isEstado);

		} else {
			isEstado = true;
        	inputLabel.setText("Estado");
        	showDinamico(inputTextField, inputLabel, isEstado);
		}
		
		return isEstado;
	}
	
	// Método que valida o campo da cidade
	public static boolean isCidade(TextField inputTextField, Label inputLabel, String validationText) {
		boolean isCidade = true;		
		
		if(inputTextField.getText().length() == 0) {
			isCidade = false;
			showDinamico(inputTextField, inputLabel, isCidade);
			
		} else if (!inputTextField.getText().matches("[a-z A-Z]+")) {
			isCidade = false;
            inputLabel.setText(validationText);
            showDinamico(inputTextField, inputLabel, isCidade);

		} else {
			isCidade = true;
        	inputLabel.setText("Cidade");
        	showDinamico(inputTextField, inputLabel, isCidade);
		}
		
		return isCidade;
	}
	
	
	// Método que valida o campo do email
	public static boolean emailFormat(TextField inputTextField, Label inputLabel, String validationText) {
		boolean isEmail = true;		
		
		if(inputTextField.getText().length() == 0) {
			isEmail = false;
			showDinamico(inputTextField, inputLabel, isEmail);
			
		} else if (!inputTextField.getText().matches("[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.com")) {
			isEmail = false;
            inputLabel.setText(validationText);
            showDinamico(inputTextField, inputLabel, isEmail);

		} else {
			isEmail = true;
        	inputLabel.setText("E-mail");
        	showDinamico(inputTextField, inputLabel, isEmail);
		}
		
		return isEmail;
	}

	
	public static boolean isPhone(TextField inputTextField, Label inputLabel, String validationText) {
		boolean isNumeric = true;

		if(inputTextField.getText().length() == 0) {
			isNumeric = false;
			showDinamico(inputTextField, inputLabel, isNumeric);
			
		} else if (!inputTextField.getText().matches("[0-9]+")) {
			isNumeric = false;
            inputLabel.setText(validationText);
            showDinamico(inputTextField, inputLabel, isNumeric);

		} else {
			isNumeric = true;
        	inputLabel.setText("Celular");
        	showDinamico(inputTextField, inputLabel, isNumeric);
		}
		
		return isNumeric;

	}	

	public static boolean zID(TextField inputTextField, Label inputLabel, String validationText) {
		boolean isZID = true;
		String validationString = null;

		if (!inputTextField.getText().matches("\\z[0-9]{7}") || inputTextField.getText().length() == 0) {
			isZID = false;
			validationString = validationText;

		}
		inputLabel.setText(validationString);

		return isZID;

	}
	
	
	// Altera design do menu conforme validações de forma dinâmica
	private static void showDinamico(TextField inputTextField, Label inputLabel, boolean validation) {
		
		if(!validation) {
			inputTextField.setStyle("-fx-border-color: red ; -fx-border-width: 1px;");
    		inputLabel.setTextFill(Color.RED);
    		
		} else {
        	inputTextField.setStyle(null);
        	inputLabel.setTextFill(Color.BLACK);
		}
	}

}
