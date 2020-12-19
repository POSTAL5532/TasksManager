package com.tasksmanager.service.service;

import java.util.NoSuchElementException;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import com.tasksmanager.service.model.AbstractEntity;
import com.tasksmanager.service.utils.ArgumentUtils;

/**
 * SaveUpdateRepository provides valid <code>save()</code> and <code>update()</code> methods.
 *
 * @author SIE
 */
public interface SaveUpdateRepository<E extends AbstractEntity, R extends JpaRepository<E, String>> {

    /**
     * @return repository for this service
     */
    R getRepository();

    /**
     * Sve new entity;
     *
     * @param entity new entity object
     * @return entity with initialized id
     */
    @Transactional(readOnly = false)
    default E save(E entity) {
        ArgumentUtils.checkNull(entity.getId(), "New entity id must be null.");
        this.getRepository().save(entity);
        return entity;
    }

    /**
     * Check id entity exist in datasource and update it.
     *
     * @param entity entity for updating
     */
    @Transactional(readOnly = false)
    default void update(E entity) {
        ArgumentUtils.checkNotNull(entity.getId(), "Update entity id must not be null.");

        if (!this.getRepository().existsById(entity.getId())) {
            throw new NoSuchElementException("Entity for update not found");
        }

        this.getRepository().save(entity);
    }
}
