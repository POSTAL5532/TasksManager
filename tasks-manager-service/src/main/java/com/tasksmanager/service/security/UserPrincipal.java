package com.tasksmanager.service.security;

import java.util.Collection;
import java.util.Collections;
import java.util.Objects;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.tasksmanager.data.model.user.User;
import com.tasksmanager.data.model.user.UserConfirmStatus;
import com.tasksmanager.data.model.user.UserStatus;

/**
 * Security user info
 *
 * @author SIE
 */
public class UserPrincipal implements UserDetails {

    private final String id;

    private final String email;

    private final String password;

    private final Collection<? extends GrantedAuthority> authorities;

    private final UserStatus status;

    private final UserConfirmStatus confirmStatus;

    /**
     * Create user principal base on user data
     *
     * @param user user
     * @return user principal
     */
    public static UserPrincipal create(User user) {
        return new UserPrincipal(
            user,
            Collections.singletonList(new SimpleGrantedAuthority(user.getRole().name()))
        );
    }

    public UserPrincipal(User user, Collection<? extends GrantedAuthority> authorities) {
        this.id = user.getId();
        this.email = user.getEmail();
        this.password = user.getPassword();
        this.status = user.getStatus();
        this.confirmStatus = user.getConfirmStatus();
        this.authorities = authorities;
    }

    public String getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public UserStatus getStatus() {
        return status;
    }

    public UserConfirmStatus getConfirmStatus() {
        return confirmStatus;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return this.authorities;
    }

    @Override
    public String getPassword() {
        return this.password;
    }

    @Override
    public String getUsername() {
        return email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        UserPrincipal that = (UserPrincipal) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
