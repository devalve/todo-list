package com.project.mdsspring.dto.registration;

import lombok.Getter;

@Getter
public class UserRegistrationInfoDto {

    private final String nickname;

    private final String password;

    public UserRegistrationInfoDto(String nickname,
                                   String password) {
        this.nickname = nickname;
        this.password = password;
    }
}
