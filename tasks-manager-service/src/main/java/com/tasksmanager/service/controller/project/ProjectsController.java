package com.tasksmanager.service.controller.project;

import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tasksmanager.data.model.project.Project;
import com.tasksmanager.service.converter.ProjectConverter;
import com.tasksmanager.service.model.ProjectDto;
import com.tasksmanager.service.service.ProjectService;

/**
 * Project data controller
 *
 * @author SIE
 */
@RestController
@RequestMapping("/projects/api")
public class ProjectsController {

    private final ProjectService projectService;

    private final ProjectConverter projectConverter;

    public ProjectsController(ProjectService projectService, ProjectConverter projectConverter) {
        this.projectService = projectService;
        this.projectConverter = projectConverter;
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProjectDto> getProject(@PathVariable String id) {
        Project project = this.projectService.getById(id);
        return ResponseEntity.ok(this.projectConverter.convertToDto(project));
    }

    @PostMapping
    public ResponseEntity<String> createProject(@Valid @RequestBody ProjectDto project) {
        Project newProject = this.projectConverter.convertToEntity(project);
        String newProjectId = this.projectService.addNewProject(newProject);
        return ResponseEntity.ok(newProjectId);
    }
}
