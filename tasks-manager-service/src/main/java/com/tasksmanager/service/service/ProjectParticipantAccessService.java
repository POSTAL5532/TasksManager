package com.tasksmanager.service.service;

import org.springframework.transaction.annotation.Transactional;

import com.tasksmanager.service.model.project.ProjectParticipantAccess;

/**
 * Project participant access service.
 *
 * @author SIE
 */
public interface ProjectParticipantAccessService {

    /**
     * Return access to project for user by user id and project id.
     *
     * @param projectId project id
     * @param userId    user id
     * @return access
     */
    ProjectParticipantAccess getAccessToProjectForUser(String projectId, String userId);

    /**
     * Add new access.
     *
     * @param access access object
     * @return new access id
     */
    @Transactional(readOnly = false)
    ProjectParticipantAccess addAccess(ProjectParticipantAccess access);

    /**
     * Add new access to project if current user is owner of project. If access add for owner access rules update to full access.
     * If access add for other user - <code>isOwner<code/> set to <code>false<code/>.
     *
     * @param access access object
     * @return new access id
     * @param currentUserId current user id
     */
    @Transactional(readOnly = false)
    ProjectParticipantAccess addNewUserAccess(ProjectParticipantAccess access, String currentUserId);

    /**
     * Change access to project if current user is owner of project. If access changing for owner access rules update to full access.
     * If access change for other user - <code>isOwner<code/> set to <code>false<code/>.
     *
     * @param access access object
     */
    @Transactional(readOnly = false)
    void editAccess(ProjectParticipantAccess access, String currentUser);

    /**
     * Update access rules to full access.
     *
     * @param ownerAccess owner access object
     */
    void setOwnerDefaultAccess(ProjectParticipantAccess ownerAccess);
}
