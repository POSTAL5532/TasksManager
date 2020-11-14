package com.tasksmanager.data.model.task;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;

import com.tasksmanager.data.model.AbstractEntity;

/**
 * Task model
 *
 * @author SIE
 */
// TODO add test data
@Entity
@Table(name = "tasks")
public class Task extends AbstractEntity {

    @Column(name = "project_id")
    private String projectId;

    @Column(name = "parent_id")
    private String parentId;

    @Column(name = "author_id")
    private String authorId;

    @Column(name = "executor_id")
    private String executorId;

    private String name;

    private String description;

    @Enumerated(EnumType.STRING)
    private TaskLevel level;

    private TaskStatus status;

    private TaskType type;

    private String blocking;

    @Column(name = "blocked_by")
    private String blockedBy;

    @Column(name = "creation_date")
    private Timestamp creationDate;

    @Column(name = "change_date")
    private Timestamp changeDate;

    public Task() {
        super();
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

    public String getBlocking() {
        return blocking;
    }

    public void setBlocking(String blocking) {
        this.blocking = blocking;
    }

    public String getBlockedBy() {
        return blockedBy;
    }

    public void setBlockedBy(String blockedBy) {
        this.blockedBy = blockedBy;
    }

    public Timestamp getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Timestamp creationDate) {
        this.creationDate = creationDate;
    }

    public Timestamp getChangeDate() {
        return changeDate;
    }

    public void setChangeDate(Timestamp changeDate) {
        this.changeDate = changeDate;
    }

    @Override
    public String toString() {
        return "Task{" +
            "projectId='" + projectId + '\'' +
            ", parentId='" + parentId + '\'' +
            ", authorId='" + authorId + '\'' +
            ", executorId='" + executorId + '\'' +
            ", name='" + name + '\'' +
            ", description='" + description + '\'' +
            ", level=" + level +
            ", status=" + status +
            ", type=" + type +
            ", blocking='" + blocking + '\'' +
            ", blockedBy='" + blockedBy + '\'' +
            ", creationDate=" + creationDate +
            ", changeDate=" + changeDate +
            ", id='" + id + '\'' +
            '}';
    }
}