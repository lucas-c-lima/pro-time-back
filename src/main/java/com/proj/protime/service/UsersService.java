package com.proj.protime.service;

import java.util.List;

import com.proj.protime.entity.dto.UsersDTO;
import com.proj.protime.entity.dto.UsersDTOPut;
import org.springframework.stereotype.Service;

import com.proj.protime.entity.Users;

@Service
public interface UsersService {
	
	List<UsersDTO> getAllUsers();

	UsersDTO findUserById(Integer id);

	List<UsersDTO> findUserByName(String valor);

	UsersDTO updateUser(Integer id, UsersDTOPut user);

}
