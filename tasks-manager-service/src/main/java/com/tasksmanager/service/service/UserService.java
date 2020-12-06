package com.tasksmanager.service.service;

import java.sql.Date;
import java.time.LocalDate;

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
import com.tasksmanager.service.utils.AuthUtils;

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

    private final AuthUtils authUtils;

    public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder, AuthUtils authUtils) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.authUtils = authUtils;
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
        User current = this.authUtils.getCurrentAuthenticatedUser();
        current.setEmail(email);
        current.setConfirmStatus(UserConfirmStatus.UNCONFIRMED);
        this.userRepository.save(current);
    }

    public void changeCurrentUserPassword(String password) {
        User current = this.authUtils.getCurrentAuthenticatedUser();
        current.setPassword(password);
        this.userRepository.save(current);
    }

    public void changeCurrentUserNames(String firstName, String lastName) {
        User current = this.authUtils.getCurrentAuthenticatedUser();
        current.setFirstName(firstName);
        current.setLastName(lastName);
        this.userRepository.save(current);
    }
}

