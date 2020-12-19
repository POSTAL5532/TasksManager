package com.tasksmanager.service.service;

import java.util.Optional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.test.context.junit4.SpringRunner;

import com.tasksmanager.service.model.colourtheme.ColourTheme;
import com.tasksmanager.service.repository.ColourThemeRepository;

import junit.framework.TestCase;

/**
 * {@link ColourThemeService} class test.
 */
@RunWith(SpringRunner.class)
public class ColourThemeServiceTest extends TestCase {

    @Mock
    private ColourThemeRepository colourThemeRepository;

    @InjectMocks
    private ColourThemeServiceImpl colourThemeService;

    @Test
    public void testTest() {
        colourThemeService = new ColourThemeServiceImpl(colourThemeRepository);

        ColourTheme testColourTheme = new ColourTheme();
        testColourTheme.setId("testId");
        testColourTheme.setName("Test name");
        testColourTheme.setMainColour("#123456");
        testColourTheme.setSecondaryColour("#789123");

        Mockito.when(colourThemeRepository.findById(testColourTheme.getId())).thenReturn(Optional.of(testColourTheme));

        ColourTheme colourTheme = colourThemeService.getById(testColourTheme.getId());

        assertEquals(testColourTheme, colourTheme);
    }
}
