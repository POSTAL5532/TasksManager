package com.tasksmanager.service.converter;

/**
 * Entity/Dto converter interface
 *
 * @param <E> entity type
 * @param <D> dto type
 * @author SIE
 */
public interface DtoEntityConverter<E, D> extends ToDtoConverter<E, D>, ToEntityConverter<E, D> {

}
