package com.proj.protime.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.proj.protime.entities.Usuario;
import com.proj.protime.repositories.UsuarioRepository;
import com.proj.protime.services.UsuarioService;

public class UsuarioServiceImpl implements UsuarioService{

	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@Override
	public List<Usuario> getAllUsers() {
		return usuarioRepository.findAll();
	}

}
