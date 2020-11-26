package com.tasksmanager.service.model;

import java.time.LocalDate;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * Project DTO model
 *
 * @author SIE
 */
// TODO improve validation (Regex)
public class ProjectDto {

    private String id;

    @NotBlank
    private String ownerId;

    @NotBlank
    private String name;

    @NotBlank
    private String shortName;

    @NotBlank
    private String description;

    @NotBlank
    private String colourThemeId;

    @NotNull
    private String status;

    private LocalDate creationDate;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(String ownerId) {
        this.ownerId = ownerId;
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
            ", ownerId='" + ownerId + '\'' +
            ", name='" + name + '\'' +
            ", shortName='" + shortName + '\'' +
            ", description='" + description + '\'' +
            ", colourThemeId='" + colourThemeId + '\'' +
            ", status=" + status +
            ", creationDate=" + creationDate +
            '}';
    }
}
