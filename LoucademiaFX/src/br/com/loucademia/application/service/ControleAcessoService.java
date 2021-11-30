package br.com.loucademia.application.service;

import br.com.loucademia.domain.acesso.TipoAcesso;

public interface ControleAcessoService {

    TipoAcesso registrarAcesso(Integer id, String cpf);

}
