package com.tasksmanager.service.service;

import org.springframework.transaction.annotation.Transactional;

import com.tasksmanager.service.model.project.Project;

/**
 * Project service.
 *
 * @author SIE
 */
public interface ProjectService {

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
    @Transactional(readOnly = false)
    String addNewProject(Project newProject, String currentUserId);
}
