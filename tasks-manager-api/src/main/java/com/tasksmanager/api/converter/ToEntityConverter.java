package com.tasksmanager.api.converter;

/**
 * To entity converter interface
 *
 * @author SIE
 */
public interface ToEntityConverter<E, D> {

    /**
     * Convert DTO to entity
     *
     * @param dto dto
     * @return entity
     */
    E convertToEntity(D dto);
}
