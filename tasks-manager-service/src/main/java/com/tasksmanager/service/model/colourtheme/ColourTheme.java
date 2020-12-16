package com.tasksmanager.service.model.colourtheme;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.tasksmanager.service.model.AbstractEntity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * Colour themes model
 *
 * @author SIE
 */
@Entity
@Table(name = "colour_themes")
@Getter
@Setter
@ToString
public class ColourTheme extends AbstractEntity {

    private String name;

    @Column(name = "main_colour")
    private String mainColour;

    @Column(name = "secondary_colour")
    private String secondaryColour;

    public ColourTheme() {
        super();
    }
}
