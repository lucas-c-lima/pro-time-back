package com.proj.protime.entity;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.validation.constraints.NotBlank;

import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.proj.protime.entity.enums.ActivityStatus;

@Entity
@Table(name = "atividades")
public class Activities implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@OneToOne
	@JoinColumn(name = "id_projeto", referencedColumnName = "id", nullable = false)
	private Projects id_projects;
	
	@NotBlank
	@Column(name = "nome" ,nullable = false)
	private String name;

	@Column(name = "descricao", nullable = false)
	private String description;
	
	@NotBlank
	@JsonFormat(pattern = "dd/MM/yyyy HH:mm:ss")
	@Column(name = "data_inicio")
	private LocalDateTime startDate;
	
	@NotBlank
	@JsonFormat(pattern = "dd/MM/yyyy HH:mm:ss")
	@Column(name = "data_fim")
	private LocalDateTime endDate;
	
	@NotBlank
	private ActivityStatus status;
	
	@ManyToOne
	@JoinColumn(name = "id_usuario_responsavel", referencedColumnName = "id", nullable = false)
	private Users idResponsableUser;
	
	@JsonFormat(pattern = "dd/MM/yyyy HH:mm:ss")
	@CreationTimestamp
	@Column(name = "data_criacao")
	private LocalDateTime creationDate;
	
	public Activities() {
		// TODO Auto-generated constructor stub
	}

	public Activities( String name, String description,
					  LocalDateTime startDate, LocalDateTime endDate, ActivityStatus status,
					   Projects idProject,
					   Users idResponsableUser) {
		super();
		this.name = name;
		this.description = description;
		this.startDate = startDate;
		this.endDate = endDate;
		this.status = status;
		this.id_projects = idProject;
		this.idResponsableUser = idResponsableUser;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Projects getIdProjects() {
		return id_projects;
	}

	public void setIdProjects(Projects id_projects) {
		this.id_projects = id_projects;
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

	public LocalDateTime getEndDate() {
		return endDate;
	}

	public void setEndDate(LocalDateTime endDate) {
		this.endDate = endDate;
	}

	public ActivityStatus getStatus() {
		return status;
	}

	public void setStatus(ActivityStatus status) {
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
	
	
	
}
