package com.tasksmanager.service.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.tasksmanager.service.model.colourtheme.ColourTheme;
import com.tasksmanager.service.repository.ColourThemeRepository;

/**
 * Colour theme service
 *
 * @author SIE
 */
public interface ColourThemeService extends SaveUpdateRepository<ColourTheme, ColourThemeRepository> {

    /**
     * @param id colour theme id
     * @return colour theme
     */
    ColourTheme getById(String id);

    /**
     * @return colour themes list
     */
    List<ColourTheme> getAll();

    /**
     * Add new colour theme.
     *
     * @param newColourTheme colour theme object
     * @return new colour theme ID
     */
    @Transactional(readOnly = false)
    ColourTheme addNewColourTheme(ColourTheme newColourTheme);
}
