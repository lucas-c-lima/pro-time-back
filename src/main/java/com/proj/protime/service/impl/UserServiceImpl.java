package com.proj.protime.service.impl;

import java.util.List;

import com.proj.protime.entity.dto.users.UsersDTO;
import com.proj.protime.entity.dto.users.UsersDTOPut;
import com.proj.protime.entity.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.proj.protime.entity.Users;
import com.proj.protime.repository.UsersRepository;
import com.proj.protime.service.UsersService;

@Service
public class UserServiceImpl implements UsersService{

	@Autowired
	private UsersRepository usersRepository;

	private UserMapper userMapper;

	@Override
	public List<UsersDTO> getAllUsers() {
		return usersRepository.findAll().stream().map(UsersDTO::new).toList();
	}
	
	@Override
	public UsersDTO findUserById(Integer id) {
		Users user = usersRepository.findById(id).orElseThrow(
				() -> new RuntimeException("User not found"));
		return new UsersDTO(user);
	}

	@Override
	public List<UsersDTO> findUserByName(String value) {
		return usersRepository.findUserByNameContaining(value).stream().map(UsersDTO::new).toList();
	}

	@Override
	public UsersDTO updateUser(Integer id, UsersDTOPut user) {
		Users current = usersRepository.findById(id).orElseThrow(
				() -> new RuntimeException("User not found"));

		UserMapper.INSTANCE.updateUser(current, user);

		Users saved = usersRepository.save(current);
		return UserMapper.INSTANCE.toUsersDTOPut(saved);
	}

	@Override
	public ResponseEntity<Void> deleteUser(Integer id) {
		return usersRepository.findById(id)
			.map(userFound -> {
				usersRepository.deleteById(id);
				return ResponseEntity.noContent().<Void>build();
			}).orElseThrow(() -> new RuntimeException("User not found"));
	}
}
