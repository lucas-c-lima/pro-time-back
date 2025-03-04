package com.proj.protime.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.proj.protime.entity.Projects;

import java.util.List;

public interface ProjectsRepository extends JpaRepository<Projects, Integer>{

    List<Projects> findProjectByNameContaining(String value);
}
