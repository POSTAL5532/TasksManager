package com.tasksmanager.api.model;

import javax.validation.constraints.NotBlank;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * Tag DTO model
 *
 * @author SIE
 */
// TODO improve validation (Regex)
@Getter
@Setter
@ToString
public class TagDto {

    private String id;

    @NotBlank
    private String projectId;

    @NotBlank
    private String colour;

    @NotBlank
    private String value;
}
