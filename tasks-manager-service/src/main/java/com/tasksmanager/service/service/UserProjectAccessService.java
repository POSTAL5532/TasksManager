package com.tasksmanager.service.service;

import java.util.NoSuchElementException;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tasksmanager.data.model.project.UserProjectAccess;
import com.tasksmanager.data.model.user.User;
import com.tasksmanager.data.repository.UserProjectAccessRepository;

/**
 * User project access service.
 *
 * @author SIE
 */
@Service
@Transactional(readOnly = true)
public class UserProjectAccessService {

    private final UserProjectAccessRepository userProjectAccessRepository;

    private final UserService userService;

    public UserProjectAccessService(UserProjectAccessRepository userProjectAccessRepository, UserService userService) {
        this.userProjectAccessRepository = userProjectAccessRepository;
        this.userService = userService;
    }

    public UserProjectAccess getForUserByProject(String projectId) {
        User currentUser = this.userService.getCurrentAuthenticatedUser();
        return this.userProjectAccessRepository
            .findByProjectIdAndUserId(projectId, currentUser.getId())
            .orElseThrow(() -> new NoSuchElementException("Project access rules not found"));
    }
}
