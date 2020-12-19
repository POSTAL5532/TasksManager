package com.tasksmanager.service.service;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.NoSuchElementException;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tasksmanager.service.model.comment.Comment;
import com.tasksmanager.service.repository.CommentRepository;

@Service
@Transactional(readOnly = true)
public class CommentServiceImpl implements CommentService {

    private final CommentRepository commentRepository;

    public CommentServiceImpl(CommentRepository commentRepository) {
        this.commentRepository = commentRepository;
    }

    @Override
    public Comment getById(String id) {
        return this.commentRepository
            .findById(id)
            .orElseThrow(() -> new NoSuchElementException("Comment not found"));
    }

    @Override
    @Transactional(readOnly = false)
    public Comment addNewComment(Comment newComment) {
        newComment.setCreationDate(Timestamp.valueOf(LocalDateTime.now()));
        return this.save(newComment);
    }

    @Override
    @Transactional(readOnly = false)
    public void changeComment(Comment comment) {
        comment.setChangeDate(Timestamp.valueOf(LocalDateTime.now()));
        this.update(comment);
    }

    @Override
    public CommentRepository getRepository() {
        return this.commentRepository;
    }
}
