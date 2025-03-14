package com.proj.protime.controller;

import java.util.List;

import com.proj.protime.entity.dto.projects.ProjectsDTO;
import com.proj.protime.entity.dto.projects.ProjectsDTOPostPut;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.proj.protime.service.ProjectsService;

@RestController
@RequestMapping("/projects")
public class ProjectsController {

	@Autowired	
	private ProjectsService projectsService;
	
	@GetMapping
	public ResponseEntity<List<ProjectsDTO>> getAllProjects(){
		List<ProjectsDTO> projects = projectsService.getAllProjects();
		return ResponseEntity.ok().body(projects);
	}

	@GetMapping("/{id}")
	public ResponseEntity<ProjectsDTO> findProjectById(@PathVariable Integer id){
		ProjectsDTO project = projectsService.findProjectById(id);
		return ResponseEntity.ok().body(project);
	}

	@GetMapping("/name")
	public ResponseEntity<List<ProjectsDTO>> findProjectByName(@RequestParam String value){
		List<ProjectsDTO> project = projectsService.findProjectByName(value);
		return ResponseEntity.ok().body(project);
	}

	@PostMapping
	public ResponseEntity<ProjectsDTO> createProject(@Valid @RequestBody ProjectsDTOPostPut project){
		return projectsService.createProject(project);
	}

	@PutMapping("/{id}")
	public ResponseEntity<ProjectsDTO> updateProject(@PathVariable Integer id, @Valid @RequestBody ProjectsDTOPostPut project){
		return ResponseEntity.ok(projectsService.updateProject(id, project));
	}

	//TODO implementar soft delete!!!!
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteProject(@PathVariable Integer id){
		projectsService.deleteProject(id);
		return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
	}
}
