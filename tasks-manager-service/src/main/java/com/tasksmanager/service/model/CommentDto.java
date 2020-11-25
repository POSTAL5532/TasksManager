package com.tasksmanager.service.model;

import java.time.LocalDateTime;

import javax.validation.constraints.NotBlank;

import com.tasksmanager.data.model.comment.CommentEntityType;

/**
 * Comment DTO
 *
 * @author SIE
 */
public class CommentDto {

    private String id;

    @NotBlank
    private String authorId;

    @NotBlank
    private String entityId;

    @NotBlank
    private CommentEntityType commentEntityType;

    @NotBlank
    private String content;

    private LocalDateTime creationDate;

    private LocalDateTime changeDate;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    public LocalDateTime getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(LocalDateTime creationDate) {
        this.creationDate = creationDate;
    }

    public LocalDateTime getChangeDate() {
        return changeDate;
    }

    public void setChangeDate(LocalDateTime changeDate) {
        this.changeDate = changeDate;
    }

    @Override
    public String toString() {
        return "CommentDto{" +
            "id='" + id + '\'' +
            ", authorId='" + authorId + '\'' +
            ", entityId='" + entityId + '\'' +
            ", commentEntityType=" + commentEntityType +
            ", content='" + content + '\'' +
            ", creationDate=" + creationDate +
            ", changeDate=" + changeDate +
            '}';
    }
}
