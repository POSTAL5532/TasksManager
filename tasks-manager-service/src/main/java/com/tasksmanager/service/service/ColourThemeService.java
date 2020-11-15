package com.tasksmanager.service.service;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tasksmanager.data.model.colourtheme.ColourTheme;
import com.tasksmanager.data.repository.ColourThemeRepository;

/**
 * Colour theme service
 *
 * @author SIE
 */
@Service
@Transactional(readOnly = true)
public class ColourThemeService {

    private final ColourThemeRepository colourThemeRepository;

    public ColourThemeService(ColourThemeRepository colourThemeRepository) {
        this.colourThemeRepository = colourThemeRepository;
    }

    public ColourTheme getById(String id) {
        return this.colourThemeRepository
            .findById(id)
            .orElseThrow(() -> new NoSuchElementException("Colour theme not found"));
    }

    public List<ColourTheme> getAll() {
        return this.colourThemeRepository.findAll();
    }

    @Transactional(readOnly = false)
    public String addNewColourTheme(ColourTheme newColourTheme) {
        return this.colourThemeRepository.save(newColourTheme).getId();
    }
}
