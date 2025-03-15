package com.proj.protime.service.impl;

import java.util.List;

import com.proj.protime.entity.Users;
import com.proj.protime.entity.dto.projects.ProjectsDTO;
import com.proj.protime.entity.dto.projects.ProjectsDTOPostPut;
import com.proj.protime.entity.enums.ProjectStatus;
import com.proj.protime.entity.mapper.ProjectMapper;
import com.proj.protime.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.proj.protime.entity.Projects;
import com.proj.protime.repository.ProjectsRepository;
import com.proj.protime.service.ProjectsService;

@Service
public class ProjectsServiceImpl implements ProjectsService {

	@Autowired
	private ProjectsRepository projectsRepository;

	@Autowired
	private UsersRepository userRepository;

	@Override
	public List<ProjectsDTO> getAllProjects() {
		return projectsRepository.findAll().stream().map(ProjectsDTO::new).toList();
	}

	@Override
	public ProjectsDTO findProjectById(Integer id) {
		return new ProjectsDTO(
			projectsRepository.findById(id)
				.orElseThrow(() -> new RuntimeException("Project not found"))
		);
	}

	@Override
	public List<ProjectsDTO> findProjectByName(String value) {
		return projectsRepository.findProjectByNameContaining(value).stream().map(ProjectsDTO::new).toList();
	}

	@Override
	public List<ProjectsDTO> findProjectByUser(Users user) {
		return projectsRepository.findByIdResponsableUser(user).stream().map(ProjectsDTO::new).toList();
	}

	@Override
	public ProjectsDTO updateProject(
			Integer id, ProjectsDTOPostPut project
	) {
		Projects current = projectsRepository.findById(id)
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
		updated.setCreationDate(current.getCreationDate());

		ProjectMapper.INSTANCE.updateProject(current, updated);

		Projects saved = projectsRepository.save(current);
		return ProjectMapper.INSTANCE.toProjectDTOPut(saved);
	}

	@Override
	public ResponseEntity<ProjectsDTO> createProject(
			ProjectsDTOPostPut project
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

		Projects saved = projectsRepository.save(newProject);
		return ResponseEntity.ok(new ProjectsDTO(saved));
	}

	@Override
	public ResponseEntity<Void> deleteProject(Integer id) {
		Projects projectFound = projectsRepository.findById(id)
			.orElseThrow(() -> new RuntimeException("Project not found"));
		projectFound.setStatus(ProjectStatus.CANCELADO);
		Projects updatedProject = projectsRepository.save(projectFound);
		return ResponseEntity.noContent().build();
	}
}
