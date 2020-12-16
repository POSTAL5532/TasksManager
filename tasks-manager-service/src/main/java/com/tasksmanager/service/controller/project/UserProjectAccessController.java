package com.tasksmanager.service.controller.project;

import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tasksmanager.service.converter.UserProjectAccessConverter;
import com.tasksmanager.service.model.UserProjectAccessDto;
import com.tasksmanager.service.security.UserDetailsServiceImpl;
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
        String newAccessId = userProjectAccessService.addNewUserAccess(
            userProjectAccessConverter.convertToEntity(access),
            userDetailsService.getCurrentAuthenticatedUserId()
        );
        return ResponseEntity.ok(newAccessId);
    }

    @PutMapping
    public ResponseEntity<Void> changeAccess(@Valid @RequestBody UserProjectAccessDto access) {
        userProjectAccessService.editAccess(
            userProjectAccessConverter.convertToEntity(access),
            userDetailsService.getCurrentAuthenticatedUserId()
        );
        return ResponseEntity.ok().build();
    }
}
