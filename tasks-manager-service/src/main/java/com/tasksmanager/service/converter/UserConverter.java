package com.tasksmanager.service.converter;

import org.springframework.stereotype.Service;

import com.tasksmanager.data.model.user.User;
import com.tasksmanager.service.model.UserDto;

/**
 * User to UserDto converter
 *
 * @author SIE
 */
@Service
public class UserConverter implements ToDtoConverter<User, UserDto> {

    @Override
    public UserDto convertToDto(User entity) {
        UserDto dto = new UserDto();
        dto.setId(entity.getId());
        dto.setFirstName(entity.getFirstName());
        dto.setLastName(entity.getLastName());
        dto.setEmail(entity.getEmail());
        dto.setRegDate(entity.getRegDate().toLocalDate());
        dto.setConfirmStatus(entity.getConfirmStatus().name());

        return dto;
    }
}
