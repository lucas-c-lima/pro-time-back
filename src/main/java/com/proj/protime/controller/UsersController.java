package com.proj.protime.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.proj.protime.entity.Users;
import com.proj.protime.repository.UsersRepository;
import com.proj.protime.service.UsersService;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/users")
public class UsersController {

	@Autowired
	private UsersService usersService;

	@GetMapping
	public ResponseEntity<List<Users>> getAllUsers(){
		List<Users> users = usersService.getAllUsers();
		return ResponseEntity.ok().body(users);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Users> getUserById(@PathVariable Integer id){
		Users user = usersService.getUserById(id);
		return ResponseEntity.ok().body(user);
	}
	
//	@PostMapping("/add-user")
//	public ResponseEntity<Users> createUser(@RequestBody Users user){
//		Users newUser = usersService.createUser(user);
//		return ResponseEntity.status(HttpStatus.CREATED).body(newUser);
//	}
}
