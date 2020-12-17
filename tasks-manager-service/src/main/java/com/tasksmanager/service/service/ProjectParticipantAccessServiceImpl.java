package com.tasksmanager.service.service;

import java.util.NoSuchElementException;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tasksmanager.service.model.project.ProjectParticipantAccess;
import com.tasksmanager.service.repository.ProjectParticipantAccessRepository;

@Service
@Transactional(readOnly = true)
public class ProjectParticipantAccessServiceImpl implements ProjectParticipantAccessService {

    private final ProjectParticipantAccessRepository userProjectAccessRepository;

    public ProjectParticipantAccessServiceImpl(ProjectParticipantAccessRepository userProjectAccessRepository) {
        this.userProjectAccessRepository = userProjectAccessRepository;
    }

    @Override
    public ProjectParticipantAccess getAccessToProjectForUser(String projectId, String userId) {
        return this.userProjectAccessRepository
            .findByProjectIdAndUserId(projectId, userId)
            .orElseThrow(() -> new NoSuchElementException("User has not access to project."));
    }

    @Override
    @Transactional(readOnly = false)
    public String addAccess(ProjectParticipantAccess access) {
        return this.userProjectAccessRepository.save(access).getId();
    }

    @Override
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

    @Override
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

    @Override
    public void setOwnerDefaultAccess(ProjectParticipantAccess ownerAccess) {
        ownerAccess.setCanAddTasks(true);
        ownerAccess.setCanDeleteTasks(true);
        ownerAccess.setCanEditProject(true);
        ownerAccess.setCanSeeOtherTasks(true);
        ownerAccess.setCanSeeProject(true);
        ownerAccess.setCanSeeTeam(true);
    }
}
