package com.proj.protime.controller;

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
import com.proj.protime.entity.dto.AuthenticationDTO;
import com.proj.protime.entity.dto.RegisterDTO;
import com.proj.protime.repository.UsersRepository;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/auth")
public class AuthenticationController {

	@Autowired
	private AuthenticationManager authenticationManager;
	
	@Autowired
	private UsersRepository usersRepository;
	
	@PostMapping("/login")
	public ResponseEntity<?> login(
			@RequestBody @Valid AuthenticationDTO data
	) {

		// recebe login/senha
		var userPassword = new UsernamePasswordAuthenticationToken(data.email(), data.password());

		// verifica no banco se existem
		var auth = this.authenticationManager.authenticate(userPassword);
		System.out.println(auth);
		return ResponseEntity.ok().build();
	}
		
	@PostMapping("/register")
	public ResponseEntity<?> register(
			@RequestBody @Valid RegisterDTO data
			) {
				
		if(this.usersRepository.findByEmail(data.email()) != null) {
			return ResponseEntity.badRequest().build();
		}
		
		String encryptedPassword = new BCryptPasswordEncoder().encode(data.password());
		Users newUser = new Users(data.name(), data.email(), encryptedPassword, data.profile());
		
		this.usersRepository.save(newUser);
		
//		return ResponseEntity.ok(new UsuarioDTO(newUser));
		return ResponseEntity.ok().build();
	}
	
	@GetMapping("/teste")
	public String teste() {
		return "Teste de retorno!";
	}
}
