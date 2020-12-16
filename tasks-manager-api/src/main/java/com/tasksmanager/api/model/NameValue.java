package com.tasksmanager.api.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * Simple name-value response model.
 *
 * @author SIE
 */
@Getter
@Setter
@ToString
public class NameValue {

    private String name;

    private Object value;

    public NameValue(String name, Object value) {
        this.name = name;
        this.value = value;
    }

    public NameValue(String name) {
        this(name, null);
    }
}
