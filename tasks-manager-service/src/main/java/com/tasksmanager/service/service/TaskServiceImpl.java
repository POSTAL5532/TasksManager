package com.tasksmanager.service.service;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.NoSuchElementException;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tasksmanager.service.model.task.Task;
import com.tasksmanager.service.repository.TaskRepository;

@Service
@Transactional(readOnly = true)
public class TaskServiceImpl implements TaskService {

    private final TaskRepository taskRepository;

    public TaskServiceImpl(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    @Override
    public Task getById(String id) {
        return this.taskRepository
            .findById(id)
            .orElseThrow(() -> new NoSuchElementException("Task not found"));
    }

    @Override
    @Transactional(readOnly = false)
    public String addNewTask(Task newTask) {
        newTask.setCreationDate(Timestamp.valueOf(LocalDateTime.now()));
        return this.taskRepository.save(newTask).getId();
    }

    @Override
    @Transactional(readOnly = false)
    public void changeTask(Task task) {
        task.setChangeDate(Timestamp.valueOf(LocalDateTime.now()));
        this.taskRepository.save(task);
    }
}
