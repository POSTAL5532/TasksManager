package com.tasksmanager.service.security;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;

import com.tasksmanager.service.controller.auth.AuthController;

/**
 * @author SIE
 */
@Configuration
@EnableResourceServer
public class ResourceServerConfiguration extends ResourceServerConfigurerAdapter {

    @Value("${spring.data.rest.basePath}")
    private String baseUrl;

    @Override
    public void configure(ResourceServerSecurityConfigurer resources) {
        resources.resourceId("api");
    }

    @Override
    public void configure(HttpSecurity http) throws Exception {
        http
            .cors().and().csrf().disable()
            .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
            .and()
            .antMatcher(String.format("%s%s", baseUrl, "/**"))
            .authorizeRequests()
            .antMatchers(
                String.format("%s%s", baseUrl, AuthController.SIGN_IN_URL),
                String.format("%s%s", baseUrl, AuthController.SIGN_UP_URL)
            ).permitAll()
            .antMatchers(String.format("%s%s", baseUrl, "/**")).authenticated()
            .anyRequest().authenticated();
    }
}
