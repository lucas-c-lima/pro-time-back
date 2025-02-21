	package com.proj.protime.controller;
	
	import java.util.List;
	
	import org.springframework.beans.factory.annotation.Autowired;
	import org.springframework.http.ResponseEntity;
	import org.springframework.web.bind.annotation.GetMapping;
	import org.springframework.web.bind.annotation.RequestMapping;
	import org.springframework.web.bind.annotation.RestController;
	
	import com.proj.protime.entity.LancamentoHora;
	import com.proj.protime.service.LancamentoHoraService;
	
	@RestController
	@RequestMapping("/lancamento")
	public class LancamentoHoraController {
	
		@Autowired
		private LancamentoHoraService lancamentoHoraService;
		
		@GetMapping
		public ResponseEntity<List<LancamentoHora>> getAllLancamentos(){
			List<LancamentoHora> lancamentoHoras = lancamentoHoraService.getAllLancamentos();
			return ResponseEntity.ok().body(lancamentoHoras);
		}
		
	}
