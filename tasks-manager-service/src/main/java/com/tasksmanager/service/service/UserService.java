package com.tasksmanager.service.service;

import org.springframework.transaction.annotation.Transactional;

import com.tasksmanager.service.model.user.User;

/**
 * User service {@link User}
 *
 * @author SIE
 */
public interface UserService {

    /**
     * @param id user ID
     * @return user
     */
    User getById(String id);

    /**
     * @param email user email
     * @return user
     */
    User getByEmail(String email);

    /**
     * Add new user.
     *
     * @param firstName usr first name
     * @param lastName  user last name
     * @param email     user email
     * @return new user ID`
     */
    @Transactional(readOnly = false)
    String addNewUser(String firstName, String lastName, String email, String password);

    /**
     * @param email user email
     * @return exist flag
     */
    Boolean existByEmail(String email);

    /**
     * @param email  new email
     * @param userId user ID
     */
    void changeUserEmail(String email, String userId);

    /**
     * @param password new password
     * @param userId   user id
     */
    void changeUserPassword(String password, String userId);

    /**
     * @param firstName new first name
     * @param lastName  new last name
     * @param userId    user id
     */
    void changeUserNames(String firstName, String lastName, String userId);
}
