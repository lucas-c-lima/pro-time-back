package com.proj.protime.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.proj.protime.entity.Users;
import com.proj.protime.repository.UsersRepository;
import com.proj.protime.service.UsersService;

@Service
public class UserServiceImpl implements UsersService{

	@Autowired
	private UsersRepository usersRepository;
	
	// ------ GETs ------
	@Override
	public List<Users> getAllUsers() {
		return usersRepository.findAll();
	}
	
	@Override
	public Users getUserById(Integer id) {
		return usersRepository.findById(id).orElseThrow(() -> new RuntimeException("User not found"));
	}
	
	// ------ POSTs ------
	@Override
	public Users createUser(Users user) {
		return usersRepository.save(user);
	}
}
