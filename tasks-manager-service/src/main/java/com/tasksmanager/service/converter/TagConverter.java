package com.tasksmanager.service.converter;

import org.springframework.stereotype.Service;

import com.tasksmanager.data.model.Tag.Tag;
import com.tasksmanager.service.model.TagDto;

/**
 * Tag/TagDto converter
 *
 * @author SIE
 */
@Service
public class TagConverter implements DtoConverter<Tag, TagDto> {

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
