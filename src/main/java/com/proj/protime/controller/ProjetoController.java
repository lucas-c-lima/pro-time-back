package com.proj.protime.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.proj.protime.entity.Projeto;
import com.proj.protime.service.ProjetoService;

@RestController
@RequestMapping("/projetos")
public class ProjetoController {

	@Autowired	
	private ProjetoService projetoService;
	
	@GetMapping
	public ResponseEntity<List<Projeto>> getAllProjetos(){
		List<Projeto> users = projetoService.getAllProjetos();
		return ResponseEntity.ok().body(users);
	}
}
