package com.proj.protime.infra.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfigurations {
	
	//Configuração para liberação de autenticação (Não armazena nada, apenas passa o token)
	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception{
		return httpSecurity
				.csrf(csrf -> csrf.disable())
				.sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
				// Necessário token e ser admin para acessar add-user
				.authorizeHttpRequests(authorize -> authorize
						.requestMatchers(HttpMethod.POST, "/add-user").hasRole("ADMIN")
						.anyRequest().authenticated()
				)
				.build();
	}
}
