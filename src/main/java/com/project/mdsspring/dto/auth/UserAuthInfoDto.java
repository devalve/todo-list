package com.project.mdsspring.dto.auth;

import lombok.Getter;

import java.util.Set;

@Getter
public class UserAuthInfoDto {
    private final Integer id;

    private final String nickname;

    private final String password;

    private final Set<String> roleCodes;

    public UserAuthInfoDto(Integer id,
                           String nickname,
                           String password,
                           Set<String> roleCodes) {
        this.id = id;
        this.nickname = nickname;
        this.password = password;
        this.roleCodes = roleCodes;
    }
}
