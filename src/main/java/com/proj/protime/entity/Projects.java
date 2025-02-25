package com.proj.protime.entity;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.validation.constraints.NotBlank;

import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.proj.protime.entity.enums.ProjectPriority;
import com.proj.protime.entity.enums.ProjectStatus;

@Entity
@Table(name = "projeto")
public class Projects implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@NotBlank
	@Column(name = "nome" ,nullable = false)
	private String name;
	
	@NotBlank
	@Column(name = "descricao", nullable = false)
	private String description;

	@NotBlank
	@JsonFormat(pattern = "dd/MM/yyyy HH:mm:ss")
	@Column(name = "data_inicio")
	private LocalDateTime startDate;

	@NotBlank
	@JsonFormat(pattern = "dd/MM/yyyy HH:mm:ss")
	@Column(name = "data_fim")
	private LocalDateTime data_fim;

	@NotBlank
	private ProjectStatus status;
	
	// TODO Verificar qual a relacao, se e 1:1 ou N:1
	@ManyToOne
	@JoinColumn(name = "id_usuario_responsavel", referencedColumnName = "id", nullable = false)
	private Users idResponsableUser;
	
	@JsonFormat(pattern = "dd/MM/yyyy HH:mm:ss")
	@CreationTimestamp
	@Column(name = "data_criacao")
	private LocalDateTime creationDate;
	
	@NotBlank
	@Column(name = "prioridade", nullable = false)
	private ProjectPriority priority;
	
	public Projects() {
		// TODO Auto-generated constructor stub
	}

	public Projects(String name, String description, LocalDateTime startDate,
					LocalDateTime data_fim, ProjectStatus status, Users idResponsableUser,
					ProjectPriority priority) {
		super();
		this.name = name;
		this.description = description;
		this.startDate = startDate;
		this.data_fim = data_fim;
		this.status = status;
		this.idResponsableUser = idResponsableUser;
		this.priority = priority;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public LocalDateTime getStartDate() {
		return startDate;
	}

	public void setStartDate(LocalDateTime startDate) {
		this.startDate = startDate;
	}

	public LocalDateTime getData_fim() {
		return data_fim;
	}

	public void setData_fim(LocalDateTime data_fim) {
		this.data_fim = data_fim;
	}

	public ProjectStatus getStatus() {
		return status;
	}

	public void setStatus(ProjectStatus status) {
		this.status = status;
	}

	public Users getIdResponsableUser() {
		return idResponsableUser;
	}

	public void setIdResponsableUser(Users idResponsableUser) {
		this.idResponsableUser = idResponsableUser;
	}

	public LocalDateTime getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(LocalDateTime creationDate) {
		this.creationDate = creationDate;
	}

	public ProjectPriority getPriority() {
		return priority;
	}

	public void setPriority(ProjectPriority priority) {
		this.priority = priority;
	}
	
}
