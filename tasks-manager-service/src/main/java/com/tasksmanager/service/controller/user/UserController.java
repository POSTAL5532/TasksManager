package com.tasksmanager.service.controller.user;

import org.springframework.web.bind.annotation.*;

import com.tasksmanager.data.model.user.User;
import com.tasksmanager.service.service.UserService;

/**
 * @author SIE
 */
@RestController
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    /**
     * Возвращает информацию о пользователе
     */
    @GetMapping("/userinfo/{email}")
    public User getUserInfo(@PathVariable String email) {
        return this.userService.getByEmail(email);
    }

}
