package com.proj.protime.entity;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.validation.constraints.NotBlank;

import org.hibernate.annotations.CreationTimestamp;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "lancamentos_horas")
public class LancamentoHora implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@OneToOne
	@JoinColumn(name = "id_atividade", referencedColumnName = "id", nullable = false)
	private Activities id_activities;
	
	@OneToOne
	@JoinColumn(name = "id_usuario", referencedColumnName = "id", nullable = false)
	private Users id_usuario;

	@NotBlank
	private String descricao;
	
	@NotBlank(message = "A data de inicio e obrigatoria")
	@JsonFormat(pattern = "dd/MM/yyyy HH:mm:ss")
	private LocalDateTime data_inicio;
	
	@NotBlank(message = "A data de finalizacao e obrigatoria")
	@JsonFormat(pattern = "dd/MM/yyyy HH:mm:ss")
	private LocalDateTime data_fim;
	
	@JsonFormat(pattern = "dd/MM/yyyy HH:mm:ss")
	@CreationTimestamp
	private LocalDateTime data_registro;
	
	public LancamentoHora() {
		// TODO Auto-generated constructor stub
	}

	public LancamentoHora(Activities id_activities, Users id_usuario, String descricao,
						  LocalDateTime data_inicio, LocalDateTime data_fim, LocalDateTime data_registro) {
		super();
		this.id_activities = id_activities;
		this.id_usuario = id_usuario;
		this.descricao = descricao;
		this.data_inicio = data_inicio;
		this.data_fim = data_fim;
		this.data_registro = data_registro;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Activities getId_atividade() {
		return id_activities;
	}

	public void setId_atividade(Activities id_activities) {
		this.id_activities = id_activities;
	}

	public Users getId_usuario() {
		return id_usuario;
	}

	public void setId_usuario(Users id_usuario) {
		this.id_usuario = id_usuario;
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

	public LocalDateTime getData_registro() {
		return data_registro;
	}

	public void setData_registro(LocalDateTime data_registro) {
		this.data_registro = data_registro;
	}
	
}
