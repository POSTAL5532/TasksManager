package com.tasksmanager.api.controller.tag;

import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tasksmanager.service.model.tag.Tag;
import com.tasksmanager.api.converter.TagConverter;
import com.tasksmanager.api.model.TagDto;
import com.tasksmanager.service.service.TagService;

/**
 * Tag data controller
 *
 * @author SIE
 */
@RestController
@RequestMapping("/api/tags")
public class TagController {

    private final TagService tagService;

    private final TagConverter tagConverter;

    public TagController(TagService tagService, TagConverter tagConverter) {
        this.tagService = tagService;
        this.tagConverter = tagConverter;
    }

    @GetMapping("/{id}")
    public ResponseEntity<TagDto> getTag(@PathVariable String id) {
        Tag tag = this.tagService.getById(id);
        return ResponseEntity.ok(this.tagConverter.convertToDto(tag));
    }

    @PostMapping
    public ResponseEntity<String> createTag(@Valid @RequestBody TagDto tag) {
        Tag newTag = this.tagConverter.convertToEntity(tag);
        String newTagId = this.tagService.addNewTask(newTag).getId();
        return ResponseEntity.ok(newTagId);
    }

    @PutMapping
    public ResponseEntity<Void> updateTag(@Valid @RequestBody TagDto tag) {
        Tag changedTag = this.tagConverter.convertToEntity(tag);
        this.tagService.changeTag(changedTag);
        return ResponseEntity.ok().build();
    }
}
