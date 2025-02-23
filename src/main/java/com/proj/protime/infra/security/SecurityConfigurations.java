package com.proj.protime.infra.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import com.proj.protime.entity.enums.ProfileUser;

@Configuration
@EnableWebSecurity
public class SecurityConfigurations {
	
	//Configuração para liberação de autenticação (Não armazena nada, apenas passa o token)
	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception{
		return httpSecurity
				.csrf(csrf -> csrf.disable())
				.sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
				.authorizeHttpRequests(authorize -> authorize						
						.requestMatchers("/swagger-ui/**", "/v3/api-docs/**").permitAll() // SWAGGER
						.requestMatchers(HttpMethod.POST, "/auth/login").permitAll()
						.requestMatchers(HttpMethod.POST, "/auth/register").permitAll()
						.requestMatchers(HttpMethod.GET, "/auth/teste").permitAll()
						.requestMatchers(HttpMethod.POST, "/register").hasRole(ProfileUser.ADMIN.getProfile())
						.anyRequest().authenticated()
				)
				.build();
	}
	
	// pegar a instancia
	@Bean
	public AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration) throws Exception {
		return authenticationConfiguration.getAuthenticationManager();
	}
	
	// criptografa senha antes de enviar pro banco
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
}
