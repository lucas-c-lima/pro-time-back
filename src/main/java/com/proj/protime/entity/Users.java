package com.proj.protime.entity;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

import org.hibernate.annotations.CreationTimestamp;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.proj.protime.entities.enums.PerfilUsuario;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "usuarios")
public class Users implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@NotBlank(message = "Name is required")
	@Column(name = "nome", nullable = false)
	private String name;
	
	@NotBlank(message = "Email is required")
	@Email(message = "The provided email is invalid")
	@Column(nullable = false)
	private String email;
	
	@NotBlank(message = "Password is required")
	@Column(name = "senha", nullable = false)
	private String password;
	
	@NotBlank(message = "Profile is required")
	@Column(name = "perfil", nullable = false)
	private PerfilUsuario profile;
	
	@JsonFormat(pattern = "dd/MM/yyyy HH:mm:ss")
	@CreationTimestamp
	@Column(name = "data_criacao")
	private LocalDateTime creationDate;

	@JsonFormat(pattern = "dd/MM/yyyy HH:mm:ss")
	@Column(name = "ultimo_login")
	private LocalDateTime lastLogin;

	public Users() {
		// TODO Auto-generated constructor stub
	}

	public Users(String name, String email, String senha, PerfilUsuario profile) {
		super();
		this.name = name;
		this.email = email;
		this.password = senha;
		this.profile = profile;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String senha) {
		this.password = senha;
	}

	public LocalDateTime getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(LocalDateTime creationDate) {
		this.creationDate = creationDate;
	}

	public LocalDateTime getLastLogin() {
		return lastLogin;
	}

	public void setLastLogin(LocalDateTime lastLogin) {
		this.lastLogin = lastLogin;
	}

	public PerfilUsuario getProfile() {
		return profile;
	}

	public void setProfile(PerfilUsuario profile) {
		this.profile = profile;
	}	
	
}
