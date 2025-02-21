package com.proj.protime.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.proj.protime.entity.LancamentoHora;

public interface LancamentoHoraService {

	public List<LancamentoHora> getAllLancamentos();
}
