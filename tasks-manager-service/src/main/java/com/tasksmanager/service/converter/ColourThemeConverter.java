package com.tasksmanager.service.converter;

import org.springframework.stereotype.Service;

import com.tasksmanager.data.model.colourtheme.ColourTheme;
import com.tasksmanager.service.model.ColourThemeDto;

/**
 * ColourTheme/ColourThemeDto converter
 *
 * @author SIE
 */
@Service
public class ColourThemeConverter implements DtoEntityConverter<ColourTheme, ColourThemeDto> {

    @Override
    public ColourTheme convertToEntity(ColourThemeDto dto) {
        ColourTheme colourTheme = new ColourTheme();
        colourTheme.setId(dto.getId());
        colourTheme.setMainColour(dto.getMainColour());
        colourTheme.setSecondaryColour(dto.getSecondaryColour());

        return colourTheme;
    }

    @Override
    public ColourThemeDto convertToDto(ColourTheme entity) {
        ColourThemeDto colourThemeDto = new ColourThemeDto();
        colourThemeDto.setId(entity.getId());
        colourThemeDto.setMainColour(entity.getMainColour());
        colourThemeDto.setSecondaryColour(entity.getSecondaryColour());

        return colourThemeDto;
    }
}
