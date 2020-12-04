package com.tasksmanager.service.controller.auth;

import javax.validation.Valid;

import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.authentication.OAuth2AuthenticationDetails;
import org.springframework.security.oauth2.provider.token.DefaultTokenServices;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tasksmanager.service.controller.auth.payload.SignUpRequest;
import com.tasksmanager.service.security.preauthorizeconditions.AuthorizeLikeUser;
import com.tasksmanager.service.service.UserService;

/**
 * SignUp/Logout controller
 *
 * @author SIE
 */
@RestController
@RequestMapping("/api")
public class AuthController {

    public static final String SIGN_UP_URL = "/signup";

    private final UserService userService;

    private final DefaultTokenServices tokenServices;

    public AuthController(UserService userService, DefaultTokenServices tokenServices) {
        this.userService = userService;
        this.tokenServices = tokenServices;
    }

    @PostMapping(SIGN_UP_URL)
    public void signUp(@RequestBody @Valid SignUpRequest request) {
        userService.addNewUser(request);
    }

    @PostMapping("/logout")
    @AuthorizeLikeUser
    public void logout(OAuth2Authentication authentication) {
        final String userToken = ((OAuth2AuthenticationDetails) authentication.getDetails()).getTokenValue();
        tokenServices.revokeToken(userToken);
    }
}
