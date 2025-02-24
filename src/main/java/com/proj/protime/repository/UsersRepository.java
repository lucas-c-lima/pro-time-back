package com.proj.protime.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;

import com.proj.protime.entity.Users;

import java.util.List;

public interface UsersRepository extends JpaRepository<Users, Integer>{

	UserDetails findByEmail(String email);

	List<Users> findUserByNameContaining(String valor);
}
