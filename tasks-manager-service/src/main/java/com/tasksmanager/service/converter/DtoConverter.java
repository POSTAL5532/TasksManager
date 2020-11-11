package com.tasksmanager.service.converter;

/**
 * Entity/Dto converter interface
 *
 * @param <E> entity type
 * @param <D> dto type
 * @author SIE
 */
public interface DtoConverter<E, D> {

    /**
     * Convert DTO to entity
     *
     * @param dto dto
     * @return entity
     */
    E convertToEntity(D dto);

    /**
     * Convert entity to DTO
     *
     * @param entity entity
     * @return dto
     */
    D convertToDto(E entity);
}
