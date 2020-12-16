package com.tasksmanager.api.controller.auth;

import javax.validation.Valid;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.authentication.OAuth2AuthenticationDetails;
import org.springframework.security.oauth2.provider.token.DefaultTokenServices;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tasksmanager.api.controller.auth.payload.SignUpRequest;
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

    private final PasswordEncoder passwordEncoder;

    public AuthController(UserService userService, DefaultTokenServices tokenServices, PasswordEncoder passwordEncoder) {
        this.userService = userService;
        this.tokenServices = tokenServices;
        this.passwordEncoder = passwordEncoder;
    }

    @PostMapping(SIGN_UP_URL)
    public void signUp(@RequestBody @Valid SignUpRequest request) {
        userService.addNewUser(
            request.getFirstName(),
            request.getLastName(),
            request.getEmail(),
            passwordEncoder.encode(request.getPassword())
        );
    }

    @PostMapping("/logout")
    public void logout(OAuth2Authentication authentication) {
        final String userToken = ((OAuth2AuthenticationDetails) authentication.getDetails()).getTokenValue();
        tokenServices.revokeToken(userToken);
    }
}
