package com.project.mdsspring.service;

import com.project.mdsspring.dto.auth.UserAuthInfoDto;
import com.project.mdsspring.dto.registration.UserRegistrationInfoDto;
import com.project.mdsspring.dto.user.UserWithRolesDto;
import com.project.mdsspring.dto.user.filter.UserFilterDto;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

public interface UserService {
    Integer getId(String nickname);

    void editRole(Integer userId, Collection<String> roleCodes);

    List<UserWithRolesDto> getUsers();

    List<UserWithRolesDto> getUsers(Collection<UserFilterDto> filters);

    Optional<UserAuthInfoDto> findAuthInfo(String nickname);

    String register(UserRegistrationInfoDto userRegistrationInfoDto);
}
