package com.proj.protime.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.proj.protime.entities.Projeto;

public interface ProjetoRepository extends JpaRepository<Projeto, Integer>{

}
