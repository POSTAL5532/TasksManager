package com.tasksmanager.api.converter;

import java.sql.Date;
import java.time.LocalDate;

import org.springframework.stereotype.Service;

import com.tasksmanager.service.model.project.Project;
import com.tasksmanager.service.model.project.ProjectStatus;
import com.tasksmanager.api.model.ProjectDto;

/**
 * Project/ProjectDto converter
 *
 * @author SIE
 */
@Service
public class ProjectConverter implements DtoEntityConverter<Project, ProjectDto> {

    @Override
    public Project convertToEntity(ProjectDto dto) {
        Project project = new Project();
        project.setId(dto.getId());
        project.setName(dto.getName());
        project.setShortName(dto.getShortName());
        project.setDescription(dto.getDescription());
        project.setColourThemeId(dto.getColourThemeId());
        project.setStatus(ProjectStatus.valueOf(dto.getStatus()));

        LocalDate creationDate = dto.getCreationDate();

        project.setCreationDate(creationDate != null ? Date.valueOf(creationDate) : null);

        return project;
    }

    @Override
    public ProjectDto convertToDto(Project entity) {
        ProjectDto projectDto = new ProjectDto();
        projectDto.setId(entity.getId());
        projectDto.setName(entity.getName());
        projectDto.setShortName(entity.getShortName());
        projectDto.setDescription(entity.getDescription());
        projectDto.setColourThemeId(entity.getColourThemeId());
        projectDto.setStatus(entity.getStatus().name());
        projectDto.setCreationDate(entity.getCreationDate().toLocalDate());

        return projectDto;
    }
}
