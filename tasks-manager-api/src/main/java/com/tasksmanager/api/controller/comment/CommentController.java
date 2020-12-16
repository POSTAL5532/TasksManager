package com.tasksmanager.api.controller.comment;

import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tasksmanager.service.model.comment.Comment;
import com.tasksmanager.api.converter.CommentConverter;
import com.tasksmanager.api.model.CommentDto;
import com.tasksmanager.service.service.CommentService;

/**
 * Comment data controller
 *
 * @author SIE
 */
@RestController
@RequestMapping("/api/comments")
public class CommentController {

    private final CommentService commentService;

    private final CommentConverter commentConverter;

    public CommentController(CommentService commentService, CommentConverter commentConverter) {
        this.commentService = commentService;
        this.commentConverter = commentConverter;
    }

    @GetMapping("/{id}")
    public ResponseEntity<CommentDto> getComment(@PathVariable String id) {
        Comment comment = this.commentService.getById(id);
        return ResponseEntity.ok(this.commentConverter.convertToDto(comment));
    }

    @PostMapping
    public ResponseEntity<String> createComment(@Valid @RequestBody CommentDto comment) {
        Comment newComment = this.commentConverter.convertToEntity(comment);
        String newCommentId = this.commentService.addNewComment(newComment);
        return ResponseEntity.ok(newCommentId);
    }

    @PutMapping
    public ResponseEntity<Void> updateComment(@Valid @RequestBody CommentDto comment) {
        Comment changedComment = this.commentConverter.convertToEntity(comment);
        this.commentService.changeComment(changedComment);
        return ResponseEntity.ok().build();
    }
}
