package com.tasksmanager.service.utils;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.authentication.OAuth2AuthenticationDetails;
import org.springframework.security.oauth2.provider.token.DefaultTokenServices;
import org.springframework.stereotype.Service;

import com.tasksmanager.data.model.user.User;
import com.tasksmanager.service.security.UserPrincipal;
import com.tasksmanager.service.service.UserService;

/**
 * Authentication util-class.
 *
 * @author SIE
 */
@Service
public class AuthUtils {

    private final UserService userService;

    private final DefaultTokenServices tokenServices;

    public AuthUtils(UserService userService, DefaultTokenServices tokenServices) {
        this.userService = userService;
        this.tokenServices = tokenServices;
    }

    public User getCurrentAuthenticatedUser() {
        UserPrincipal principal = (UserPrincipal) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return this.userService.getByEmail(principal.getUsername());
    }

    public void revokeCurrentUserToken(OAuth2Authentication authentication) {
        String userToken = ((OAuth2AuthenticationDetails) authentication.getDetails()).getTokenValue();
        tokenServices.revokeToken(userToken);
    }
}
