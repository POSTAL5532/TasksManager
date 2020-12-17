package com.tasksmanager.service.service;

import org.springframework.transaction.annotation.Transactional;

import com.tasksmanager.service.model.task.Task;

/**
 * Task service.
 *
 * @author SIE
 */
public interface TaskService {

    /**
     * @param id task id
     * @return task
     */
    Task getById(String id);

    /**
     * Add new task.
     *
     * @param newTask new task object
     * @return new task ID
     */
    @Transactional(readOnly = false)
    String addNewTask(Task newTask);

    /**
     * Change exist task.
     *
     * @param task task object
     */
    @Transactional(readOnly = false)
    void changeTask(Task task);
}
