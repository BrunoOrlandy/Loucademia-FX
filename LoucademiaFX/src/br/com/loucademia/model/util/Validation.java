package br.com.loucademia.model.util;

public class Validation {

    public static void assertionNotEmpty(Object obj) {

	if (obj instanceof String) {
	    String s = (String) obj;

	    if (StringUtils.isEmpty(s)) {
		throw new ValidationException("O texto não pode ser nulo");
	    }
	}

	if (obj == null) {
	    throw new ValidationException("O valor não pode ser nulo");
	}
    }
}
