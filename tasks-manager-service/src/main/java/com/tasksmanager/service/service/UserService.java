package com.tasksmanager.service.service;

import java.sql.Date;
import java.time.LocalDate;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tasksmanager.data.model.user.User;
import com.tasksmanager.data.model.user.UserConfirmStatus;
import com.tasksmanager.data.model.user.UserRole;
import com.tasksmanager.data.model.user.UserStatus;
import com.tasksmanager.data.repository.UserRepository;
import com.tasksmanager.service.controller.auth.payload.SignUpRequest;
import com.tasksmanager.service.security.UserPrincipal;

/**
 * User service {@link User}
 *
 * @author SIE
 */
@Service
@Transactional(readOnly = true)
public class UserService {

    private final UserRepository userRepository;

    private final PasswordEncoder passwordEncoder;

    public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public User getById(String id) {
        return this.userRepository
            .findById(id)
            .orElseThrow(() -> new UsernameNotFoundException("User not found with id : " + id));
    }

    public User getByEmail(String email) {
        return this.userRepository
            .findByEmail(email)
            .orElseThrow(() -> new UsernameNotFoundException("User not found with email : " + email));
    }

    public User getCurrentAuthenticatedUser() {
        UserPrincipal principal = (UserPrincipal) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return this.userRepository.findByEmail(principal.getUsername()).orElse(null);
    }

    @Transactional(readOnly = false)
    public String addNewUser(SignUpRequest request) {
        User newUser = new User();
        newUser.setFirstName(request.getFirstName());
        newUser.setLastName(request.getLastName());
        newUser.setEmail(request.getEmail());
        newUser.setPassword(this.passwordEncoder.encode(request.getPassword()));
        newUser.setRole(UserRole.ROLE_USER);
        newUser.setStatus(UserStatus.ACTIVE);
        newUser.setConfirmStatus(UserConfirmStatus.UNCONFIRMED);
        newUser.setRegDate(Date.valueOf(LocalDate.now()));

        return userRepository.save(newUser).getId();
    }

    public Boolean existByEmail(String email) {
        return this.userRepository.existsByEmail(email);
    }

    public void changeCurrentUserEmail(String email) {
        User current = this.getCurrentAuthenticatedUser();
        current.setEmail(email);
        current.setConfirmStatus(UserConfirmStatus.UNCONFIRMED);
        this.userRepository.save(current);
    }
}

