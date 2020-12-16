package com.tasksmanager.api.controller.project;

import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tasksmanager.service.model.project.Project;
import com.tasksmanager.api.converter.ProjectConverter;
import com.tasksmanager.api.model.ProjectDto;
import com.tasksmanager.api.security.UserDetailsServiceImpl;
import com.tasksmanager.service.service.ProjectService;

/**
 * Project data controller
 *
 * @author SIE
 */
@RestController
@RequestMapping("/api/projects")
public class ProjectsController {

    private final ProjectService projectService;

    private final ProjectConverter projectConverter;

    private final UserDetailsServiceImpl userDetailsService;

    public ProjectsController(ProjectService projectService, ProjectConverter projectConverter, UserDetailsServiceImpl userDetailsService) {
        this.projectService = projectService;
        this.projectConverter = projectConverter;
        this.userDetailsService = userDetailsService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProjectDto> getProject(@PathVariable String id) {
        Project project = projectService.getById(id);
        return ResponseEntity.ok(projectConverter.convertToDto(project));
    }

    @PostMapping
    public ResponseEntity<String> createProject(@Valid @RequestBody ProjectDto project) {
        String newProjectId = projectService.addNewProject(
            projectConverter.convertToEntity(project),
            userDetailsService.getCurrentAuthenticatedUserId()
        );
        return ResponseEntity.ok(newProjectId);
    }
}
