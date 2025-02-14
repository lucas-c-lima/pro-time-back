package com.proj.protime.entities;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.validation.constraints.NotBlank;

import org.hibernate.annotations.CreationTimestamp;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.proj.protime.entities.enums.StatusAtividade;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "atividades")
public class Atividade implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@OneToOne
	@JoinColumn(name = "id_projeto", referencedColumnName = "id", nullable = false)
	private Projeto id_projeto;
	
	@NotBlank(message = "O nome e obrigatorio")
	private String nome;
	
	private String descricao;
	
	@NotBlank(message = "A data de inicio e obrigatoria")
	@JsonFormat(pattern = "dd/MM/yyyy HH:mm:ss")
	private LocalDateTime data_inicio;
	
	@NotBlank(message = "A data de finalizacao e obrigatoria")
	@JsonFormat(pattern = "dd/MM/yyyy HH:mm:ss")
	private LocalDateTime data_fim;
	
	@NotBlank(message = "O status e obrigatorio")
	private StatusAtividade status;
	
	@ManyToOne
	@JoinColumn(name = "id_usuario_responsavel", referencedColumnName = "id", nullable = false)
	private Usuario id_usuario_responsavel;
	
	@JsonFormat(pattern = "dd/MM/yyyy HH:mm:ss")
	@CreationTimestamp
	private LocalDateTime data_criacao;
	
	public Atividade() {
		// TODO Auto-generated constructor stub
	}

	public Atividade(Projeto id_projeto, String nome, String descricao,
			LocalDateTime data_inicio, LocalDateTime data_fim, StatusAtividade status, 
			Usuario id_usuario_responsavel, LocalDateTime data_criacao) {
		super();
		this.id_projeto = id_projeto;
		this.nome = nome;
		this.descricao = descricao;
		this.data_inicio = data_inicio;
		this.data_fim = data_fim;
		this.status = status;
		this.id_usuario_responsavel = id_usuario_responsavel;
		this.data_criacao = data_criacao;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Projeto getId_projeto() {
		return id_projeto;
	}

	public void setId_projeto(Projeto id_projeto) {
		this.id_projeto = id_projeto;
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

	public StatusAtividade getStatus() {
		return status;
	}

	public void setStatus(StatusAtividade status) {
		this.status = status;
	}

	public Usuario getId_usuario_responsavel() {
		return id_usuario_responsavel;
	}

	public void setId_usuario_responsavel(Usuario id_usuario_responsavel) {
		this.id_usuario_responsavel = id_usuario_responsavel;
	}

	public LocalDateTime getData_criacao() {
		return data_criacao;
	}

	public void setData_criacao(LocalDateTime data_criacao) {
		this.data_criacao = data_criacao;
	}
	
	
	
}
