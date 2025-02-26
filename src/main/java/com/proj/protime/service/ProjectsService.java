package com.proj.protime.service;

import java.util.List;

import com.proj.protime.entity.dto.projects.ProjectsDTO;
import com.proj.protime.entity.dto.projects.ProjectsDTOPostPut;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public interface ProjectsService {

	List<ProjectsDTO> getAllProjects();

	ProjectsDTO findProjectById(Integer id);

	List<ProjectsDTO> findProjectByName(String value);

	ProjectsDTO updateProject(Integer id, ProjectsDTOPostPut project);

	ResponseEntity<ProjectsDTO> createProject(ProjectsDTOPostPut project);

	ResponseEntity<Void>  deleteProject(Integer id);
}
