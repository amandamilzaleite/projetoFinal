package br.com.amandacorp.projetofinal.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.amandacorp.projetofinal.dao.AgendamentoDAO;
import br.com.amandacorp.projetofinal.model.Agendamento;

@RestController
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

}
