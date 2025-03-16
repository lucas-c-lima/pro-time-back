package com.proj.protime.entity;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.validation.constraints.NotBlank;

import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name = "lancamentos_horas")
public class HoursEntry implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@ManyToOne
	@JoinColumn(name = "id_atividade", referencedColumnName = "id", nullable = false)
	private Activities idActivity;
	
	@ManyToOne
	@JoinColumn(name = "id_usuario", referencedColumnName = "id", nullable = false)
	private Users idUsers;

	@Column(name = "descricao" ,nullable = false)
	private String description;
	
	@NotBlank
	@JsonFormat(pattern = "dd/MM/yyyy HH:mm:ss")
	@Column(name = "data_inicio" ,nullable = false)
	private LocalDateTime startDate;
	
	@NotBlank
	@JsonFormat(pattern = "dd/MM/yyyy HH:mm:ss")
	@Column(name = "data_fim" ,nullable = false)
	private LocalDateTime endDate;
	
	@JsonFormat(pattern = "dd/MM/yyyy HH:mm:ss")
	@CreationTimestamp
	@Column(name = "data_registro" ,nullable = false)
	private LocalDateTime registerDate;
	
	public HoursEntry() {
		// TODO Auto-generated constructor stub
	}

	public HoursEntry(Activities idActivity, Users idUsers, String description,
					  LocalDateTime startDate, LocalDateTime endDate) {
		super();
		this.idActivity = idActivity;
		this.idUsers = idUsers;
		this.description = description;
		this.startDate = startDate;
		this.endDate = endDate;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Activities getIdActivity() {
		return idActivity;
	}

	public void setIdActivity(Activities idActivity) {
		this.idActivity = idActivity;
	}

	public Users getIdUsers() {
		return idUsers;
	}

	public void setIdUsers(Users idUsers) {
		this.idUsers = idUsers;
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

	public LocalDateTime getRegisterDate() {
		return registerDate;
	}

	public void setRegisterDate(LocalDateTime registerDate) {
		this.registerDate = registerDate;
	}
	
}
