package com.proj.protime.service;

import java.util.List;

import com.proj.protime.entity.dto.projects.ProjectDTO;
import com.proj.protime.entity.dto.projects.ProjectDTOPostPut;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public interface ProjectService {

	List<ProjectDTO> getAllProjects();

	ProjectDTO findProjectById(Integer id);

	List<ProjectDTO> findProjectByName(String valor);

	ProjectDTO updateProject(Integer id, ProjectDTOPostPut project);

	ResponseEntity<ProjectDTO> createProject(ProjectDTOPostPut project);

	ResponseEntity<Void>  deleteProject(Integer id);
}
