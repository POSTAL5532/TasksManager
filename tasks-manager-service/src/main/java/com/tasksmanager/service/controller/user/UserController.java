package com.tasksmanager.service.controller.user;

import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.tasksmanager.service.controller.user.payload.ChangeEmailRequest;
import com.tasksmanager.service.converter.UserConverter;
import com.tasksmanager.service.model.UserDto;
import com.tasksmanager.service.security.preauthorizeconditions.AuthorizeLikeUser;
import com.tasksmanager.service.service.UserService;

/**
 * User data controller
 *
 * @author SIE
 */
@RestController
@RequestMapping("/api")
public class UserController {

    private final UserService userService;

    private final UserConverter userConverter;

    public UserController(UserService userService, UserConverter userConverter) {
        this.userService = userService;
        this.userConverter = userConverter;
    }

    /**
     * Return current user info.
     *
     * @return HTTP OK
     */
    @GetMapping("/users/current")
    @AuthorizeLikeUser
    public ResponseEntity<UserDto> getUserInfoById() {
        UserDto dto = this.userConverter.convertToDto(this.userService.getCurrentAuthenticatedUser());
        return ResponseEntity.ok(dto);
    }

    /**
     * Change current user email.
     *
     * @param changeEmailRequest request body with new email value
     * @return HTTP OK
     */
    @PutMapping("/users/changeemail")
    @AuthorizeLikeUser
    public ResponseEntity<Void> changeEmail(@Valid @RequestBody ChangeEmailRequest changeEmailRequest) {
        this.userService.changeCurrentUserEmail(changeEmailRequest.getEmail());
        // TODO logout
        return ResponseEntity.ok().build();
    }
}
