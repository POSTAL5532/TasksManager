package com.tasksmanager.service.controller.task;

import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tasksmanager.data.model.task.Task;
import com.tasksmanager.service.converter.TaskConverter;
import com.tasksmanager.service.model.TaskDto;
import com.tasksmanager.service.service.TaskService;

/**
 * Task data controller
 *
 * @author SIE
 */
@RestController
@RequestMapping("/api/tasks")
public class TasksController {

    private final TaskService taskService;

    private final TaskConverter taskConverter;

    public TasksController(TaskService taskService, TaskConverter taskDtoConverter) {
        this.taskService = taskService;
        this.taskConverter = taskDtoConverter;
    }

    @GetMapping("/{id}")
    public ResponseEntity<TaskDto> getTask(@PathVariable String id) {
        Task task = this.taskService.getById(id);
        return ResponseEntity.ok(this.taskConverter.convertToDto(task));
    }

    @PostMapping
    public ResponseEntity<String> createTask(@Valid @RequestBody TaskDto task) {
        Task newTask = this.taskConverter.convertToEntity(task);
        String newTaskId = this.taskService.addNewTask(newTask);
        return ResponseEntity.ok(newTaskId);
    }

    @PutMapping
    public ResponseEntity<Void> updateTask(@Valid @RequestBody TaskDto task) {
        Task changedTask = this.taskConverter.convertToEntity(task);
        this.taskService.changeTask(changedTask);
        return ResponseEntity.ok().build();
    }
}
