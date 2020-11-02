package com.tasksmanager.service.controller.auth;

import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.tasksmanager.service.controller.auth.payload.JwtAuthenticationResponse;
import com.tasksmanager.service.controller.auth.payload.SignInRequest;
import com.tasksmanager.service.controller.auth.payload.SignUpRequest;
import com.tasksmanager.service.security.JwtTokenProvider;
import com.tasksmanager.service.security.SecurityConfig;
import com.tasksmanager.service.service.UserService;

/**
 * SignIn/SignUp/Logout controller
 *
 * @author SIE
 */
@RestController
public class AuthController {

    private final UserService userService;

    private final AuthenticationManager authenticationManager;

    private final JwtTokenProvider tokenProvider;

    public AuthController(UserService userService, AuthenticationManager authenticationManager, JwtTokenProvider tokenProvider) {
        this.userService = userService;
        this.authenticationManager = authenticationManager;
        this.tokenProvider = tokenProvider;
    }

    @PostMapping(SecurityConfig.SIGN_UP_URL)
    public void signUp(@RequestBody @Valid SignUpRequest request) {
        userService.addNewUser(request);
    }

    @PostMapping(SecurityConfig.SIGN_IN_URL)
    public ResponseEntity<JwtAuthenticationResponse> signIn(@RequestBody @Valid SignInRequest request) {
        Authentication authentication = authenticationManager.authenticate(
            new UsernamePasswordAuthenticationToken(request.getEmail(), request.getPassword())
        );

        SecurityContextHolder.getContext().setAuthentication(authentication);

        String token = tokenProvider.generateToken(authentication);
        return ResponseEntity.ok(new JwtAuthenticationResponse(token));
    }

}
