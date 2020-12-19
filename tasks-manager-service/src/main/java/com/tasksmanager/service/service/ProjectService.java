package com.tasksmanager.service.service;

import com.tasksmanager.service.model.project.Project;
import com.tasksmanager.service.repository.ProjectRepository;

/**
 * Project service.
 *
 * @author SIE
 */
public interface ProjectService extends SaveUpdateRepository<Project, ProjectRepository> {

    /**
     * @param id project ID
     * @return project
     */
    Project getById(String id);

    /**
     * Add new project and new access for this project and current user.
     *
     * @param newProject    project object
     * @param currentUserId current user id to set for project owner
     * @return new project id
     */
    Project addNewProject(Project newProject, String currentUserId);
}
