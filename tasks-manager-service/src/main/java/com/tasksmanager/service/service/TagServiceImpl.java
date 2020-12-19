package com.tasksmanager.service.service;

import java.util.NoSuchElementException;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tasksmanager.service.model.tag.Tag;
import com.tasksmanager.service.repository.TagRepository;

@Service
@Transactional(readOnly = true)
public class TagServiceImpl implements TagService {

    private final TagRepository tagRepository;

    public TagServiceImpl(TagRepository tagRepository) {
        this.tagRepository = tagRepository;
    }

    @Override
    public Tag getById(String id) {
        return this.tagRepository
            .findById(id)
            .orElseThrow(() -> new NoSuchElementException("Tag not found"));
    }

    @Override
    @Transactional(readOnly = false)
    public Tag addNewTask(Tag newTag) {
        return this.save(newTag);
    }

    @Override
    @Transactional(readOnly = false)
    public void changeTag(Tag tag) {
        this.update(tag);
    }

    @Override
    public TagRepository getRepository() {
        return this.tagRepository;
    }
}
