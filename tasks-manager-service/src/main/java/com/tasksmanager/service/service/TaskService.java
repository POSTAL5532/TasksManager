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

    // TODO handle NoSuchElementException to http-response
    public Task getById(String id) {
        return this.taskRepository
            .findById(id)
            .orElseThrow(NoSuchElementException::new);
    }

    @Transactional(readOnly = false)
    public String addNewTask(Task newTask) {
        newTask.setCreationDate(Timestamp.valueOf(LocalDateTime.now()));
        return this.taskRepository.save(newTask).getId();
    }

    @Transactional(readOnly = false)
    public void updateTask(Task task) {
        task.setChangeDate(Timestamp.valueOf(LocalDateTime.now()));
        this.taskRepository.save(task);
    }
}
