package com.tasksmanager.service.model;

import javax.validation.constraints.NotBlank;

/**
 * Tag DTO model
 *
 * @author SIE
 */
// TODO improve validation (Regex)
public class TagDto {

    private String id;

    @NotBlank
    private String projectId;

    @NotBlank
    private String colour;

    @NotBlank
    private String value;

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

    public String getColour() {
        return colour;
    }

    public void setColour(String colour) {
        this.colour = colour;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "Tag{" +
            "projectId='" + projectId + '\'' +
            ", colour='" + colour + '\'' +
            ", value='" + value + '\'' +
            ", id='" + id + '\'' +
            '}';
    }
}
