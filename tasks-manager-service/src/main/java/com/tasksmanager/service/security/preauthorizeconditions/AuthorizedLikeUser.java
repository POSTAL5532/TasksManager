package com.tasksmanager.service.security.preauthorizeconditions;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import org.springframework.security.access.prepost.PreAuthorize;

/**
 * ROLE_USER preauthorize.
 *
 * @author SIE
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@PreAuthorize("hasAnyAuthority(T(com.tasksmanager.data.model.user.UserRole).ROLE_USER.name())")
public @interface AuthorizedLikeUser {

}
