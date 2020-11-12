package com.tasksmanager.data.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tasksmanager.data.model.colourtheme.ColourTheme;

/**
 * Colour theme repository
 *
 * @author SIE
 */
public interface ColourThemeRepository extends JpaRepository<ColourTheme, String> {

    @Override
    Optional<ColourTheme> findById(String id);
}
