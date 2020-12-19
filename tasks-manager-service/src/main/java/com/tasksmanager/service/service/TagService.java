package com.tasksmanager.service.service;

import org.springframework.transaction.annotation.Transactional;

import com.tasksmanager.service.model.tag.Tag;
import com.tasksmanager.service.repository.TagRepository;

/**
 * Tag service.
 *
 * @author SIE
 */
public interface TagService extends SaveUpdateRepository<Tag, TagRepository> {

    /**
     * @param id tag ID
     * @return tag
     */
    Tag getById(String id);

    /**
     * Add new tag.
     *
     * @param newTag new tag object
     * @return new tag ID
     */
    Tag addNewTask(Tag newTag);

    /**
     * Change exist tag.
     *
     * @param tag tag object
     */
    void changeTag(Tag tag);
}
