package com.proj.protime.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.proj.protime.entity.LancamentoHora;

@Repository
public interface LancamentoHoraRepository extends JpaRepository<LancamentoHora, Integer>{

}
