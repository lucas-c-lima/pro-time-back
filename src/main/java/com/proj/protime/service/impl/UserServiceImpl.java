package com.proj.protime.service.impl;

import java.util.List;

import com.proj.protime.entity.dto.UsersDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.proj.protime.entity.Users;
import com.proj.protime.repository.UsersRepository;
import com.proj.protime.service.UsersService;

@Service
public class UserServiceImpl implements UsersService{

	@Autowired
	private UsersRepository usersRepository;

	@Override
	public List<UsersDTO> getAllUsers() {
		return usersRepository.findAll().stream().map(UsersDTO::new).toList();
	}
	
	@Override
	public UsersDTO findUserById(Integer id) {
		Users user = usersRepository.findById(id).orElseThrow(() -> new RuntimeException("User not found"));
		return new UsersDTO(user);
	}

	@Override
	public List<UsersDTO> findUserByName(String valor) {
		return usersRepository.findUserByNameContaining(valor).stream().map(UsersDTO::new).toList();
	}


}
