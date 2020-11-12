package com.tasksmanager.data.model.colourtheme;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.tasksmanager.data.model.AbstractEntity;

/**
 * Colour themes model
 *
 * @author SIE
 */
@Entity
@Table(name = "colour_themes")
public class ColourTheme extends AbstractEntity {

    private String name;

    @Column(name = "main_colour")
    private String mainColour;

    @Column(name = "secondary_colour")
    private String secondaryColour;

    public ColourTheme() {
        super();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMainColour() {
        return mainColour;
    }

    public void setMainColour(String mainColour) {
        this.mainColour = mainColour;
    }

    public String getSecondaryColour() {
        return secondaryColour;
    }

    public void setSecondaryColour(String secondaryColour) {
        this.secondaryColour = secondaryColour;
    }

    @Override
    public String toString() {
        return "ColourThemes{" +
            "name='" + name + '\'' +
            ", mainColour='" + mainColour + '\'' +
            ", secondaryColour='" + secondaryColour + '\'' +
            ", id='" + id + '\'' +
            '}';
    }
}
