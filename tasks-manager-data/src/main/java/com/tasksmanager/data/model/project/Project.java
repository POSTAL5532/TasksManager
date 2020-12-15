package com.tasksmanager.data.model.project;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;

import com.tasksmanager.data.model.AbstractEntity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * Project model
 *
 * @author SIE
 */
@Entity
@Table(name = "projects")
@Getter
@Setter
@ToString
public class Project extends AbstractEntity {

    private String name;

    @Column(name = "short_name")
    private String shortName;

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
}
