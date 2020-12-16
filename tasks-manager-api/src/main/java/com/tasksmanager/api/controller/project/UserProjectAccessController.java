package com.tasksmanager.api.controller.project;

import java.util.NoSuchElementException;

import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tasksmanager.api.converter.UserProjectAccessConverter;
import com.tasksmanager.api.exception.UserHasNotToOperationAccessException;
import com.tasksmanager.api.model.UserProjectAccessDto;
import com.tasksmanager.api.security.UserDetailsServiceImpl;
import com.tasksmanager.service.service.UserProjectAccessService;

/**
 * User project access controller.
 *
 * @author SIE
 */
@RestController
@RequestMapping("/api/projectaccesses")
public class UserProjectAccessController {

    private final UserProjectAccessService userProjectAccessService;

    private final UserProjectAccessConverter userProjectAccessConverter;

    private final UserDetailsServiceImpl userDetailsService;

    public UserProjectAccessController(UserProjectAccessService userProjectAccessService, UserProjectAccessConverter userProjectAccessConverter, UserDetailsServiceImpl userDetailsService) {
        this.userProjectAccessService = userProjectAccessService;
        this.userProjectAccessConverter = userProjectAccessConverter;
        this.userDetailsService = userDetailsService;
    }

    @PostMapping
    public ResponseEntity<String> addAccess(@Valid @RequestBody UserProjectAccessDto access) {
        String newAccessId;

        try{
            newAccessId = userProjectAccessService.addNewUserAccess(
                userProjectAccessConverter.convertToEntity(access),
                userDetailsService.getCurrentAuthenticatedUserId()
            );
        }catch (NoSuchElementException exception) {
            throw new UserHasNotToOperationAccessException(exception.getMessage());
        }

        return ResponseEntity.ok(newAccessId);
    }

    @PutMapping
    public ResponseEntity<Void> changeAccess(@Valid @RequestBody UserProjectAccessDto access) {
        try{
            userProjectAccessService.editAccess(
                userProjectAccessConverter.convertToEntity(access),
                userDetailsService.getCurrentAuthenticatedUserId()
            );
        }catch (NoSuchElementException exception) {
            throw new UserHasNotToOperationAccessException(exception.getMessage());
        }

        return ResponseEntity.ok().build();
    }
}
