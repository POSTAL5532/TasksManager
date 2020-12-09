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
import com.tasksmanager.service.security.preauthorizeconditions.AuthorizedLikeUser;
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

    public UserProjectAccessController(UserProjectAccessService userProjectAccessService, UserProjectAccessConverter userProjectAccessConverter) {
        this.userProjectAccessService = userProjectAccessService;
        this.userProjectAccessConverter = userProjectAccessConverter;
    }

    @PostMapping
    public ResponseEntity<Void> addAccess(@Valid @RequestBody UserProjectAccessDto access) {
        this.userProjectAccessService.addNewUserAccess(this.userProjectAccessConverter.convertToEntity(access));
        return ResponseEntity.ok().build();
    }

    @PutMapping
    public ResponseEntity<Void> changeAccess(@Valid @RequestBody UserProjectAccessDto access) {
        this.userProjectAccessService.editAccess(this.userProjectAccessConverter.convertToEntity(access));
        return ResponseEntity.ok().build();
    }
}
