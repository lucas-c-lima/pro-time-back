package com.proj.protime.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;

import com.proj.protime.entity.Users;

public interface UsersRepository extends JpaRepository<Users, Integer>{

	UserDetails findByEmail(String email);
}
