package com.tasksmanager.data.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tasksmanager.data.model.Tag.Tag;

/**
 * Tag data repository.
 *
 * @author SIE
 */
public interface TagRepository extends JpaRepository<Tag, String> {

    Optional<Tag> findById(String id);
}
