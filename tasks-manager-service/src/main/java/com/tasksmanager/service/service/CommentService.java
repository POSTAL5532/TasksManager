package com.tasksmanager.service.service;

import org.springframework.transaction.annotation.Transactional;

import com.tasksmanager.service.model.comment.Comment;

/**
 * Comment service.
 *
 * @author SIE
 */
public interface CommentService {

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
    @Transactional(readOnly = false)
    String addNewComment(Comment newComment);

    /**
     * Change exist comment.
     *
     * @param comment comment object
     */
    @Transactional(readOnly = false)
    void changeComment(Comment comment);
}
