package com.tasksmanager.service.model.tag;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.tasksmanager.service.model.AbstractEntity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * Tag entity
 *
 * @author SIE
 */
@Entity
@Table(name = "tags")
@Getter
@Setter
@ToString
public class Tag extends AbstractEntity {

    @Column(name = "project_id")
    private String projectId;

    private String colour;

    private String value;

    public Tag() {
        super();
    }
}
