package com.tasksmanager.service.service;

import java.sql.Date;
import java.time.LocalDate;
import java.util.NoSuchElementException;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tasksmanager.service.model.user.User;
import com.tasksmanager.service.model.user.UserConfirmStatus;
import com.tasksmanager.service.model.user.UserRole;
import com.tasksmanager.service.model.user.UserStatus;
import com.tasksmanager.service.repository.UserRepository;

/**
 * User service {@link User}
 *
 * @author SIE
 */
@Service
@Transactional(readOnly = true)
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    /**
     * @param id user ID
     * @return user
     */
    public User getById(String id) {
        return userRepository
            .findById(id)
            .orElseThrow(() -> new NoSuchElementException("User not found with id : " + id));
    }

    /**
     * @param email user email
     * @return user
     */
    public User getByEmail(String email) {
        return userRepository
            .findByEmail(email)
            .orElseThrow(() -> new NoSuchElementException("User not found with email : " + email));
    }

    /**
     * Add new user.
     *
     * @param firstName usr first name
     * @param lastName  user last name
     * @param email     user email
     * @return new user ID`
     */
    @Transactional(readOnly = false)
    public String addNewUser(String firstName, String lastName, String email, String password) {
        User newUser = new User();
        newUser.setFirstName(firstName);
        newUser.setLastName(lastName);
        newUser.setEmail(email);
        newUser.setPassword(password);
        newUser.setRole(UserRole.ROLE_USER);
        newUser.setStatus(UserStatus.ACTIVE);
        newUser.setConfirmStatus(UserConfirmStatus.UNCONFIRMED);
        newUser.setRegDate(Date.valueOf(LocalDate.now()));

        return userRepository.save(newUser).getId();
    }

    /**
     * @param email user email
     * @return exist flag
     */
    public Boolean existByEmail(String email) {
        return userRepository.existsByEmail(email);
    }

    /**
     * @param email  new email
     * @param userId user ID
     */
    public void changeUserEmail(String email, String userId) {
        User user = this.getById(userId);
        user.setEmail(email);
        user.setConfirmStatus(UserConfirmStatus.UNCONFIRMED);
        userRepository.save(user);
    }

    /**
     * @param password new password
     * @param userId   user id
     */
    public void changeUserPassword(String password, String userId) {
        User user = this.getById(userId);
        user.setPassword(password);
        userRepository.save(user);
    }

    /**
     * @param firstName new first name
     * @param lastName  new last name
     * @param userId    user id
     */
    public void changeUserNames(String firstName, String lastName, String userId) {
        User user = this.getById(userId);
        user.setFirstName(firstName);
        user.setLastName(lastName);
        this.userRepository.save(user);
    }
}

