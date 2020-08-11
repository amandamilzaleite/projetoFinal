package br.com.amandacorp.projetofinal.dao;

import org.springframework.data.repository.CrudRepository;

import br.com.amandacorp.projetofinal.model.Agencia;

public interface AgenciaDAO extends CrudRepository<Agencia, Integer> {
	public Agencia findByNome(String nome);

}
