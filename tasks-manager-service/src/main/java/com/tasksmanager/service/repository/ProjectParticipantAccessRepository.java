package com.tasksmanager.service.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tasksmanager.service.model.project.ProjectParticipantAccess;

/**
 * Project participant access repository.
 *
 * @author SIE
 */
@Repository
public interface ProjectParticipantAccessRepository extends JpaRepository<ProjectParticipantAccess, String> {

    @Override
    Optional<ProjectParticipantAccess> findById(String id);

    Optional<ProjectParticipantAccess> findByProjectId(String projectId);

    Optional<ProjectParticipantAccess> findByUserId(String userId);

    Optional<ProjectParticipantAccess> findByProjectIdAndUserId(String projectId, String userId);
}
