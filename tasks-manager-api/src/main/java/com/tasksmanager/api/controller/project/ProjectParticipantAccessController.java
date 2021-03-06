package com.tasksmanager.api.controller.project;

import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tasksmanager.api.converter.ProjectParticipantAccessConverter;
import com.tasksmanager.api.model.ProjectParticipantAccessDto;
import com.tasksmanager.api.security.UserDetailsServiceImpl;
import com.tasksmanager.service.service.ProjectParticipantAccessService;

/**
 * Project participant access controller.
 *
 * @author SIE
 */
@RestController
@RequestMapping("/api/participantaccess")
public class ProjectParticipantAccessController {

    private final ProjectParticipantAccessService projectParticipantAccessService;

    private final ProjectParticipantAccessConverter participantAccessConverter;

    private final UserDetailsServiceImpl userDetailsService;

    public ProjectParticipantAccessController(ProjectParticipantAccessService projectParticipantAccessService, ProjectParticipantAccessConverter participantAccessConverter, UserDetailsServiceImpl userDetailsService) {
        this.projectParticipantAccessService = projectParticipantAccessService;
        this.participantAccessConverter = participantAccessConverter;
        this.userDetailsService = userDetailsService;
    }

    @PostMapping
    public ResponseEntity<String> addAccess(@Valid @RequestBody ProjectParticipantAccessDto access) {
        String newAccessId = projectParticipantAccessService.addNewUserAccess(
            participantAccessConverter.convertToEntity(access),
            userDetailsService.getCurrentAuthenticatedUserId()
        ).getProjectId();

        return ResponseEntity.ok(newAccessId);
    }

    @PutMapping
    public ResponseEntity<Void> changeAccess(@Valid @RequestBody ProjectParticipantAccessDto access) {
        projectParticipantAccessService.changeAccess(
            participantAccessConverter.convertToEntity(access),
            userDetailsService.getCurrentAuthenticatedUserId()
        );

        return ResponseEntity.ok().build();
    }
}
