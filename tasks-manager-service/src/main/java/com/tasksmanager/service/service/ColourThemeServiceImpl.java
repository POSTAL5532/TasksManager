package com.tasksmanager.service.service;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tasksmanager.service.model.colourtheme.ColourTheme;
import com.tasksmanager.service.repository.ColourThemeRepository;

@Service
@Transactional(readOnly = true)
public class ColourThemeServiceImpl implements ColourThemeService {

    private final ColourThemeRepository colourThemeRepository;

    public ColourThemeServiceImpl(ColourThemeRepository colourThemeRepository) {
        this.colourThemeRepository = colourThemeRepository;
    }

    @Override
    public ColourTheme getById(String id) {
        return this.colourThemeRepository
            .findById(id)
            .orElseThrow(() -> new NoSuchElementException("Colour theme not found"));
    }

    @Override
    public List<ColourTheme> getAll() {
        return this.colourThemeRepository.findAll();
    }

    @Override
    @Transactional(readOnly = false)
    public ColourTheme addNewColourTheme(ColourTheme newColourTheme) {
        return this.colourThemeRepository.save(newColourTheme);
    }
}
