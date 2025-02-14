package com.proj.protime.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.proj.protime.entities.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer>{

}
