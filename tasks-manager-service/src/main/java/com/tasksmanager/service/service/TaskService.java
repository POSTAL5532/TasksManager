package com.tasksmanager.service.service;

import org.springframework.transaction.annotation.Transactional;

import com.tasksmanager.service.model.task.Task;
import com.tasksmanager.service.repository.TaskRepository;

/**
 * Task service.
 *
 * @author SIE
 */
public interface TaskService extends SaveUpdateRepository<Task, TaskRepository> {

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
    Task addNewTask(Task newTask);

    /**
     * Change exist task.
     *
     * @param task task object
     */
    void changeTask(Task task);
}
