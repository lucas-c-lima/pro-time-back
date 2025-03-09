package com.proj.protime.service;

import java.util.List;

import com.proj.protime.entity.dto.users.UsersDTO;
import com.proj.protime.entity.dto.users.UsersDTOPut;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public interface UsersService {
	
	List<UsersDTO> getAllUsers();

	UsersDTO findUserById(Integer id);

	List<UsersDTO> findUserByName(String value);

	UsersDTO updateUser(Integer id, UsersDTOPut user);

	void deleteUser(Integer id);
}
