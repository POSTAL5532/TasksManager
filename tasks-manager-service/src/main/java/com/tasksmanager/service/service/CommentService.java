package com.tasksmanager.service.service;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.NoSuchElementException;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tasksmanager.data.model.comment.Comment;
import com.tasksmanager.data.repository.CommentRepository;

/**
 * Comment service.
 *
 * @author SIE
 */
@Service
@Transactional(readOnly = true)
public class CommentService {

    private final CommentRepository commentRepository;

    public CommentService(CommentRepository commentRepository) {
        this.commentRepository = commentRepository;
    }

    /**
     * @param id comment ID
     * @return comment
     */
    public Comment getById(String id) {
        return this.commentRepository
            .findById(id)
            .orElseThrow(() -> new NoSuchElementException("Comment not found"));
    }

    /**
     * Add new comment.
     *
     * @param newComment comment object
     * @return new comment ID
     */
    @Transactional(readOnly = false)
    public String addNewComment(Comment newComment) {
        newComment.setCreationDate(Timestamp.valueOf(LocalDateTime.now()));
        return this.commentRepository.save(newComment).getId();
    }

    /**
     * Change exist comment.
     *
     * @param comment comment object
     */
    @Transactional(readOnly = false)
    public void changeComment(Comment comment) {
        comment.setChangeDate(Timestamp.valueOf(LocalDateTime.now()));
        this.commentRepository.save(comment);
    }
}
