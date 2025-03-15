package com.proj.protime.repository;

import com.proj.protime.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;

import com.proj.protime.entity.Projects;

import java.util.Collection;
import java.util.List;

public interface ProjectsRepository extends JpaRepository<Projects, Integer>{

    List<Projects> findProjectByNameContaining(String value);

    List<Projects> findByIdResponsableUser(Users idResponsableUser);
}
