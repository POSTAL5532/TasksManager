package com.tasksmanager.service.service;

import java.util.NoSuchElementException;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tasksmanager.service.exception.UserHasNotToOperationAccessException;
import com.tasksmanager.service.exception.UserHasNotToProjectAccessException;
import com.tasksmanager.service.model.project.ProjectParticipantAccess;
import com.tasksmanager.service.repository.ProjectParticipantAccessRepository;

@Service
@Transactional(readOnly = true)
public class ProjectParticipantAccessServiceImpl implements ProjectParticipantAccessService {

    private final ProjectParticipantAccessRepository projectParticipantAccessRepository;

    public ProjectParticipantAccessServiceImpl(ProjectParticipantAccessRepository projectParticipantAccessRepository) {
        this.projectParticipantAccessRepository = projectParticipantAccessRepository;
    }

    @Override
    public ProjectParticipantAccess getAccessToProjectForUser(String projectId, String userId) {
        return this.projectParticipantAccessRepository
            .findByProjectIdAndUserId(projectId, userId)
            .orElseThrow(() -> new NoSuchElementException("User has not access to project."));
    }

    @Override
    @Transactional(readOnly = false)
    public ProjectParticipantAccess addNewUserAccess(ProjectParticipantAccess access, String currentUserId) {
        ProjectParticipantAccess currentUserAccess = this.getAccessToProjectForUser(access.getProjectId(), currentUserId);

        if (!currentUserAccess.isOwner()) {
            throw new UserHasNotToProjectAccessException("Current user is not owner of this project.");
        }

        if (currentUserAccess.getUserId().equals(access.getUserId())) {
            this.setOwnerDefaultAccess(access);
        }
        else {
            access.setIsOwner(false);
        }

        return this.save(access);
    }

    @Override
    @Transactional(readOnly = false)
    public void changeAccess(ProjectParticipantAccess access, String currentUser) {
        ProjectParticipantAccess currentUserAccess = this.getAccessToProjectForUser(access.getProjectId(), currentUser);

        if (!currentUserAccess.isOwner()) {
            throw new UserHasNotToProjectAccessException("Current user is not owner of this project.");
        }

        if (!this.projectParticipantAccessRepository.existsById(access.getId())) {
            throw new UserHasNotToOperationAccessException("Access not found");
        }

        if (currentUserAccess.getUserId().equals(access.getUserId())) {
            this.setOwnerDefaultAccess(access);
        }
        else {
            access.setIsOwner(false);
        }

        this.update(access);
    }

    @Override
    public void setOwnerDefaultAccess(ProjectParticipantAccess ownerAccess) {
        ownerAccess.setCanAddTasks(true);
        ownerAccess.setCanDeleteTasks(true);
        ownerAccess.setCanEditProject(true);
        ownerAccess.setCanSeeOtherTasks(true);
        ownerAccess.setCanSeeProject(true);
        ownerAccess.setCanSeeTeam(true);
    }

    @Override
    public ProjectParticipantAccessRepository getRepository() {
        return this.projectParticipantAccessRepository;
    }
}
