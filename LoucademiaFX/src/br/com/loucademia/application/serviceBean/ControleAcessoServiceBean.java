package br.com.loucademia.application.serviceBean;

import java.io.Serializable;
import java.sql.SQLException;

import br.com.loucademia.application.util.ValidationException;
import br.com.loucademia.domain.acesso.TipoAcesso;

public class ControleAcessoServiceBean implements Serializable {

//    private static final long serialVersionUID = 1L;
//
    private AcessoServiceBean acessoService;

    private Integer id;
    private String cpf;

    public String registrarAcesso() {

		TipoAcesso tipoAcesso = null;
	
		try {
		    tipoAcesso = acessoService.registrarAcesso(id, cpf);
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

    public Integer getId() {
    	return id;
    }

    public void setId(Integer id) {
    	this.id = id;
    }

    public String getCpf() {
    	return cpf;
    }

    public void setCpf(String cpf) {
    	this.cpf = cpf;
    }

}
