package com.tasksmanager.service.converter;

import java.sql.Date;
import java.sql.Timestamp;

import org.springframework.stereotype.Service;

import com.tasksmanager.data.model.task.Task;
import com.tasksmanager.data.model.task.TaskLevel;
import com.tasksmanager.data.model.task.TaskStatus;
import com.tasksmanager.data.model.task.TaskType;
import com.tasksmanager.service.model.TaskDto;

/**
 * Task/TaskDto converter
 *
 * @author SIE
 */
@Service
public class TaskConverter implements DtoEntityConverter<Task, TaskDto> {

    @Override
    public Task convertToEntity(TaskDto dto) {
        Task task = new Task();
        task.setId(dto.getId());
        task.setProjectId(dto.getProjectId());
        task.setParentId(dto.getParentId());
        task.setAuthorId(dto.getAuthorId());
        task.setExecutorId(dto.getExecutorId());
        task.setName(dto.getName());
        task.setShortName(dto.getShortName());
        task.setDescription(dto.getDescription());
        task.setLevel(TaskLevel.valueOf(dto.getLevel()));
        task.setStatus(TaskStatus.valueOf(dto.getStatus()));
        task.setType(TaskType.valueOf(dto.getType()));
        task.setCreationDate(Timestamp.valueOf(dto.getCreationDate()));
        task.setEndingDate(Date.valueOf(dto.getEndingDate()));
        task.setChangeDate(Timestamp.valueOf(dto.getChangeDate()));

        return task;
    }

    @Override
    public TaskDto convertToDto(Task entity) {
        TaskDto taskDto = new TaskDto();
        taskDto.setId(entity.getId());
        taskDto.setProjectId(entity.getProjectId());
        taskDto.setParentId(entity.getParentId());
        taskDto.setAuthorId(entity.getAuthorId());
        taskDto.setExecutorId(entity.getExecutorId());
        taskDto.setName(entity.getName());
        taskDto.setShortName(entity.getShortName());
        taskDto.setDescription(entity.getDescription());
        taskDto.setLevel(entity.getLevel().name());
        taskDto.setStatus(entity.getStatus().name());
        taskDto.setType(entity.getType().name());
        taskDto.setCreationDate(entity.getCreationDate().toLocalDateTime());
        taskDto.setEndingDate(entity.getEndingDate().toLocalDate());
        taskDto.setChangeDate(entity.getChangeDate().toLocalDateTime());

        return taskDto;
    }
}
