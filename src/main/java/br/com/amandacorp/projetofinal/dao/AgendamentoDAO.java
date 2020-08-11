package br.com.amandacorp.projetofinal.dao;

import org.springframework.data.repository.CrudRepository;

import br.com.amandacorp.projetofinal.model.Agendamento;

public interface AgendamentoDAO extends CrudRepository<Agendamento, Integer> {

}
