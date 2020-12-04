package com.tasksmanager.service.controller.user;

import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.authentication.OAuth2AuthenticationDetails;
import org.springframework.security.oauth2.provider.token.DefaultTokenServices;
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

    private final DefaultTokenServices tokenServices;

    public UserController(UserService userService, UserConverter userConverter, DefaultTokenServices tokenServices) {
        this.userService = userService;
        this.userConverter = userConverter;
        this.tokenServices = tokenServices;
    }

    /**
     * Return current user info.
     *
     * @return HTTP OK
     */
    @GetMapping("/users/current")
    @AuthorizeLikeUser
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
    @PutMapping("/users/changeemail")
    @AuthorizeLikeUser
    public ResponseEntity<Void> changeEmail(@Valid @RequestBody ChangeEmailRequest changeEmailRequest, OAuth2Authentication authentication) {
        this.userService.changeCurrentUserEmail(changeEmailRequest.getEmail());

        String userToken = ((OAuth2AuthenticationDetails) authentication.getDetails()).getTokenValue();
        tokenServices.revokeToken(userToken);

        return ResponseEntity.ok().build();
    }
}
