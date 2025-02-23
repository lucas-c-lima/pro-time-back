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
@Getter
@Setter
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

	public Users(@NotBlank String name, @NotBlank String email, @NotBlank String password, ProfileUser profile) {
		this.name = name;
		this.email = email;
		this.password = password;
		this.profile = profile;
	}
	
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		if (this.profile == ProfileUser.ADMIN) {
			return List.of(new SimpleGrantedAuthority("ADMIN"),
					new SimpleGrantedAuthority("USUARIO"));
		}
		else return List.of(new SimpleGrantedAuthority("USUARIO"));
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
