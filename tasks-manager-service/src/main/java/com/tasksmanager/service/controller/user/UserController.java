package com.tasksmanager.service.controller.user;

import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.web.bind.annotation.*;

import com.tasksmanager.data.model.user.User;
import com.tasksmanager.service.controller.user.payload.ChangeEmailRequest;
import com.tasksmanager.service.controller.user.payload.ChangePasswordRequest;
import com.tasksmanager.service.controller.user.payload.ChangeUserNamesRequest;
import com.tasksmanager.service.converter.UserConverter;
import com.tasksmanager.service.model.UserDto;
import com.tasksmanager.service.security.UserDetailsServiceImpl;
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

    private final UserDetailsServiceImpl userDetailsService;

    public UserController(UserService userService, UserConverter userConverter, TokenUtils tokenUtils, UserDetailsServiceImpl userDetailsService) {
        this.userService = userService;
        this.userConverter = userConverter;
        this.tokenUtils = tokenUtils;
        this.userDetailsService = userDetailsService;
    }

    /**
     * Return current user info.
     *
     * @return HTTP OK with User info
     */
    @GetMapping("/current")
    public ResponseEntity<UserDto> getCurrentUserInfo() {
        User currentUser = this.userService.getById(this.userDetailsService.getCurrentAuthenticatedUserId());
        UserDto dto = this.userConverter.convertToDto(currentUser);
        return ResponseEntity.ok(dto);
    }

    /**
     * Change current user email and logout.
     *
     * @param changeEmailRequest request body with new email value
     * @return HTTP OK
     */
    @PutMapping("/changeemail")
    public ResponseEntity<Void> changeEmail(@Valid @RequestBody ChangeEmailRequest changeEmailRequest, OAuth2Authentication authentication) {
        String currentUserId = this.userDetailsService.getCurrentAuthenticatedUserId();
        this.userService.changeUserEmail(changeEmailRequest.getEmail(), currentUserId);
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
    public ResponseEntity<Void> changePassword(@Valid @RequestBody ChangePasswordRequest changePasswordRequest, OAuth2Authentication authentication) {
        String currentUserId = this.userDetailsService.getCurrentAuthenticatedUserId();
        this.userService.changeUserPassword(changePasswordRequest.getNewPassword(), currentUserId);
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
    public ResponseEntity<Void> changeName(@Valid @RequestBody ChangeUserNamesRequest changeRequest) {
        String currentUserId = this.userDetailsService.getCurrentAuthenticatedUserId();
        this.userService.changeUserNames(changeRequest.getFirstName(), changeRequest.getLastName(), currentUserId);
        return ResponseEntity.ok().build();
    }
}
