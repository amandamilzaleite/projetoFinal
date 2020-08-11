package br.com.amandacorp.projetofinal.dao;

import org.springframework.data.repository.CrudRepository;

import br.com.amandacorp.projetofinal.model.Usuario;

public interface UsuarioDAO extends CrudRepository<Usuario, Integer>{
	public Usuario findByEmailAndSenha(String email, String senha);
	public Usuario findByEmail(String email);

}
