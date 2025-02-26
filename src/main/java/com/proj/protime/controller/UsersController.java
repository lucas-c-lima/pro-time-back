package com.proj.protime.controller;

import java.util.List;

import com.proj.protime.entity.dto.users.UsersDTO;
import com.proj.protime.entity.dto.users.UsersDTOPut;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.proj.protime.service.UsersService;


@RestController
@RequestMapping("/users")
public class UsersController {

	@Autowired
	private UsersService usersService;

	@GetMapping
	public ResponseEntity<List<UsersDTO>> getAllUsers(){
		List<UsersDTO> users = usersService.getAllUsers();
		return ResponseEntity.ok().body(users);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<UsersDTO> findUserById(@PathVariable Integer id){
		UsersDTO user = usersService.findUserById(id);
		return ResponseEntity.ok().body(user);
	}

	@GetMapping("/name")
	public ResponseEntity<List<UsersDTO>> findUserByName(@RequestParam String value){
		List<UsersDTO> user = usersService.findUserByName(value);
		return ResponseEntity.ok().body(user);
	}

	// TODO AO FAZER A ALTERAÇÃO, COLOCAR A SENHA ENCRIPTADA
	@PutMapping("/{id}")
	public ResponseEntity<UsersDTO> updateUser(@PathVariable Integer id, @Valid @RequestBody UsersDTOPut user){
		return ResponseEntity.ok(usersService.updateUser(id, user));
	}

	// TODO implementar soft delete!!!!
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteUser(@PathVariable Integer id){
		usersService.deleteUser(id);
		return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
	}

}
