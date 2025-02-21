package com.proj.protime.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.proj.protime.entity.Projeto;
import com.proj.protime.repository.ProjetoRepository;
import com.proj.protime.service.ProjetoService;

@Service
public class ProjetoServiceImpl implements ProjetoService{

	@Autowired
	private ProjetoRepository projetoRepository;
	
	@Override
	public List<Projeto> getAllProjetos(){
		return projetoRepository.findAll();
	}
	
}
