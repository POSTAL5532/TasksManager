package com.tasksmanager.service.model;

import java.time.LocalDate;

import javax.validation.constraints.NotBlank;

import org.hibernate.validator.constraints.Length;

/**
 * Project DTO model
 *
 * @author SIE
 */
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

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    public String getColourThemeId() {
        return colourThemeId;
    }

    public void setColourThemeId(String colourThemeId) {
        this.colourThemeId = colourThemeId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public LocalDate getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(LocalDate creationDate) {
        this.creationDate = creationDate;
    }

    @Override
    public String toString() {
        return "ProjectDto{" +
            "id='" + id + '\'' +
            ", name='" + name + '\'' +
            ", shortName='" + shortName + '\'' +
            ", description='" + description + '\'' +
            ", colourThemeId='" + colourThemeId + '\'' +
            ", status=" + status +
            ", creationDate=" + creationDate +
            '}';
    }
}
