package com.project.mdsspring.service;

import com.project.mdsspring.dto.user.UserWithRolesDto;
import com.project.mdsspring.dto.user.filter.UserFilterDto;

import java.util.Collection;
import java.util.List;

public interface UserService {
    Integer getId(String nickname);

    void editRole(Integer userId, Collection<String> roleCodes);

    List<UserWithRolesDto> getUsers();

    List<UserWithRolesDto> getUsers(Collection<UserFilterDto> filters);
}
