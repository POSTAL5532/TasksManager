package com.tasksmanager.api.controller.colourtheme;

import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tasksmanager.service.model.colourtheme.ColourTheme;
import com.tasksmanager.api.converter.ColourThemeConverter;
import com.tasksmanager.api.model.ColourThemeDto;
import com.tasksmanager.service.service.ColourThemeService;

/**
 * ColourTheme data controller
 *
 * @author SIE
 */
@RestController
@RequestMapping("/api/colourthemes")
public class ColourThemeController {

    private final ColourThemeService colourThemeService;

    private final ColourThemeConverter colourThemeConverter;

    public ColourThemeController(ColourThemeService colourThemeService, ColourThemeConverter colourThemeConverter) {
        this.colourThemeService = colourThemeService;
        this.colourThemeConverter = colourThemeConverter;
    }

    @GetMapping
    public ResponseEntity<List<ColourThemeDto>> getAllColourTheme() {
        List<ColourTheme> colourThemes = this.colourThemeService.getAll();
        List<ColourThemeDto> dtoColourTheme = colourThemes.stream()
            .map(this.colourThemeConverter::convertToDto)
            .collect(Collectors.toList());

        return ResponseEntity.ok(dtoColourTheme);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ColourThemeDto> getColourTheme(@PathVariable String id) {
        ColourTheme colourTheme = this.colourThemeService.getById(id);
        return ResponseEntity.ok(this.colourThemeConverter.convertToDto(colourTheme));
    }

    @PostMapping
    public ResponseEntity<String> createColourTheme(@Valid @RequestBody ColourThemeDto colourTheme) {
        ColourTheme newColourTheme = this.colourThemeConverter.convertToEntity(colourTheme);
        String newColourThemeId = this.colourThemeService.addNewColourTheme(newColourTheme).getId();
        return ResponseEntity.ok(newColourThemeId);
    }
}
