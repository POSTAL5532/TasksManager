package com.tasksmanager.service.controller.user;

import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.web.bind.annotation.*;

import com.tasksmanager.service.controller.user.payload.ChangeEmailRequest;
import com.tasksmanager.service.controller.user.payload.ChangePasswordRequest;
import com.tasksmanager.service.converter.UserConverter;
import com.tasksmanager.service.model.UserDto;
import com.tasksmanager.service.security.preauthorizeconditions.AuthorizedLikeUser;
import com.tasksmanager.service.service.UserService;
import com.tasksmanager.service.utils.AuthUtils;

/**
 * User data controller.
 *
 * @author SIE
 */
@RestController
@RequestMapping("/api")
public class UserController {

    private final UserService userService;

    private final UserConverter userConverter;

    private final AuthUtils authUtils;

    public UserController(UserService userService, UserConverter userConverter, AuthUtils authUtils) {
        this.userService = userService;
        this.userConverter = userConverter;
        this.authUtils = authUtils;
    }

    /**
     * Return current user info.
     *
     * @return HTTP OK with User info
     */
    @GetMapping("/users/current")
    @AuthorizedLikeUser
    public ResponseEntity<UserDto> getCurrentUserInfo() {
        UserDto dto = this.userConverter.convertToDto(this.authUtils.getCurrentAuthenticatedUser());
        return ResponseEntity.ok(dto);
    }

    /**
     * Change current user email and logout.
     *
     * @param changeEmailRequest request body with new email value
     * @return HTTP OK
     */
    @PutMapping("/users/changeemail")
    @AuthorizedLikeUser
    public ResponseEntity<Void> changeEmail(@Valid @RequestBody ChangeEmailRequest changeEmailRequest, OAuth2Authentication authentication) {
        this.userService.changeCurrentUserEmail(changeEmailRequest.getEmail());
        authUtils.revokeCurrentUserToken(authentication);
        return ResponseEntity.ok().build();
    }

    /**
     * Change current user password and logout.
     *
     * @param changePasswordRequest request body with old and new passwords values
     * @return HTTP OK
     */
    @PutMapping("/users/changepassword")
    @AuthorizedLikeUser
    public ResponseEntity<Void> changePassword(@Valid @RequestBody ChangePasswordRequest changePasswordRequest, OAuth2Authentication authentication) {
        this.userService.changeCurrentUserPassword(changePasswordRequest.getNewPassword());
        authUtils.revokeCurrentUserToken(authentication);
        return ResponseEntity.ok().build();
    }
}
