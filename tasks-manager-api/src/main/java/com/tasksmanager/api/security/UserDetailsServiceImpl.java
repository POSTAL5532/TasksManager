package com.tasksmanager.api.security;

import java.util.NoSuchElementException;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.tasksmanager.service.model.user.User;
import com.tasksmanager.service.service.UserService;

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
        User user;

        try {
            user = this.userService.getByEmail(email);
        }
        catch (NoSuchElementException exception) {
            throw new UsernameNotFoundException(exception.getMessage());
        }

        return UserPrincipal.create(user);
    }

    public String getCurrentAuthenticatedUserId() {
        return this.getCurrentAuthenticatedUserPrincipal().getId();
    }

    public UserPrincipal getCurrentAuthenticatedUserPrincipal() {
        return (UserPrincipal) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    }
}
