package com.tasksmanager.service.service;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.NoSuchElementException;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tasksmanager.service.model.project.Project;
import com.tasksmanager.service.model.task.Task;
import com.tasksmanager.service.repository.TaskRepository;

@Service
@Transactional(readOnly = true)
public class TaskServiceImpl implements TaskService {

    private final TaskRepository taskRepository;

    private final ProjectService projectService;

    public TaskServiceImpl(TaskRepository taskRepository, ProjectService projectService) {
        this.taskRepository = taskRepository;
        this.projectService = projectService;
    }

    @Override
    public Task getById(String id) {
        return this.taskRepository
            .findById(id)
            .orElseThrow(() -> new NoSuchElementException("Task not found"));
    }

    @Override
    @Transactional(readOnly = false)
    public Task addNewTask(Task newTask) {
        Project taskProject = projectService.getById(newTask.getProjectId());
        Long taskNumber = taskRepository.countByProjectId(taskProject.getId());

        newTask.setShortName(String.format("%s-%s", taskProject.getShortName(), taskNumber));
        newTask.setCreationDate(Timestamp.valueOf(LocalDateTime.now()));
        return this.save(newTask);
    }

    @Override
    @Transactional(readOnly = false)
    public void changeTask(Task task) {
        task.setChangeDate(Timestamp.valueOf(LocalDateTime.now()));
        this.update(task);
    }

    @Override
    public TaskRepository getRepository() {
        return this.taskRepository;
    }
}
