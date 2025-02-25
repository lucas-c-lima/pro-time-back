package com.proj.protime.service.impl;

import java.util.List;

import com.proj.protime.entity.Users;
import com.proj.protime.entity.dto.projects.ProjectDTO;
import com.proj.protime.entity.dto.projects.ProjectDTOPostPut;
import com.proj.protime.entity.mapper.ProjectMapper;
import com.proj.protime.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.proj.protime.entity.Projects;
import com.proj.protime.repository.ProjectRepository;
import com.proj.protime.service.ProjectService;

@Service
public class ProjectServiceImpl implements ProjectService {

	@Autowired
	private ProjectRepository projectRepository;

	@Autowired
	private UsersRepository userRepository;

	@Override
	public List<ProjectDTO> getAllProjects() {
		return projectRepository.findAll().stream().map(ProjectDTO::new).toList();
	}

	@Override
	public ProjectDTO findProjectById(Integer id) {
		return new ProjectDTO(
			projectRepository.findById(id)
				.orElseThrow(() -> new RuntimeException("Project not found"))
		);
	}

	@Override
	public List<ProjectDTO> findProjectByName(String valor) {
		return projectRepository.findProjectByNameContaining(valor).stream().map(ProjectDTO::new).toList();
	}

	@Override
	public ProjectDTO updateProject(
			Integer id, ProjectDTOPostPut project
	) {
		Projects current = projectRepository.findById(id)
				.orElseThrow(() -> new RuntimeException("Project not found"));
		Users responsableUser = userRepository.findById(project.idResponsableUser())
				.orElseThrow(() -> new RuntimeException("User not found"));

		Projects updated = new Projects(
			project.name(),
			project.description(),
			project.startDate(),
			project.endDate(),
			project.status(),
			responsableUser,
			project.priority()
		);

		ProjectMapper.INSTANCE.updateProject(current, updated);

		Projects saved = projectRepository.save(current);
		return ProjectMapper.INSTANCE.toProjectDTOPut(saved);
	}

	@Override
	public ResponseEntity<ProjectDTO> createProject(
			ProjectDTOPostPut project
	) {
		Users responsableUser = userRepository.findById(project.idResponsableUser())
				.orElseThrow(() -> new RuntimeException("User not found"));

		Projects newProject = new Projects(
			project.name(),
			project.description(),
			project.startDate(),
			project.endDate(),
			project.status(),
			responsableUser,
			project.priority()
		);

		Projects saved = projectRepository.save(newProject);
		return ResponseEntity.ok(new ProjectDTO(saved));
	}

	@Override
	public ResponseEntity<Void> deleteProject(Integer id) {
		return projectRepository.findById(id)
			.map(projectFound -> {
				projectRepository.deleteById(id);
				return ResponseEntity.noContent().<Void>build();
			}).orElseThrow(() -> new RuntimeException("Project not found"));
	}
}
