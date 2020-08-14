package br.com.amandacorp.projetofinal.controller;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.amandacorp.projetofinal.dao.AgendamentoDAO;
import br.com.amandacorp.projetofinal.model.Agencia;
import br.com.amandacorp.projetofinal.model.Agendamento;

@RestController
@CrossOrigin("*")
public class AgendamentoController {
	
	@Autowired
	AgendamentoDAO dao;
	
	@PostMapping("/agendamentos/novo")
	public ResponseEntity<Agendamento> inserirNovoAgendamento(@RequestBody Agendamento novo){
		try {
			dao.save(novo);
			return ResponseEntity.status(201).body(novo);
		}
		catch(Exception ex) {
			return ResponseEntity.status(400).build(); // requisicao errada
		}
	}
	
	@GetMapping("/agendamentos/todos")
	public ArrayList<Agendamento> recuperarTodos(){
		ArrayList<Agendamento> lista;
		lista = (ArrayList<Agendamento>)dao.findAll();
		return lista;
	}
	
	// combinacao 4
		@GetMapping("/agendamentos/filtrarporcliente")
		public ArrayList<Agendamento> filtrarPorCliente(@RequestParam(name="nomecli") String nome){
			System.out.println("nome do cliente = "+nome);
			return dao.findAllByNomeClienteContaining(nome);
		}
		
		// combinacao 1
		@GetMapping("/agendamentos/filtrarporagencia")
		public ArrayList<Agendamento> filtrarPorAgencia(@RequestParam(name="agencia") int agencia){
			System.out.println("agencia = "+agencia);
			Agencia ag = new Agencia();
			ag.setId(agencia);
			return dao.findAllByAgencia(ag);
		}
		
		
		@GetMapping("/agendamentos/filtrarpordata")
		public ArrayList<Agendamento> filtrarPorData(@RequestParam(name="data") String dataAgendamento){
			DateTimeFormatter fmt = DateTimeFormatter.ofPattern("yyyy-MM-dd");
			LocalDate data = LocalDate.parse(dataAgendamento, fmt);	
			return dao.findAllByDataAgendamento(data);
		}
		
		@GetMapping("/agendamentos/filtrarporAgenciaData")
		public ArrayList<Agendamento> filtrarporAgenciaData(@RequestParam(name="agencia") int agencia, @RequestParam(name="data") String dataAgendamento ){
			Agencia ag = new Agencia();
			ag.setId(agencia);
			DateTimeFormatter fmt = DateTimeFormatter.ofPattern("yyyy-MM-dd");
			LocalDate data = LocalDate.parse(dataAgendamento, fmt);	
			return dao.findAllByAgenciaAndDataAgendamento(ag, data);
		}
		
		@GetMapping("/agendamentos/filtrarporAgenciaCliente")
		public ArrayList<Agendamento> filtrarporAgenciaCliente(@RequestParam(name="agencia") int agencia, @RequestParam(name="nomecli") String nome){
			Agencia ag = new Agencia();
			ag.setId(agencia);
			return dao.findAllByAgenciaAndNomeClienteContaining(ag, nome);
		}
		
		@GetMapping("/agendamentos/filtrarpordataCliente")
		public ArrayList<Agendamento> filtrarPorDataCliente(@RequestParam(name="data") String dataAgendamento, @RequestParam(name="nomecli") String nome){
			DateTimeFormatter fmt = DateTimeFormatter.ofPattern("yyyy-MM-dd");
			LocalDate data = LocalDate.parse(dataAgendamento, fmt);		
			return dao.findAllByDataAgendamentoAndNomeClienteContaining(data, nome);
		}
		
		@GetMapping("/agendamentos/filtrarporagenciaDataCliente")
		public ArrayList<Agendamento> filtrarPorAgenciaDataCliente(@RequestParam(name="agencia") int agencia, @RequestParam(name="data") String dataAgendamento, @RequestParam(name="nomecli") String nome){
			Agencia ag = new Agencia();
			ag.setId(agencia);
			DateTimeFormatter fmt = DateTimeFormatter.ofPattern("yyyy-MM-dd");
			LocalDate data = LocalDate.parse(dataAgendamento, fmt);		
			return dao.findAllByAgenciaAndDataAgendamentoAndNomeClienteContaining(ag, data, nome);
		}
		
		
	

}
