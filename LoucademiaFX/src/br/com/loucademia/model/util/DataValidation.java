package br.com.loucademia.model.util;

import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;

import java.time.format.DateTimeFormatter;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import br.com.loucademia.model.model.enums.EstadoEnum;

public class DataValidation {

    // Método que valida o campo do nome
    public static boolean isName(TextField inputTextField, Label inputLabel, String validationText) {
	boolean isAlphabet = true;

	if (inputTextField.getText().length() == 0) {
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

	return isAlphabet;

    }

    // Método que valida o campo da identidade
    public static boolean isIdentidade(TextField inputTextField, Label inputLabel, String validationText) {
	boolean isIdentidade = true;

	if (inputTextField.getText().length() == 0) {
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

	if (inputTextField.getText().length() == 0) {
	    isRua = false;
	    showDinamico(inputTextField, inputLabel, isRua);
	} else {
	    isRua = true;
	    inputLabel.setText("Rua");
	    showDinamico(inputTextField, inputLabel, isRua);
	}

	return isRua;
    }

    // Método que valida o campo n�mero da resid�ncia
    public static boolean isNumero(TextField inputTextField, Label inputLabel, String validationText) {
	boolean isNumero = true;

	if (inputTextField.getText().length() == 0) {
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

    public static boolean isTelefone(TextField inputTextField, Label inputLabel, String validationText) {
	boolean isNumero = true;

	if (inputTextField.getText().length() == 0) {
	    isNumero = false;
	    showDinamico(inputTextField, inputLabel, isNumero);

	} else if (!inputTextField.getText().matches("[0-9]+")) {
	    isNumero = false;
	    inputLabel.setText(validationText);
	    showDinamico(inputTextField, inputLabel, isNumero);

	} else {
	    isNumero = true;
	    inputLabel.setText("Telefone");
	    showDinamico(inputTextField, inputLabel, isNumero);
	}

	return isNumero;
    }

    // Método que valida o campo referene ao estado

    // Método que valida o campo da cidade
    public static boolean isCidade(TextField inputTextField, Label inputLabel, String validationText) {
	boolean isCidade = true;

	if (inputTextField.getText().length() == 0) {
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

	if (inputTextField.getText().length() == 0) {
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

	if (inputTextField.getText().length() == 0) {
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

    public static void showDinamico(TextField inputTextField, Label inputLabel, boolean validation) {

	if (!validation) {
	    inputTextField.setStyle("-fx-border-color: red ; -fx-border-width: 1px;");
	    inputLabel.setTextFill(Color.RED);

	} else {
	    inputTextField.setStyle(null);
	    inputLabel.setTextFill(Color.BLACK);
	}
    }

    private static void showDinamico(ChoiceBox<String> choiseBox, Label inputLabel, boolean validation) {

	if (!validation) {
	    choiseBox.setStyle("-fx-border-color: red ; -fx-border-width: 1px;");
	    inputLabel.setTextFill(Color.RED);

	} else {
	    choiseBox.setStyle(null);
	    inputLabel.setTextFill(Color.BLACK);
	}
    }

    public static boolean isCep(TextField inputTextField, Label inputLabel, String validationText) {
	boolean isNumeric = true;

	if (inputTextField.getText().length() == 0) {
	    isNumeric = false;
	    showDinamico(inputTextField, inputLabel, isNumeric);

	} else if (!inputTextField.getText().matches("[0-9]+")) {
	    isNumeric = false;
	    inputLabel.setText(validationText);
	    showDinamico(inputTextField, inputLabel, isNumeric);

	} else {
	    isNumeric = true;
	    inputLabel.setText("CEP");
	    showDinamico(inputTextField, inputLabel, isNumeric);
	}

	return isNumeric;
    }

    // Método que valida o campo da identidade
    public static boolean isCPF(TextField inputTextField, Label inputLabel, String validationText) {
	boolean isCPF = true;

	if (inputTextField.getText().length() == 0) {
	    isCPF = false;
	    showDinamico(inputTextField, inputLabel, isCPF);

	} else if (!inputTextField.getText().matches("[0-9]+")) {
	    isCPF = false;
	    inputLabel.setText(validationText);
	    showDinamico(inputTextField, inputLabel, isCPF);

	} else {
	    isCPF = true;
	    inputLabel.setText("CPF");
	    showDinamico(inputTextField, inputLabel, isCPF);
	}

	return isCPF;
    }

    public static boolean isStringValid(TextField inputTextField, Label inputLabel, String validationText,
	    String fieldName) {

	boolean isString = true;

	if (inputTextField.getText().length() == 0) {
	    isString = false;
	    showDinamico(inputTextField, inputLabel, isString);

	} else if (!inputTextField.getText().matches("[a-z A-Z]+")) {
	    isString = false;
	    inputLabel.setText(validationText);
	    showDinamico(inputTextField, inputLabel, isString);

	} else {
	    isString = true;
	    inputLabel.setText(fieldName);
	    showDinamico(inputTextField, inputLabel, isString);
	}

	return isString;

    }

    public static boolean isEstado(ChoiceBox<String> choiseEstado, Label labelEstado, String string) {
	boolean isEstadoInformado = true;
	if (choiseEstado.getValue() == null) {
	    isEstadoInformado = false;
	    showDinamico(choiseEstado, labelEstado, isEstadoInformado);
	} else {
	    isEstadoInformado = true;
	    labelEstado.setText("Estado");
	    showDinamico(choiseEstado, labelEstado, isEstadoInformado);
	}

	return isEstadoInformado;
    }

//    public static boolean isDataInformada(DatePicker datePicker, Label inputLabel, String fieldName) {
//	boolean isDatePickerInformado = true;
//	if (datePicker.getValue() == null) {
//	    isDatePickerInformado = false;
//	    showDinamico(datePicker, inputLabel, isDatePickerInformado);
////	    datePicker.setStyle(ERROR_CSS);
//	} else {
//	    isDatePickerInformado = true;
//	    labelEstado.setText(fieldName);
//	    showDinamico(datePicker, inputLabel, isDatePickerInformado);
//	}
//    }

//    private static void showDinamico(DatePicker datePicker, Label inputLabel, String validateText, String fieldName) {
//	boolean isDate = true;
//	if (datePicker.getValue() == null) {
//	    isDate = false;
//	    showDinamico(datePicker, inputLabel, isDate);
//
//	} else if (!datePicker.getText().matches("[0-9]+")) {
//	    isDate = false;
//	    inputLabel.setText(validationText);
//	    showDinamico(inputTextField, inputLabel, isDate);
//
//	} else {
//	    isDate = true;
//	    inputLabel.setText(fieldName);
//	    showDinamico(inputTextField, inputLabel, isDate);
//	}
//
//	return isDate;
//
//    }

    public static boolean isIntegerValid(TextField inputTextField, Label inputLabel, String validationText,
	    String fieldName) {
	boolean isNumeric = true;

	if (inputTextField.getText().length() == 0) {
	    isNumeric = false;
	    showDinamico(inputTextField, inputLabel, isNumeric);

	} else if (!inputTextField.getText().matches("[0-9]+")) {
	    isNumeric = false;
	    inputLabel.setText(validationText);
	    showDinamico(inputTextField, inputLabel, isNumeric);

	} else {
	    isNumeric = true;
	    inputLabel.setText(fieldName);
	    showDinamico(inputTextField, inputLabel, isNumeric);
	}

	return isNumeric;

    }

}
