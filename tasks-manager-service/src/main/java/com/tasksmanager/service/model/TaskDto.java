package com.tasksmanager.service.model;

import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.validation.constraints.NotBlank;

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

    @NotBlank
    private String shortName;

    private String description;

    @NotBlank
    private String level;

    @NotBlank
    private String status;

    @NotBlank
    private String type;

    @NotBlank
    private LocalDateTime creationDate;

    private LocalDate endingDate;

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

    public String getShortName() {
        return shortName;
    }

    public void setShortName(String shortName) {
        this.shortName = shortName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public LocalDateTime getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(LocalDateTime creationDate) {
        this.creationDate = creationDate;
    }

    public LocalDate getEndingDate() {
        return endingDate;
    }

    public void setEndingDate(LocalDate endingDate) {
        this.endingDate = endingDate;
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
            ", shortName='" + shortName + '\'' +
            ", description='" + description + '\'' +
            ", level=" + level +
            ", status=" + status +
            ", type=" + type +
            ", creationDate=" + creationDate +
            ", endingDate=" + endingDate +
            ", changeDate=" + changeDate +
            '}';
    }
}
