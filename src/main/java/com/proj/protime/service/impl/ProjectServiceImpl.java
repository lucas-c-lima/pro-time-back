package com.proj.protime.service.impl;

import java.util.List;

import com.proj.protime.entity.dto.projects.ProjectDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.proj.protime.entity.Projects;
import com.proj.protime.repository.ProjectRepository;
import com.proj.protime.service.ProjectService;

@Service
public class ProjectServiceImpl implements ProjectService {

	@Autowired
	private ProjectRepository projectRepository;

	@Override
	public List<ProjectDTO> getAllProjects() {
		return projectRepository.findAll().stream().map(ProjectDTO::new).toList();
	}

	@Override
	public ProjectDTO findProjectById(Integer id) {
		return new ProjectDTO(
			projectRepository.findById(id)
				.orElseThrow(
						() -> new RuntimeException("Project not found")
				)
		);
	}

	@Override
	public List<ProjectDTO> findProjectByName(String valor) {
		return projectRepository.findProjectByNameContaining(valor).stream().map(ProjectDTO::new).toList();
	}
}
