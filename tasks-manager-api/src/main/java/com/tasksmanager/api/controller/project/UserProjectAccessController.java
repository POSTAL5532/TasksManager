package com.tasksmanager.api.controller.project;

import java.util.NoSuchElementException;

import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tasksmanager.api.converter.ProjectParticipantAccessConverter;
import com.tasksmanager.api.exception.UserHasNotToOperationAccessException;
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
public class UserProjectAccessController {

    private final ProjectParticipantAccessService participantAccessService;

    private final ProjectParticipantAccessConverter participantAccessConverter;

    private final UserDetailsServiceImpl userDetailsService;

    public UserProjectAccessController(ProjectParticipantAccessService userProjectAccessService, ProjectParticipantAccessConverter participantAccessConverter, UserDetailsServiceImpl userDetailsService) {
        this.participantAccessService = userProjectAccessService;
        this.participantAccessConverter = participantAccessConverter;
        this.userDetailsService = userDetailsService;
    }

    @PostMapping
    public ResponseEntity<String> addAccess(@Valid @RequestBody ProjectParticipantAccessDto access) {
        String newAccessId;

        try{
            newAccessId = participantAccessService.addNewUserAccess(
                participantAccessConverter.convertToEntity(access),
                userDetailsService.getCurrentAuthenticatedUserId()
            );
        }catch (NoSuchElementException exception) {
            throw new UserHasNotToOperationAccessException(exception.getMessage());
        }

        return ResponseEntity.ok(newAccessId);
    }

    @PutMapping
    public ResponseEntity<Void> changeAccess(@Valid @RequestBody ProjectParticipantAccessDto access) {
        try{
            participantAccessService.editAccess(
                participantAccessConverter.convertToEntity(access),
                userDetailsService.getCurrentAuthenticatedUserId()
            );
        }catch (NoSuchElementException exception) {
            throw new UserHasNotToOperationAccessException(exception.getMessage());
        }

        return ResponseEntity.ok().build();
    }
}
