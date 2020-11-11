package com.tasksmanager.service.service;

import java.sql.Date;
import java.time.LocalDate;
import java.util.NoSuchElementException;

import javax.persistence.EntityNotFoundException;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tasksmanager.data.model.project.Project;
import com.tasksmanager.data.repository.ProjectRepository;

/**
 * Project service
 *
 * @author SIE
 */
@Service
@Transactional(readOnly = true)
public class ProjectService {

    private final ProjectRepository projectRepository;

    public ProjectService(ProjectRepository projectRepository) {
        this.projectRepository = projectRepository;
    }

    // TODO handle NoSuchElementException to http-response
    public Project getById(String id) {
        return this.projectRepository
            .findById(id)
            .orElseThrow(() -> new NoSuchElementException("Project not found"));
    }

    @Transactional(readOnly = false)
    public String addNewProject(Project newProject) {
        newProject.setCreationDate(Date.valueOf(LocalDate.now()));
        return this.projectRepository.save(newProject).getId();
    }
}
