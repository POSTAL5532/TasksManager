package com.tasksmanager.data.model.comment;

import java.sql.Timestamp;

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
 * Comment entity
 *
 * @author SIE
 */
@Entity
@Table(name = "comments")
@Getter
@Setter
@ToString
public class Comment extends AbstractEntity {

    @Column(name = "author_id")
    private String authorId;

    @Column(name = "entity_id")
    private String entityId;

    @Column(name = "entity_type")
    @Enumerated(EnumType.STRING)
    private CommentEntityType commentEntityType;

    private String content;

    @Column(name = "creation_date")
    private Timestamp creationDate;

    @Column(name = "change_date")
    private Timestamp changeDate;

    public Comment() {
        super();
    }
}
