package com.tasksmanager.service.security;

import java.util.Collection;
import java.util.Collections;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.tasksmanager.data.model.user.User;
import com.tasksmanager.data.model.user.UserConfirmStatus;
import com.tasksmanager.data.model.user.UserStatus;

/**
 * Custom UserPrincipal
 *
 * @author SIE
 */
public class UserPrincipal implements UserDetails {

    private String id;

    @JsonIgnore
    private String email;

    @JsonIgnore
    private String password;

    private Collection<? extends GrantedAuthority> authorities;

    private UserStatus status;

    private UserConfirmStatus confirmStatus;

    public UserPrincipal(User user, Collection<? extends GrantedAuthority> authorities) {
        this.id = user.getId();
        this.email = user.getEmail();
        this.password = user.getPassword();
        this.status = user.getStatus();
        this.confirmStatus = user.getConfirmStatus();
        this.authorities = authorities;
    }


    public static UserPrincipal create(User user) {
        return new UserPrincipal(
            user,
            Collections.singletonList(new SimpleGrantedAuthority(user.getRole().name()))
        );
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public String getUsername() {
        return email;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public boolean isAccountNonExpired() {
        return this.confirmStatus.equals(UserConfirmStatus.CONFIRMED);
    }

    @Override
    public boolean isAccountNonLocked() {
        return !this.status.equals(UserStatus.BANNED);
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return !this.status.equals(UserStatus.DELETED);
    }

    @Override
    public String toString() {
        return "UserPrincipal{" +
            "id='" + id + '\'' +
            ", email='" + email + '\'' +
            ", password='" + password + '\'' +
            ", authorities=" + authorities +
            ", status=" + status +
            ", confirmStatus=" + confirmStatus +
            '}';
    }
}
