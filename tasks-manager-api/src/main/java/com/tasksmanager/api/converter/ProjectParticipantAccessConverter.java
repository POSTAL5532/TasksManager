package com.tasksmanager.api.converter;

import org.springframework.stereotype.Service;

import com.tasksmanager.service.model.project.ProjectParticipantAccess;
import com.tasksmanager.api.model.ProjectParticipantAccessDto;

/**
 * ProjectParticipantAccess/ProjectParticipantAccessDto converter
 *
 * @author SIE
 */
@Service
public class ProjectParticipantAccessConverter implements DtoEntityConverter<ProjectParticipantAccess, ProjectParticipantAccessDto> {

    @Override
    public ProjectParticipantAccessDto convertToDto(ProjectParticipantAccess entity) {
        return null;
    }

    @Override
    public ProjectParticipantAccess convertToEntity(ProjectParticipantAccessDto dto) {
        return null;
    }
}
