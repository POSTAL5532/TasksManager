package com.tasksmanager.service.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tasksmanager.service.model.project.UserProjectAccess;

/**
 * User project access repository.
 *
 * @author SIE
 */
@Repository
public interface UserProjectAccessRepository extends JpaRepository<UserProjectAccess, String> {

    @Override
    Optional<UserProjectAccess> findById(String id);

    Optional<UserProjectAccess> findByProjectId(String projectId);

    Optional<UserProjectAccess> findByUserId(String userId);

    Optional<UserProjectAccess> findByProjectIdAndUserId(String projectId, String userId);
}
