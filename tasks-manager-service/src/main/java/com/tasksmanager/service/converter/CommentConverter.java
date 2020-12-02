package com.tasksmanager.service.converter;

import java.sql.Timestamp;

import org.springframework.stereotype.Service;

import com.tasksmanager.data.model.comment.Comment;
import com.tasksmanager.data.model.comment.CommentEntityType;
import com.tasksmanager.service.model.CommentDto;

/**
 * CommentConverter
 *
 * @author SIE
 */
@Service
public class CommentConverter implements DtoEntityConverter<Comment, CommentDto> {

    @Override
    public Comment convertToEntity(CommentDto dto) {
        Comment comment = new Comment();
        comment.setId(dto.getId());
        comment.setAuthorId(dto.getAuthorId());
        comment.setEntityId(dto.getEntityId());
        comment.setCommentEntityType(CommentEntityType.valueOf(dto.getCommentEntityType()));
        comment.setCreationDate(Timestamp.valueOf(dto.getCreationDate()));
        comment.setChangeDate(Timestamp.valueOf(dto.getChangeDate()));

        return comment;
    }

    @Override
    public CommentDto convertToDto(Comment entity) {
        CommentDto dto = new CommentDto();
        dto.setId(entity.getId());
        dto.setAuthorId(entity.getAuthorId());
        dto.setEntityId(entity.getEntityId());
        dto.setCommentEntityType(entity.getCommentEntityType().name());
        dto.setCreationDate(entity.getCreationDate().toLocalDateTime());
        dto.setChangeDate(entity.getChangeDate().toLocalDateTime());

        return dto;
    }
}
