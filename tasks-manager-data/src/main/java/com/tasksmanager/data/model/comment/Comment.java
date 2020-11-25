package com.tasksmanager.data.model.comment;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;

import com.tasksmanager.data.model.AbstractEntity;

/**
 * Comment entity
 *
 * @author SIE
 */
@Entity
@Table(name = "comments")
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

    public String getAuthorId() {
        return authorId;
    }

    public void setAuthorId(String authorId) {
        this.authorId = authorId;
    }

    public String getEntityId() {
        return entityId;
    }

    public void setEntityId(String entityId) {
        this.entityId = entityId;
    }

    public CommentEntityType getCommentEntityType() {
        return commentEntityType;
    }

    public void setCommentEntityType(CommentEntityType commentEntityType) {
        this.commentEntityType = commentEntityType;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Timestamp getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Timestamp creationDate) {
        this.creationDate = creationDate;
    }

    public Timestamp getChangeDate() {
        return changeDate;
    }

    public void setChangeDate(Timestamp changeDate) {
        this.changeDate = changeDate;
    }

    @Override
    public String toString() {
        return "Comment{" +
            "authorId='" + authorId + '\'' +
            ", entityId='" + entityId + '\'' +
            ", commentEntityType=" + commentEntityType +
            ", content='" + content + '\'' +
            ", creationDate=" + creationDate +
            ", changeDate=" + changeDate +
            ", id='" + id + '\'' +
            '}';
    }
}
