package com.project.mdsspring.dto.user;

import lombok.EqualsAndHashCode;
import lombok.Getter;

import java.util.List;

@Getter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class UserWithRolesDto {

    @EqualsAndHashCode.Include
    private final Integer id;

    private final String nickname;

    private final List<String> codes;

    public UserWithRolesDto(Integer id, String nickname, List<String> codes) {
        this.id = id;
        this.nickname = nickname;
        this.codes = codes;
    }
}
