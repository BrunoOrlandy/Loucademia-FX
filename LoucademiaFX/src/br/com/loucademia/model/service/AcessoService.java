package br.com.loucademia.model.service;

import br.com.loucademia.model.model.enums.TipoAcesso;

public interface AcessoService {

    TipoAcesso registrarAcesso(Integer id, String cpf);

    boolean existeAluno(Integer id, String cpf);
}
