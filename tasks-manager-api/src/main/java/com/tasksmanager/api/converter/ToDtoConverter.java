package com.tasksmanager.api.converter;

/**
 * To DTO converter interface
 *
 * @author SIE
 */
public interface ToDtoConverter<E, D> {

    /**
     * Convert entity to DTO
     *
     * @param entity entity
     * @return dto
     */
    D convertToDto(E entity);
}
