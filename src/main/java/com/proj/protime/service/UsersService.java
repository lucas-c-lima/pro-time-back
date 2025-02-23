package com.proj.protime.service;

import java.util.List;

import com.proj.protime.entity.dto.UsersDTO;
import org.springframework.stereotype.Service;

import com.proj.protime.entity.Users;

@Service
public interface UsersService {
	
	List<UsersDTO> getAllUsers();
	
	Users getUserById(Integer id);

}
