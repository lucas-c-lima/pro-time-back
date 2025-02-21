package com.proj.protime.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.proj.protime.entity.Usuario;
import com.proj.protime.repository.UsuarioRepository;
import com.proj.protime.service.UsuarioService;

@Service
public class UsuarioServiceImpl implements UsuarioService{

	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@Override
	public List<Usuario> getAllUsers() {
		return usuarioRepository.findAll();
	}

}
