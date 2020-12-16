package com.tasksmanager.api.model;

import java.time.LocalDate;

import javax.validation.constraints.NotBlank;

import org.hibernate.validator.constraints.Length;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * Project DTO model
 *
 * @author SIE
 */
@Getter
@Setter
@ToString
public class ProjectDto {

    private String id;

    @NotBlank
    @Length(min = 2, max = 255)
    private String name;

    @NotBlank
    @Length(min = 2, max = 4)
    private String shortName;

    @NotBlank
    @Length(min = 1, max = 32700)
    private String description;

    @NotBlank
    private String colourThemeId;

    @NotBlank
    private String status;

    private LocalDate creationDate;
}
