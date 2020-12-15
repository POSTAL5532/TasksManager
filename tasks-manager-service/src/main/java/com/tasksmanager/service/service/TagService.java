package com.tasksmanager.service.service;

import java.util.NoSuchElementException;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tasksmanager.data.model.tag.Tag;
import com.tasksmanager.data.repository.TagRepository;

/**
 * Tag service
 *
 * @author SIE
 */
@Service
@Transactional(readOnly = true)
public class TagService {

    private final TagRepository tagRepository;

    public TagService(TagRepository tagRepository) {
        this.tagRepository = tagRepository;
    }

    public Tag getById(String id) {
        return this.tagRepository
            .findById(id)
            .orElseThrow(() -> new NoSuchElementException("Tag not found"));
    }

    @Transactional(readOnly = false)
    public String addNewTask(Tag newTag) {
        return this.tagRepository.save(newTag).getId();
    }

    @Transactional(readOnly = false)
    public void updateTag(Tag tag) {
        this.tagRepository.save(tag);
    }
}
