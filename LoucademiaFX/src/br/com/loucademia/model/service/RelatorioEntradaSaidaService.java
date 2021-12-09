package br.com.loucademia.model.service;

import java.time.LocalDate;
import java.util.List;

import br.com.loucademia.model.model.Acesso;

public interface RelatorioEntradaSaidaService {

    List<Acesso> gerarRelatorio(Integer id, LocalDate dataInicial, LocalDate dataFinal);

}
