package com.tasksmanager.data.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tasksmanager.data.model.comment.Comment;

/**
 * Comment repository
 *
 * @author SIE
 */
@Repository
public interface CommentRepository extends JpaRepository<Comment, String> {

    Optional<Comment> findById(String id);
}
