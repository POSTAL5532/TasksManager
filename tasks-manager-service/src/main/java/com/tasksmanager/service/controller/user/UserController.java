package com.tasksmanager.service.controller.user;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import com.tasksmanager.data.model.user.User;
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

    public UserController(UserService userService) {
        this.userService = userService;
    }

    /**
     * Возвращает информацию о пользователе
     */
    @GetMapping("/userinfo/{email}")
    @PreAuthorize("hasAnyAuthority(T(com.tasksmanager.data.model.user.UserRole).ROLE_USER.name())")
    public User getUserInfo(@PathVariable String email) {
        return this.userService.getByEmail(email);
    }

    /**
     * Возвращает информацию о пользователе
     */
    @GetMapping("/userinfobyid/{id}")
    @PreAuthorize("hasAnyAuthority(T(com.tasksmanager.data.model.user.UserRole).ROLE_ADMIN.name())")
    public User getUserInfoById(@PathVariable String id) {
        return this.userService.getById(id);
    }

}
