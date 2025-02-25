package com.proj.protime.service;

import java.util.List;

import com.proj.protime.entity.dto.projects.ProjectDTO;
import org.springframework.stereotype.Service;

import com.proj.protime.entity.Projects;

@Service
public interface ProjectService {

	List<ProjectDTO> getAllProjects();

	ProjectDTO findProjectById(Integer id);

	List<ProjectDTO> findProjectByName(String valor);
}
