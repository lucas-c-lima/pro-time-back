package com.proj.protime.entity;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.validation.constraints.NotBlank;

import org.hibernate.annotations.CreationTimestamp;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.proj.protime.entities.enums.PrioridadeProjeto;
import com.proj.protime.entities.enums.StatusProjeto;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "projeto")
public class Projeto implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@NotBlank(message = "O nome e obrigatorio")
	private String nome;
	
	@NotBlank
	private String descricao;
	
	@NotBlank(message = "A data de inicio e obrigatoria")
	@JsonFormat(pattern = "dd/MM/yyyy HH:mm:ss")
	private LocalDateTime data_inicio;
	
	@NotBlank(message = "A data de finalizacao e obrigatoria")
	@JsonFormat(pattern = "dd/MM/yyyy HH:mm:ss")
	private LocalDateTime data_fim;
	
	@NotBlank(message = "O status e obrigatorio")
	private StatusProjeto status;
	
	// TODO Verificar qual a relacao, se e 1:1 ou N:1
	@ManyToOne
	@JoinColumn(name = "id_usuario_responsavel", referencedColumnName = "id", nullable = false)
	private Users id_usuario_responsavel;
	
	@JsonFormat(pattern = "dd/MM/yyyy HH:mm:ss")
	@CreationTimestamp
	private LocalDateTime data_criacao;
	
	@NotBlank(message = "A prioridade e obrigatorio")
	private PrioridadeProjeto prioridade;
	
	public Projeto() {
		// TODO Auto-generated constructor stub
	}

	public Projeto(String nome, String descricao, LocalDateTime data_inicio,
			LocalDateTime data_fim, StatusProjeto status, Users id_usuario_responsavel,
			PrioridadeProjeto prioridade) {
		super();
		this.nome = nome;
		this.descricao = descricao;
		this.data_inicio = data_inicio;
		this.data_fim = data_fim;
		this.status = status;
		this.id_usuario_responsavel = id_usuario_responsavel;
		this.prioridade = prioridade;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public LocalDateTime getData_inicio() {
		return data_inicio;
	}

	public void setData_inicio(LocalDateTime data_inicio) {
		this.data_inicio = data_inicio;
	}

	public LocalDateTime getData_fim() {
		return data_fim;
	}

	public void setData_fim(LocalDateTime data_fim) {
		this.data_fim = data_fim;
	}

	public StatusProjeto getStatus() {
		return status;
	}

	public void setStatus(StatusProjeto status) {
		this.status = status;
	}

	public Users getId_usuario_responsavel() {
		return id_usuario_responsavel;
	}

	public void setId_usuario_responsavel(Users id_usuario_responsavel) {
		this.id_usuario_responsavel = id_usuario_responsavel;
	}

	public LocalDateTime getData_criacao() {
		return data_criacao;
	}

	public void setData_criacao(LocalDateTime data_criacao) {
		this.data_criacao = data_criacao;
	}

	public PrioridadeProjeto getPrioridade() {
		return prioridade;
	}

	public void setPrioridade(PrioridadeProjeto prioridade) {
		this.prioridade = prioridade;
	}
	
}
