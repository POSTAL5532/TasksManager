package com.tasksmanager.service.service;

import java.util.NoSuchElementException;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tasksmanager.service.model.tag.Tag;
import com.tasksmanager.service.repository.TagRepository;

/**
 * Tag service.
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

    /**
     * @param id tag ID
     * @return tag
     */
    public Tag getById(String id) {
        return this.tagRepository
            .findById(id)
            .orElseThrow(() -> new NoSuchElementException("Tag not found"));
    }

    /**
     * Add new tag.
     *
     * @param newTag new tag object
     * @return new tag ID
     */
    @Transactional(readOnly = false)
    public String addNewTask(Tag newTag) {
        return this.tagRepository.save(newTag).getId();
    }

    /**
     * Change exist tag.
     *
     * @param tag tag object
     */
    @Transactional(readOnly = false)
    public void changeTag(Tag tag) {
        this.tagRepository.save(tag);
    }
}
