package br.com.loucademia.application.serviceBean;

import java.io.Serializable;
import java.sql.SQLException;

import br.com.loucademia.application.util.ValidationException;
import br.com.loucademia.domain.acesso.TipoAcesso;

public class ControleAcessoServiceBean implements Serializable {

    private static final long serialVersionUID = 1L;

    private AcessoServiceBean acessoService;

    private String matricula;
    private Integer rg;

    public String registrarAcesso() {

	TipoAcesso tipoAcesso = null;

	try {
	    tipoAcesso = acessoService.registrarAcesso(matricula, rg);
	} catch (ValidationException e) {
	    e.printStackTrace();
	    return null;

	} catch (SQLException e) {
	    e.printStackTrace();
	}

	String msg;
	if (tipoAcesso == TipoAcesso.ENTRADA) {
	    msg = "ENTRADA registrada";
	} else {
	    msg = "Dados de registro de acesso inconsistentes";
	}

	return msg;
    }

    public String getMatricula() {
	return matricula;
    }

    public void setMatricula(String matricula) {
	this.matricula = matricula;
    }

    public Integer getRg() {
	return rg;
    }

    public void setRg(Integer rg) {
	this.rg = rg;
    }
}
