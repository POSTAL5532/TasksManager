package com.tasksmanager.api.converter;

import org.springframework.stereotype.Service;

import com.tasksmanager.service.model.tag.Tag;
import com.tasksmanager.api.model.TagDto;

/**
 * Tag/TagDto converter
 *
 * @author SIE
 */
@Service
public class TagConverter implements DtoEntityConverter<Tag, TagDto> {

    @Override
    public Tag convertToEntity(TagDto dto) {
        Tag tag = new Tag();
        tag.setId(dto.getId());
        tag.setProjectId(dto.getProjectId());
        tag.setColour(dto.getColour());
        tag.setValue(dto.getValue());

        return tag;
    }

    @Override
    public TagDto convertToDto(Tag entity) {
        TagDto tagDto = new TagDto();
        tagDto.setId(entity.getId());
        tagDto.setProjectId(entity.getProjectId());
        tagDto.setColour(entity.getColour());
        tagDto.setValue(entity.getValue());

        return tagDto;
    }
}
