package com.tasksmanager.service.model;

import java.time.LocalDateTime;

import javax.validation.constraints.NotBlank;

import com.tasksmanager.data.model.task.TaskLevel;
import com.tasksmanager.data.model.task.TaskStatus;
import com.tasksmanager.data.model.task.TaskType;

/**
 * Task DTO model
 *
 * @author SIE
 */
// TODO improve validation (Regex)
public class TaskDto {

    private String id;

    @NotBlank
    private String projectId;

    @NotBlank
    private String parentId;

    private String authorId;

    private String executorId;

    @NotBlank
    private String name;

    private String description;

    @NotBlank
    private TaskLevel level;

    @NotBlank
    private TaskStatus status;

    @NotBlank
    private TaskType type;

    @NotBlank
    private LocalDateTime creationDate;

    private LocalDateTime changeDate;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getProjectId() {
        return projectId;
    }

    public void setProjectId(String projectId) {
        this.projectId = projectId;
    }

    public String getParentId() {
        return parentId;
    }

    public void setParentId(String parentId) {
        this.parentId = parentId;
    }

    public String getAuthorId() {
        return authorId;
    }

    public void setAuthorId(String authorId) {
        this.authorId = authorId;
    }

    public String getExecutorId() {
        return executorId;
    }

    public void setExecutorId(String executorId) {
        this.executorId = executorId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public TaskLevel getLevel() {
        return level;
    }

    public void setLevel(TaskLevel level) {
        this.level = level;
    }

    public TaskStatus getStatus() {
        return status;
    }

    public void setStatus(TaskStatus status) {
        this.status = status;
    }

    public TaskType getType() {
        return type;
    }

    public void setType(TaskType type) {
        this.type = type;
    }

    public LocalDateTime getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(LocalDateTime creationDate) {
        this.creationDate = creationDate;
    }

    public LocalDateTime getChangeDate() {
        return changeDate;
    }

    public void setChangeDate(LocalDateTime changeDate) {
        this.changeDate = changeDate;
    }

    @Override
    public String toString() {
        return "TaskDto{" +
            "id='" + id + '\'' +
            ", projectId='" + projectId + '\'' +
            ", parentId='" + parentId + '\'' +
            ", authorId='" + authorId + '\'' +
            ", executorId='" + executorId + '\'' +
            ", name='" + name + '\'' +
            ", description='" + description + '\'' +
            ", level=" + level +
            ", status=" + status +
            ", type=" + type +
            ", creationDate=" + creationDate +
            ", changeDate=" + changeDate +
            '}';
    }
}
