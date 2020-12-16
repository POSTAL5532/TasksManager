package com.tasksmanager.service.service;

import java.util.NoSuchElementException;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tasksmanager.data.model.project.UserProjectAccess;
import com.tasksmanager.data.repository.UserProjectAccessRepository;
import com.tasksmanager.service.exception.UserHasNotToOperationAccessException;
import com.tasksmanager.service.exception.UserHasNotToProjectAccessException;

/**
 * User project access service.
 *
 * @author SIE
 */
@Service
@Transactional(readOnly = true)
public class UserProjectAccessService {

    private final UserProjectAccessRepository userProjectAccessRepository;

    public UserProjectAccessService(UserProjectAccessRepository userProjectAccessRepository) {
        this.userProjectAccessRepository = userProjectAccessRepository;
    }

    /**
     * Return access to project for user by user id and project id.
     *
     * @param projectId project id
     * @param userId    user id
     * @return access
     */
    public UserProjectAccess getAccessToProjectForUser(String projectId, String userId) {
        return this.userProjectAccessRepository
            .findByProjectIdAndUserId(projectId, userId)
            .orElseThrow(() -> new UserHasNotToProjectAccessException("User has not access to project."));
    }


    /**
     * Add new access.
     *
     * @param access access object
     * @return new access id
     */
    @Transactional(readOnly = false)
    public String addAccess(UserProjectAccess access) {
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
    public String addNewUserAccess(UserProjectAccess access, String currentUserId) {
        UserProjectAccess currentUserAccess = this.getAccessToProjectForUser(access.getProjectId(), currentUserId);

        if (!currentUserAccess.isOwner()) {
            throw new UserHasNotToOperationAccessException("Current user is not owner of this project.");
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
    public void editAccess(UserProjectAccess access, String currentUser) {
        UserProjectAccess currentUserAccess = this.getAccessToProjectForUser(access.getProjectId(), currentUser);

        if (!currentUserAccess.isOwner()) {
            throw new UserHasNotToOperationAccessException("Current user is not owner of this project.");
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
    public void setOwnerDefaultAccess(UserProjectAccess ownerAccess) {
        ownerAccess.setCanAddTasks(true);
        ownerAccess.setCanDeleteTasks(true);
        ownerAccess.setCanEditProject(true);
        ownerAccess.setCanSeeOtherTasks(true);
        ownerAccess.setCanSeeProject(true);
        ownerAccess.setCanSeeTeam(true);
    }
}
