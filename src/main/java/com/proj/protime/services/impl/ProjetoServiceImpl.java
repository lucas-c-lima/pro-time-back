package com.proj.protime.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.proj.protime.entities.Projeto;
import com.proj.protime.repositories.ProjetoRepository;
import com.proj.protime.services.ProjetoService;

public class ProjetoServiceImpl implements ProjetoService{

	@Autowired
	private ProjetoRepository projetoRepository;
	
	@Override
	public List<Projeto> getAllProjetos(){
		return projetoRepository.findAll();
	}
	
}
