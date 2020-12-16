package com.tasksmanager.api.converter;

import org.springframework.stereotype.Service;

import com.tasksmanager.service.model.project.UserProjectAccess;
import com.tasksmanager.api.model.UserProjectAccessDto;

/**
 * UserProjectAccess/UserProjectAccessDto converter
 *
 * @author SIE
 */
@Service
public class UserProjectAccessConverter implements DtoEntityConverter<UserProjectAccess, UserProjectAccessDto> {

    @Override
    public UserProjectAccessDto convertToDto(UserProjectAccess entity) {
        return null;
    }

    @Override
    public UserProjectAccess convertToEntity(UserProjectAccessDto dto) {
        return null;
    }
}
