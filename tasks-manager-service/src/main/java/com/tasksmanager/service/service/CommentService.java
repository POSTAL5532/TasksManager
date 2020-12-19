package com.tasksmanager.service.service;

import org.springframework.transaction.annotation.Transactional;

import com.tasksmanager.service.model.comment.Comment;
import com.tasksmanager.service.repository.CommentRepository;

/**
 * Comment service.
 *
 * @author SIE
 */
public interface CommentService extends SaveUpdateRepository<Comment, CommentRepository> {

    /**
     * @param id comment ID
     * @return comment
     */
    Comment getById(String id);

    /**
     * Add new comment.
     *
     * @param newComment comment object
     * @return new comment ID
     */
    Comment addNewComment(Comment newComment);

    /**
     * Change exist comment.
     *
     * @param comment comment object
     */
    void changeComment(Comment comment);
}
