package com.tasksmanager.service.model;

import javax.validation.constraints.NotBlank;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * ColourThemeDto DTO model
 *
 * @author SIE
 */
// TODO improve validation (Regex)
@Getter
@Setter
@ToString
public class ColourThemeDto {

    private String id;

    @NotBlank
    private String mainColour;

    @NotBlank
    private String secondaryColour;
}
