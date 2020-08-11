package br.com.amandacorp.projetofinal.dao;

import org.springframework.data.repository.CrudRepository;

import br.com.amandacorp.projetofinal.model.Agencia;
import br.com.amandacorp.projetofinal.model.Usuario;

public interface AgenciaDAO extends CrudRepository<Usuario, Integer> {
	public Agencia findByNome(String nome);

}
