package com.tasksmanager.service.service;

import com.tasksmanager.service.model.project.ProjectParticipantAccess;
import com.tasksmanager.service.repository.ProjectParticipantAccessRepository;

/**
 * Project participant access service.
 *
 * @author SIE
 */
public interface ProjectParticipantAccessService extends SaveUpdateRepository<ProjectParticipantAccess, ProjectParticipantAccessRepository> {

    /**
     * Return access to project for user by user id and project id.
     *
     * @param projectId project id
     * @param userId    user id
     * @return access
     */
    ProjectParticipantAccess getAccessToProjectForUser(String projectId, String userId);

    /**
     * Add new access to project if current user is owner of project. If access add for owner access rules update to full access.
     * If access add for other user - <code>isOwner<code/> set to <code>false<code/>.
     *
     * @param access        access object
     * @param currentUserId current user id
     * @return new access id
     */
    ProjectParticipantAccess addNewUserAccess(ProjectParticipantAccess access, String currentUserId);

    /**
     * Change access to project if current user is owner of project. If access changing for owner access rules update to full access.
     * If access change for other user - <code>isOwner<code/> set to <code>false<code/>.
     *
     * @param access access object
     */
    void changeAccess(ProjectParticipantAccess access, String currentUser);

    /**
     * Update access rules to full access.
     *
     * @param ownerAccess owner access object
     */
    void setOwnerDefaultAccess(ProjectParticipantAccess ownerAccess);
}
