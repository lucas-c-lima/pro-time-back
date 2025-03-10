package com.proj.protime.controller;

import com.proj.protime.entity.dto.auth.LoginResponseDTO;
import com.proj.protime.entity.dto.users.UsersDTO;
import com.proj.protime.infra.security.TokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.proj.protime.entity.Users;
import com.proj.protime.entity.dto.auth.AuthenticationDTO;
import com.proj.protime.entity.dto.auth.RegisterDTO;
import com.proj.protime.repository.UsersRepository;

import jakarta.validation.Valid;

import java.time.LocalDate;
import java.time.LocalDateTime;

@RestController
@RequestMapping("/auth")
public class AuthenticationController {

	@Autowired
	private AuthenticationManager authenticationManager;
	
	@Autowired
	private UsersRepository usersRepository;

	@Autowired
	private TokenService tokenService;

	// TODO FAZER ELE ALTERAR O ULTIMO LOGIN QUANDO LOGAR
	@PostMapping("/login")
	public ResponseEntity<LoginResponseDTO> login(
			@RequestBody @Valid AuthenticationDTO data
	) {
		var userPassword = new UsernamePasswordAuthenticationToken(data.email(), data.password()); // cria um token com email e senha

		var auth = this.authenticationManager.authenticate(userPassword); // autentica o token

		var user = (Users) auth.getPrincipal(); // Logica para alterar o lastlogin
		user.setLastLogin(LocalDateTime.now());
		usersRepository.save(user);

		var token = tokenService.generateToken((Users) auth.getPrincipal()); // gera um token

		return ResponseEntity.ok(new LoginResponseDTO(token)); // retorna o token
	}
		
	@PostMapping("/register")
	public ResponseEntity<UsersDTO> register(
			@RequestBody @Valid RegisterDTO data
			) {
		if(this.usersRepository.findByEmail(data.email()) != null) {
			return ResponseEntity.badRequest().build();
		}


		String encryptedPassword = new BCryptPasswordEncoder().encode(data.password());
		Users newUser = new Users(data.name(), data.email(), encryptedPassword, data.profile());
		
		this.usersRepository.save(newUser);

		return ResponseEntity.ok(new UsersDTO(newUser));
	}

}
