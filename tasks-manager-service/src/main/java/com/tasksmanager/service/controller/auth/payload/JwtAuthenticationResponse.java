package com.tasksmanager.service.controller.auth.payload;

import com.tasksmanager.service.security.JwtTokenProvider;

/**
 * @author SIE
 */
public class JwtAuthenticationResponse {

    private String token;

    private String tokenType = JwtTokenProvider.TOKEN_START_WITH;

    public JwtAuthenticationResponse(String token) {
        this.token = token;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getTokenType() {
        return tokenType;
    }

    public void setTokenType(String tokenType) {
        this.tokenType = tokenType;
    }
}
