package com.tasksmanager.service.service;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.tasksmanager.data.model.user.User;
import com.tasksmanager.service.security.UserPrincipal;

/**
 * UserPrincipal service
 *
 * @author SIE
 */
@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    private final UserService userService;

    public UserDetailsServiceImpl(UserService userService) {
        this.userService = userService;
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        User user = this.userService.getByEmail(email);

        return UserPrincipal.create(user);
    }

    public UserDetails loadUserById(String id) throws UsernameNotFoundException {
        return UserPrincipal.create(this.userService.getById(id));
    }
}
