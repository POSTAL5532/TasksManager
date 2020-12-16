package com.tasksmanager.api.security;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;

/**
 * OAuth authorization server configuration
 *
 * @author SIE
 */
@Configuration
@EnableAuthorizationServer
public class OAuthConfiguration extends AuthorizationServerConfigurerAdapter {

    private final TokenStore tokenStore;

    private final AuthenticationManager authenticationManager;

    private final PasswordEncoder passwordEncoder;

    private final UserDetailsService userService;

    @Value("${app.oAuth2.clientId}")
    private String clientId;

    @Value("${app.oAuth2.clientSecret}")
    private String clientSecret;

    @Value("${app.oAuth2.jwtExpirationSeconds}")
    private int accessTokenValiditySeconds;

    @Value("${app.oAuth2.jwtAuthorizedGrantTypes}")
    public String[] authorizedGrantTypes;

    @Value("${app.oAuth2.jwtrefreshTokenValiditySeconds}") // 30 days
    private int refreshTokenValiditySeconds;

    public OAuthConfiguration(TokenStore tokenStore, AuthenticationManager authenticationManager, PasswordEncoder passwordEncoder, UserDetailsService userDetailsServiceImpl) {
        this.authenticationManager = authenticationManager;
        this.passwordEncoder = passwordEncoder;
        this.userService = userDetailsServiceImpl;
        this.tokenStore = tokenStore;
    }

    @Override
    public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
        clients.inMemory()
            .withClient(clientId)
            .secret(passwordEncoder.encode(clientSecret))
            .accessTokenValiditySeconds(accessTokenValiditySeconds)
            .refreshTokenValiditySeconds(refreshTokenValiditySeconds)
            .authorizedGrantTypes(authorizedGrantTypes)
            .scopes("read", "write");
    }

    @Override
    public void configure(final AuthorizationServerEndpointsConfigurer endpoints) {
        endpoints
            .tokenStore(this.tokenStore)
            .accessTokenConverter(accessTokenConverter())
            .userDetailsService(userService)
            .authenticationManager(authenticationManager);
    }

    @Bean
    public JwtAccessTokenConverter accessTokenConverter() {
        return new JwtAccessTokenConverter();
    }
}
