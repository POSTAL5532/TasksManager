package com.tasksmanager.data.model.Tag;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.tasksmanager.data.model.AbstractEntity;

/**
 * Tag entity
 *
 * @author SIE
 */
@Entity
@Table(name = "tags")
public class Tag extends AbstractEntity {

    @Column(name = "project_id")
    private String projectId;

    private String colour;

    private String value;

    public Tag() {
        super();
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
