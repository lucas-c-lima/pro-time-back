package com.proj.protime.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.proj.protime.entity.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer>{

}
