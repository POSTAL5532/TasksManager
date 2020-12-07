package com.tasksmanager.service.converter;

import org.springframework.stereotype.Service;

import com.tasksmanager.data.model.project.UserProjectAccess;
import com.tasksmanager.service.model.UserProjectAccessDto;

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
