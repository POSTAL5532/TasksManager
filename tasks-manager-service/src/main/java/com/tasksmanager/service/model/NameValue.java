package com.tasksmanager.service.model;

/**
 * Simple name-value response model.
 *
 * @author SIE
 */
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

    public NameValue(Object value) {
        this(null, value);
    }

    public NameValue() {
        this(null, null);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Object getValue() {
        return value;
    }

    public void setValue(Object value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "NameValue{" +
            "name='" + name + '\'' +
            ", value=" + value +
            '}';
    }
}
