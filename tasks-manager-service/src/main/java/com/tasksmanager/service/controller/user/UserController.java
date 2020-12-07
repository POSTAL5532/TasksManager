package com.tasksmanager.service.controller.user;

import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.web.bind.annotation.*;

import com.tasksmanager.service.controller.user.payload.ChangeEmailRequest;
import com.tasksmanager.service.controller.user.payload.ChangePasswordRequest;
import com.tasksmanager.service.controller.user.payload.ChangeUserNamesRequest;
import com.tasksmanager.service.converter.UserConverter;
import com.tasksmanager.service.model.UserDto;
import com.tasksmanager.service.security.preauthorizeconditions.AuthorizedLikeUser;
import com.tasksmanager.service.service.UserService;
import com.tasksmanager.service.utils.TokenUtils;

/**
 * User data controller.
 *
 * @author SIE
 */
@RestController
@RequestMapping("/api/users")
public class UserController {

    private final UserService userService;

    private final UserConverter userConverter;

    private final TokenUtils tokenUtils;

    public UserController(UserService userService, UserConverter userConverter, TokenUtils tokenUtils) {
        this.userService = userService;
        this.userConverter = userConverter;
        this.tokenUtils = tokenUtils;
    }

    /**
     * Return current user info.
     *
     * @return HTTP OK with User info
     */
    @GetMapping("/current")
    @AuthorizedLikeUser
    public ResponseEntity<UserDto> getCurrentUserInfo() {
        UserDto dto = this.userConverter.convertToDto(this.userService.getCurrentAuthenticatedUser());
        return ResponseEntity.ok(dto);
    }

    /**
     * Change current user email and logout.
     *
     * @param changeEmailRequest request body with new email value
     * @return HTTP OK
     */
    @PutMapping("/changeemail")
    @AuthorizedLikeUser
    public ResponseEntity<Void> changeEmail(@Valid @RequestBody ChangeEmailRequest changeEmailRequest, OAuth2Authentication authentication) {
        this.userService.changeCurrentUserEmail(changeEmailRequest.getEmail());
        tokenUtils.revokeCurrentUserToken(authentication);
        return ResponseEntity.ok().build();
    }

    /**
     * Change current user password and logout.
     *
     * @param changePasswordRequest request body with old and new passwords values
     * @return HTTP OK
     */
    @PutMapping("/changepassword")
    @AuthorizedLikeUser
    public ResponseEntity<Void> changePassword(@Valid @RequestBody ChangePasswordRequest changePasswordRequest, OAuth2Authentication authentication) {
        this.userService.changeCurrentUserPassword(changePasswordRequest.getNewPassword());
        tokenUtils.revokeCurrentUserToken(authentication);
        return ResponseEntity.ok().build();
    }

    /**
     * Change current user firstName/lastName.
     *
     * @param changeRequest request body with firstName and LastName.
     * @return HTTP OK
     */
    @PutMapping("/changenames")
    @AuthorizedLikeUser
    public ResponseEntity<Void> changeName(@Valid @RequestBody ChangeUserNamesRequest changeRequest) {
        this.userService.changeCurrentUserNames(changeRequest.getFirstName(), changeRequest.getLastName());
        return ResponseEntity.ok().build();
    }
}
