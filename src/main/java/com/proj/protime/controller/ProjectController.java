package com.proj.protime.controller;

import java.util.List;

import com.proj.protime.entity.dto.projects.ProjectDTO;
import com.proj.protime.entity.dto.projects.ProjectDTOPostPut;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.proj.protime.service.ProjectService;

@RestController
@RequestMapping("/projects")
public class ProjectController {

	@Autowired	
	private ProjectService projectService;
	
	@GetMapping
	public ResponseEntity<List<ProjectDTO>> getAllProjects(){
		List<ProjectDTO> projects = projectService.getAllProjects();
		return ResponseEntity.ok().body(projects);
	}

	@GetMapping("/{id}")
	public ResponseEntity<ProjectDTO> findProjectById(@PathVariable Integer id){
		ProjectDTO project = projectService.findProjectById(id);
		return ResponseEntity.ok().body(project);
	}

	@GetMapping("/name")
	public ResponseEntity<List<ProjectDTO>> findProjectByName(@RequestParam String valor){
		List<ProjectDTO> project = projectService.findProjectByName(valor);
		return ResponseEntity.ok().body(project);
	}

	// TODO VERIFICAR COMO ARRUMAR PARA PUXAR APENAS O DIA E NÃO O HORÁRIO;
	@PostMapping
	public ResponseEntity<ProjectDTO> createProject(@Valid @RequestBody ProjectDTOPostPut project){
		return projectService.createProject(project);
	}

	@PutMapping("/{id}")
	public ResponseEntity<ProjectDTO> updateProject(@PathVariable Integer id, @Valid @RequestBody ProjectDTOPostPut project){
		return ResponseEntity.ok(projectService.updateProject(id, project));
	}

	//TODO implementar soft delete!!!!
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteProject(@PathVariable Integer id){
		projectService.deleteProject(id);
		return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
	}
}
