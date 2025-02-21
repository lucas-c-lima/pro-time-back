package com.proj.protime.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.proj.protime.entity.Projeto;

@Service
public interface ProjetoService {

	public List<Projeto> getAllProjetos();
	
}
