package com.tasksmanager.service.controller.auth;

import javax.validation.Valid;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tasksmanager.service.controller.auth.payload.SignUpRequest;
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

    public AuthController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping(SIGN_UP_URL)
    public void signUp(@RequestBody @Valid SignUpRequest request) {
        userService.addNewUser(request);
    }

}
