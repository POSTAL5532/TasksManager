package com.tasksmanager.service.model;

import java.time.LocalDateTime;

import javax.validation.constraints.NotBlank;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * Comment DTO
 *
 * @author SIE
 */
@Getter
@Setter
@ToString
public class CommentDto {

    private String id;

    @NotBlank
    private String authorId;

    @NotBlank
    private String entityId;

    @NotBlank
    private String commentEntityType;

    @NotBlank
    private String content;

    private LocalDateTime creationDate;

    private LocalDateTime changeDate;
}
