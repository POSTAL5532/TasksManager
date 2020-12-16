package com.tasksmanager.service.service;

import java.sql.Date;
import java.time.LocalDate;
import java.util.NoSuchElementException;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tasksmanager.service.model.project.Project;
import com.tasksmanager.service.model.project.ProjectParticipantAccess;
import com.tasksmanager.service.repository.ProjectRepository;

/**
 * Project service.
 *
 * @author SIE
 */
@Service
@Transactional(readOnly = true)
public class ProjectService {

    private final ProjectRepository projectRepository;

    private final ProjectParticipantAccessService participantAccessService;

    public ProjectService(ProjectRepository projectRepository, ProjectParticipantAccessService participantAccessService) {
        this.projectRepository = projectRepository;
        this.participantAccessService = participantAccessService;
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

        ProjectParticipantAccess access = new ProjectParticipantAccess();
        access.setUserId(currentUserId);
        access.setProjectId(newProjectId);
        this.participantAccessService.setOwnerDefaultAccess(access);
        this.participantAccessService.addAccess(access);

        return newProjectId;
    }
}
