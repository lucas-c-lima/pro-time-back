package com.proj.protime.entity;

import java.time.LocalDateTime;
import java.util.Collection;
import java.util.List;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.proj.protime.entity.enums.ProfileUser;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Table(name = "usuarios")
@Entity
@EqualsAndHashCode(of = "id")
public class Users implements UserDetails{
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@NotBlank
	@Column(name = "nome", nullable = false)
	private String name;
	
	@NotBlank
	@Email(message = "The provided email is invalid")
	@Column(nullable = false)
	private String email;
	
	@NotBlank
	@Column(name = "senha", nullable = false)
	private String password;
	
	@NotBlank
	@Column(name = "perfil", nullable = false)
	private ProfileUser profile;
	
	@JsonFormat(pattern = "dd/MM/yyyy HH:mm:ss")
	@CreationTimestamp
	@Column(name = "data_criacao")
	private LocalDateTime creationDate;
 
	@JsonFormat(pattern = "dd/MM/yyyy HH:mm:ss")
	@Column(name = "ultimo_login")
	private LocalDateTime lastLogin;

	public Users(@NotBlank String name, @NotBlank String email, @NotBlank String password, ProfileUser profile) {
		this.name = name;
		this.email = email;
		this.password = password;
		this.profile = profile;
	}
	
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		if (this.profile == ProfileUser.ADMIN) {
			return List.of(new SimpleGrantedAuthority(ProfileUser.ADMIN.name()),
					new SimpleGrantedAuthority(ProfileUser.USUARIO.name()));
		}
		else return List.of(new SimpleGrantedAuthority(ProfileUser.USUARIO.name()));
	}

	@Override
	public String getPassword() {
		return password;
	}

	@Override
	public String getUsername() {
		return email;
	}

	public Users() {
	}

	public Users(Integer id, String name, String email, String password, ProfileUser profile, LocalDateTime creationDate, LocalDateTime lastLogin) {
		this.id = id;
		this.name = name;
		this.email = email;
		this.password = password;
		this.profile = profile;
		this.creationDate = creationDate;
		this.lastLogin = lastLogin;
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

	public void setPassword(String password) {
		this.password = password;
	}

	public ProfileUser getProfile() {
		return profile;
	}

	public void setProfile(ProfileUser profile) {
		this.profile = profile;
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
}
