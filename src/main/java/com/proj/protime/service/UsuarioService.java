package com.proj.protime.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.proj.protime.entity.Usuario;

@Service
public interface UsuarioService {
	
	public List<Usuario> getAllUsers();

}
