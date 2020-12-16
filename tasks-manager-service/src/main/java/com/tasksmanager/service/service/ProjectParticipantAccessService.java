package com.tasksmanager.service.service;

import java.util.NoSuchElementException;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tasksmanager.service.model.project.ProjectParticipantAccess;
import com.tasksmanager.service.repository.ProjectParticipantAccessRepository;

/**
 * Project participant access service.
 *
 * @author SIE
 */
@Service
@Transactional(readOnly = true)
public class ProjectParticipantAccessService {

    private final ProjectParticipantAccessRepository userProjectAccessRepository;

    public ProjectParticipantAccessService(ProjectParticipantAccessRepository userProjectAccessRepository) {
        this.userProjectAccessRepository = userProjectAccessRepository;
    }

    /**
     * Return access to project for user by user id and project id.
     *
     * @param projectId project id
     * @param userId    user id
     * @return access
     */
    public ProjectParticipantAccess getAccessToProjectForUser(String projectId, String userId) {
        return this.userProjectAccessRepository
            .findByProjectIdAndUserId(projectId, userId)
            .orElseThrow(() -> new NoSuchElementException("User has not access to project."));
    }


    /**
     * Add new access.
     *
     * @param access access object
     * @return new access id
     */
    @Transactional(readOnly = false)
    public String addAccess(ProjectParticipantAccess access) {
        return this.userProjectAccessRepository.save(access).getId();
    }

    /**
     * Add new access to project if current user is owner of project. If access add for owner access rules update to full access.
     * If access add for other user - <code>isOwner<code/> set to <code>false<code/>.
     *
     * @param access access object
     * @return new access id
     * @param currentUserId current user id
     */
    @Transactional(readOnly = false)
    public String addNewUserAccess(ProjectParticipantAccess access, String currentUserId) {
        ProjectParticipantAccess currentUserAccess = this.getAccessToProjectForUser(access.getProjectId(), currentUserId);

        if (!currentUserAccess.isOwner()) {
            throw new NoSuchElementException("Current user is not owner of this project.");
        }

        if (currentUserAccess.getUserId().equals(access.getUserId())) {
            this.setOwnerDefaultAccess(access);
        }
        else {
            access.setIsOwner(false);
        }

        return this.addAccess(access);
    }

    /**
     * Change access to project if current user is owner of project. If access changing for owner access rules update to full access.
     * If access change for other user - <code>isOwner<code/> set to <code>false<code/>.
     *
     * @param access access object
     */
    @Transactional(readOnly = false)
    public void editAccess(ProjectParticipantAccess access, String currentUser) {
        ProjectParticipantAccess currentUserAccess = this.getAccessToProjectForUser(access.getProjectId(), currentUser);

        if (!currentUserAccess.isOwner()) {
            throw new NoSuchElementException("Current user is not owner of this project.");
        }

        if (!this.userProjectAccessRepository.existsById(access.getId())) {
            throw new NoSuchElementException("Access not found");
        }

        if (currentUserAccess.getUserId().equals(access.getUserId())) {
            this.setOwnerDefaultAccess(access);
        }
        else {
            access.setIsOwner(false);
        }

        this.userProjectAccessRepository.save(access);
    }

    /**
     * Update access rules to full access.
     *
     * @param ownerAccess owner access object
     */
    public void setOwnerDefaultAccess(ProjectParticipantAccess ownerAccess) {
        ownerAccess.setCanAddTasks(true);
        ownerAccess.setCanDeleteTasks(true);
        ownerAccess.setCanEditProject(true);
        ownerAccess.setCanSeeOtherTasks(true);
        ownerAccess.setCanSeeProject(true);
        ownerAccess.setCanSeeTeam(true);
    }
}
