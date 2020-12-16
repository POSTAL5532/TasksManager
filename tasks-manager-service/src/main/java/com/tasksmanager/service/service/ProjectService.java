package com.tasksmanager.service.service;

import java.sql.Date;
import java.time.LocalDate;
import java.util.NoSuchElementException;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tasksmanager.data.model.project.Project;
import com.tasksmanager.data.model.project.UserProjectAccess;
import com.tasksmanager.data.repository.ProjectRepository;

/**
 * Project service.
 *
 * @author SIE
 */
@Service
@Transactional(readOnly = true)
public class ProjectService {

    private final ProjectRepository projectRepository;

    private final UserProjectAccessService accessService;

    public ProjectService(ProjectRepository projectRepository, UserProjectAccessService accessService) {
        this.projectRepository = projectRepository;
        this.accessService = accessService;
    }

    /**
     * @param id project ID
     * @return project
     */
    public Project getById(String id) {
        return this.projectRepository
            .findById(id)
            .orElseThrow(() -> new NoSuchElementException("Project not found"));
    }

    /**
     * Add new project and new access for this project and current user.
     *
     * @param newProject    project object
     * @param currentUserId current user id to set for project owner
     * @return new project id
     */
    @Transactional(readOnly = false)
    public String addNewProject(Project newProject, String currentUserId) {
        newProject.setCreationDate(Date.valueOf(LocalDate.now()));

        String newProjectId = this.projectRepository.save(newProject).getId();

        UserProjectAccess access = new UserProjectAccess();
        access.setUserId(currentUserId);
        access.setProjectId(newProjectId);
        this.accessService.setOwnerDefaultAccess(access);
        this.accessService.addAccess(access);

        return newProjectId;
    }
}
