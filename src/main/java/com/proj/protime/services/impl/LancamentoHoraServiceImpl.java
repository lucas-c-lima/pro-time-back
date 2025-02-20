package com.proj.protime.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.proj.protime.entities.LancamentoHora;
import com.proj.protime.repositories.LancamentoHoraRepository;
import com.proj.protime.services.LancamentoHoraService;

public class LancamentoHoraServiceImpl implements LancamentoHoraService{

	@Autowired
	private LancamentoHoraRepository lancamentoHoraRepository;
	
	@Override
	public List<LancamentoHora> getAllLancamentos(){
		return lancamentoHoraRepository.findAll();
	}
	
}
