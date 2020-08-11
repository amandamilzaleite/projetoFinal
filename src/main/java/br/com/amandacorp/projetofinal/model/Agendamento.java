package br.com.amandacorp.projetofinal.model;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name ="itmn032_agendamento")
public class Agendamento {
	

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="num_seq")
	private int id;
	
	@Column(name="nome_cli", length = 100)
	private String nomeCliente;
	
	@Column(name="email_cli", length = 100)
	private String emailCliente;
	
	@Column(name="celular_cli", length = 20)
	private String celularCliente;
	
	@Column(name="data_agendamento")
	@Temporal(TemporalType.DATE)
	@JsonFormat(pattern="dd/MM/yyyy", shape=JsonFormat.Shape.STRING)
	private Date dataAgendamento;
	
	@Column(name="hora_agendamento")
	@Temporal(TemporalType.TIME)
	@JsonFormat(pattern="HH:mm", shape=JsonFormat.Shape.STRING)
	private Date horaAgendamento;
	
	@Column(name="observacao", length = 255)
	private String observacao;
	
	@ManyToOne
	@JoinColumn(name="id_agencia")  // aqui eu "forço" o nome do campo de junção
	@JsonIgnoreProperties("listaAgendamentos")
	private Agencia agencia;

}
