package com.tasksmanager.service.service;

import org.springframework.transaction.annotation.Transactional;

import com.tasksmanager.service.model.tag.Tag;

/**
 * Tag service.
 *
 * @author SIE
 */
public interface TagService {

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
    @Transactional(readOnly = false)
    String addNewTask(Tag newTag);

    /**
     * Change exist tag.
     *
     * @param tag tag object
     */
    @Transactional(readOnly = false)
    void changeTag(Tag tag);
}
