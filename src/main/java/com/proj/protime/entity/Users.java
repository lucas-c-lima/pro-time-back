package com.proj.protime.entity;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Collection;
import java.util.List;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

import org.hibernate.annotations.CreationTimestamp;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.proj.protime.entities.enums.ProfileUser;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Table(name = "usuarios")
@Entity
@Getter
@NoArgsConstructor
@AllArgsConstructor
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

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		if (this.profile == ProfileUser.ADMIN) return List.of(new SimpleGrantedAuthority("P_ADMIN"), new SimpleGrantedAuthority("P_USUARIO"));
		else return List.of(new SimpleGrantedAuthority("P_USUARIO"));
	}

	@Override
	public String getPassword() {
		return password;
	}

	@Override
	public String getUsername() {
		return email;
	}
	
}
