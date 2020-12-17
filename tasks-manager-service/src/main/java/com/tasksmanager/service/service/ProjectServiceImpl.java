package com.tasksmanager.service.service;

import java.sql.Date;
import java.time.LocalDate;
import java.util.NoSuchElementException;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tasksmanager.service.model.project.Project;
import com.tasksmanager.service.model.project.ProjectParticipantAccess;
import com.tasksmanager.service.repository.ProjectRepository;

@Service
@Transactional(readOnly = true)
public class ProjectServiceImpl implements ProjectService {

    private final ProjectRepository projectRepository;

    private final ProjectParticipantAccessService participantAccessService;

    public ProjectServiceImpl(ProjectRepository projectRepository, ProjectParticipantAccessService participantAccessService) {
        this.projectRepository = projectRepository;
        this.participantAccessService = participantAccessService;
    }

    @Override
    public Project getById(String id) {
        return this.projectRepository
            .findById(id)
            .orElseThrow(() -> new NoSuchElementException("Project not found"));
    }

    @Override
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
