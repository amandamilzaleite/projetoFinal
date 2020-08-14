package br.com.amandacorp.projetofinal.dao;

import java.time.LocalDate;
import java.util.ArrayList;

import org.springframework.data.repository.CrudRepository;

import br.com.amandacorp.projetofinal.model.Agencia;
import br.com.amandacorp.projetofinal.model.Agendamento;

public interface AgendamentoDAO extends CrudRepository<Agendamento, Integer> {
	
	public ArrayList<Agendamento> findAllByNomeClienteContaining(String nomeCliente);
	
	public ArrayList<Agendamento> findAllByAgencia(Agencia agencia);
	
	public ArrayList<Agendamento> findAllByAgenciaAndNomeClienteContaining(Agencia agencia, String nomeCliente);
	
	public ArrayList<Agendamento> findAllByDataAgendamento(LocalDate dataAgendamento);
	
	public ArrayList<Agendamento> findAllByAgenciaAndDataAgendamento(Agencia agencia, LocalDate dataAgendamento);
	
	public ArrayList<Agendamento> findAllByDataAgendamentoAndNomeClienteContaining(LocalDate dataAgendamento, String nomeCliente);
	
	public ArrayList<Agendamento> findAllByAgenciaAndDataAgendamentoAndNomeClienteContaining(Agencia agencia, LocalDate dataAgendamento, String nomeCliente);
	
	

}
