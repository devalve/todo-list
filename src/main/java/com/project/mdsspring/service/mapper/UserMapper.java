package com.project.mdsspring.service.mapper;

import com.project.mdsspring.dto.user.UserWithRolesDto;
import com.project.mdsspring.entity.Role;
import com.project.mdsspring.entity.User;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class UserMapper {
    public UserWithRolesDto mapUserToUserDto(User model) {
        return new UserWithRolesDto(
                model.getId(),
                model.getNickname(),
                model.getRoles().stream().map(Role::getCode).collect(Collectors.toList())
        );
    }

    public List<UserWithRolesDto> mapUserToUserDto(Collection<User> users) {
        return users.stream()
                .map(this::mapUserToUserDto)
                .distinct()
                .collect(Collectors.toList());
    }
}
