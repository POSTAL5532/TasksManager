package com.tasksmanager.api.model;

import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.validation.constraints.NotBlank;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * Task DTO model
 *
 * @author SIE
 */
// TODO improve validation (Regex)
@Getter
@Setter
@ToString
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
}
