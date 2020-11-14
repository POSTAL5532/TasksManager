package com.tasksmanager.data.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tasksmanager.data.model.task.Task;

/**
 * Task data repository.
 *
 * @author SIE
 */
@Repository
public interface TaskRepository extends JpaRepository<Task, String> {

    @Override
    Optional<Task> findById(String s);
}
