package com.proj.protime.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.proj.protime.entity.Users;

@Service
public interface UsersService {
	
	List<Users> getAllUsers();
	
	Users getUserById(Integer id);

}
