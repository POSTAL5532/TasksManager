package com.tasksmanager.data.model.project;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;

import com.tasksmanager.data.model.AbstractEntity;

/**
 * Project model
 *
 * @author SIE
 */
@Entity
@Table(name = "projects")
public class Project extends AbstractEntity {

    @Column(name = "owner_id")
    private String ownerId;

    private String name;

    private String description;

    @Column(name = "colour_theme_id")
    private String colourThemeId;

    @Enumerated(EnumType.STRING)
    private ProjectStatus status;

    @Column(name = "creation_date")
    private Date creationDate;

    public Project() {
        super();
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

    public ProjectStatus getStatus() {
        return status;
    }

    public void setStatus(ProjectStatus status) {
        this.status = status;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    @Override
    public String toString() {
        return "Project{" +
            "ownerId='" + ownerId + '\'' +
            ", name='" + name + '\'' +
            ", description='" + description + '\'' +
            ", colourThemeId='" + colourThemeId + '\'' +
            ", status=" + status +
            ", creationDate=" + creationDate +
            ", id='" + id + '\'' +
            '}';
    }
}
