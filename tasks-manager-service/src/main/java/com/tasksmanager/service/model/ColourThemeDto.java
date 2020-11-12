package com.tasksmanager.service.model;

import javax.validation.constraints.NotBlank;

/**
 * ColourThemeDto DTO model
 *
 * @author SIE
 */
// TODO improve validation (Regex)
public class ColourThemeDto {

    private String id;

    @NotBlank
    private String mainColour;

    @NotBlank
    private String secondaryColour;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getMainColour() {
        return mainColour;
    }

    public void setMainColour(String mainColour) {
        this.mainColour = mainColour;
    }

    public String getSecondaryColour() {
        return secondaryColour;
    }

    public void setSecondaryColour(String secondaryColour) {
        this.secondaryColour = secondaryColour;
    }

    @Override
    public String toString() {
        return "ColourThemeDto{" +
            "id='" + id + '\'' +
            ", mainColour='" + mainColour + '\'' +
            ", secondaryColour='" + secondaryColour + '\'' +
            '}';
    }
}
