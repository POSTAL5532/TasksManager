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
import com.tasksmanager.service.converter.TaskDtoConverter;
import com.tasksmanager.service.model.TaskDto;
import com.tasksmanager.service.service.TaskService;

/**
 * Task data controller
 *
 * @author SIE
 */
@RestController
@RequestMapping("/api")
public class TasksController {

    private final TaskService taskService;

    private final TaskDtoConverter taskDtoConverter;

    public TasksController(TaskService taskService, TaskDtoConverter taskDtoConverter) {
        this.taskService = taskService;
        this.taskDtoConverter = taskDtoConverter;
    }

    @GetMapping("/tasks/{id}")
    public ResponseEntity<TaskDto> getTask(@PathVariable String id) {
        Task task = this.taskService.getById(id);
        return ResponseEntity.ok(this.taskDtoConverter.convertToDto(task));
    }

    @PostMapping("/tasks")
    public ResponseEntity<String> createTask(@Valid @RequestBody TaskDto task) {
        Task newTask = this.taskDtoConverter.convertToEntity(task);
        String newTaskId = this.taskService.addNewTask(newTask);
        return ResponseEntity.ok(newTaskId);
    }

    @PutMapping("/tasks")
    public ResponseEntity<Void> updateTask(@Valid @RequestBody TaskDto task) {
        Task changedTask = this.taskDtoConverter.convertToEntity(task);
        this.taskService.updateTask(changedTask);
        return ResponseEntity.ok().build();
    }
}
