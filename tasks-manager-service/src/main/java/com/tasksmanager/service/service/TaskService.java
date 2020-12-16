package com.tasksmanager.service.service;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.NoSuchElementException;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tasksmanager.data.model.task.Task;
import com.tasksmanager.data.repository.TaskRepository;

/**
 * Task service
 *
 * @author SIE
 */
@Service
@Transactional(readOnly = true)
public class TaskService {

    private final TaskRepository taskRepository;

    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    /**
     * @param id task id
     * @return task
     */
    public Task getById(String id) {
        return this.taskRepository
            .findById(id)
            .orElseThrow(() -> new NoSuchElementException("Task not found"));
    }

    /**
     * Add new task.
     *
     * @param newTask new task object
     * @return new task ID
     */
    @Transactional(readOnly = false)
    public String addNewTask(Task newTask) {
        newTask.setCreationDate(Timestamp.valueOf(LocalDateTime.now()));
        return this.taskRepository.save(newTask).getId();
    }

    /**
     * Change exist task.
     *
     * @param task task object
     */
    @Transactional(readOnly = false)
    public void changeTask(Task task) {
        task.setChangeDate(Timestamp.valueOf(LocalDateTime.now()));
        this.taskRepository.save(task);
    }
}
