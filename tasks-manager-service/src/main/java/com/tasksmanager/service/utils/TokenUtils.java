package com.tasksmanager.service.utils;

import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.authentication.OAuth2AuthenticationDetails;
import org.springframework.security.oauth2.provider.token.DefaultTokenServices;
import org.springframework.stereotype.Service;

/**
 * Authentication util-class.
 *
 * @author SIE
 */
@Service
public class TokenUtils {

    private final DefaultTokenServices tokenServices;

    public TokenUtils(DefaultTokenServices tokenServices) {
        this.tokenServices = tokenServices;
    }

    public void revokeCurrentUserToken(OAuth2Authentication authentication) {
        String userToken = ((OAuth2AuthenticationDetails) authentication.getDetails()).getTokenValue();
        tokenServices.revokeToken(userToken);
    }
}
