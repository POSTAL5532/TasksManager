package com.tasksmanager.data.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

import com.tasksmanager.data.model.user.User;

/**
 * User data repository.
 *
 * @author SIE
 */
@Repository
public interface UserRepository extends JpaRepository<User, String> {

    Optional<User> findById(String id);

    Optional<User> findByEmail(String name);

    Boolean existsByEmail(String email);
}
