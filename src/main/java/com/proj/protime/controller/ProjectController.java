package com.proj.protime.controller;

import java.util.List;

import com.proj.protime.entity.dto.projects.ProjectDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.proj.protime.entity.Projects;
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
}
