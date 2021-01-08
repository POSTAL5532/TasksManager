package com.tasksmanager.service.model.task;

import java.sql.Date;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;

import com.tasksmanager.service.model.AbstractEntity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * Task model
 *
 * @author SIE
 */
@Entity
@Table(name = "tasks")
@Getter
@Setter
@ToString
public class Task extends AbstractEntity {

    @Column(name = "project_id")
    private String projectId;

    @Column(name = "parent_task_id")
    private String parentTaskId;

    @Column(name = "author_id")
    private String authorId;

    @Column(name = "executor_id")
    private String executorId;

    private String name;

    @Column(name = "short_name")
    private String shortName;

    private String description;

    @Enumerated(EnumType.STRING)
    private TaskLevel level;

    @Enumerated(EnumType.STRING)
    private TaskStatus status;

    @Enumerated(EnumType.STRING)
    private TaskType type;

    @Column(name = "creation_date")
    private Timestamp creationDate;

    @Column(name = "ending_date")
    private Date endingDate;

    @Column(name = "change_date")
    private Timestamp changeDate;

    public Task() {
        super();
    }
}
