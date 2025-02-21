package com.proj.protime.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.proj.protime.entity.LancamentoHora;
import com.proj.protime.repository.LancamentoHoraRepository;
import com.proj.protime.service.LancamentoHoraService;

@Service
public class LancamentoHoraServiceImpl implements LancamentoHoraService{

	@Autowired
	private LancamentoHoraRepository lancamentoHoraRepository;
	
	@Override
	public List<LancamentoHora> getAllLancamentos(){
		return lancamentoHoraRepository.findAll();
	}
	
}
