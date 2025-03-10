package com.proj.protime.service.impl;

import java.util.List;

import com.proj.protime.entity.dto.users.UsersDTO;
import com.proj.protime.entity.dto.users.UsersDTOPut;
import com.proj.protime.entity.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.proj.protime.entity.Users;
import com.proj.protime.repository.UsersRepository;
import com.proj.protime.service.UsersService;

@Service
public class UserServiceImpl implements UsersService{

	@Autowired
	private UsersRepository usersRepository;

	@Autowired
	private BCryptPasswordEncoder passwordEncoder;

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

		if(user.password() != null){
			user = new UsersDTOPut(
				user.name(),
				user.email(),
				passwordEncoder.encode(user.password()),
				user.profile(),
				user.deleted()
			);
		} else {
			user = new UsersDTOPut(
				user.name(),
				user.email(),
				current.getPassword(),
				user.profile(),
				user.deleted()
			);
		}

		UserMapper.INSTANCE.updateUser(current, user);

		Users saved = usersRepository.save(current);
		return UserMapper.INSTANCE.toUsersDTOPut(saved);
	}

	@Override
	public void deleteUser(Integer id) {
		Users user = usersRepository.findById(id).orElseThrow(
				() -> new RuntimeException("User not found"));
		user.setDeleted(true);
		usersRepository.save(user);
	}
}
