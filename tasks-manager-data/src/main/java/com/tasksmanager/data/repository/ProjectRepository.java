package com.tasksmanager.data.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tasksmanager.data.model.project.Project;

/**
 * Project data repository.
 *
 * @author SIE
 */
@Repository
public interface ProjectRepository extends JpaRepository<Project, String> {

    @Override
    Optional<Project> findById(String s);
}
