package com.project.mdsspring.dto.user.filter;

import com.project.mdsspring.enums.UserField;
import lombok.Getter;

import java.util.Collection;

@Getter
public class UserFilterDto {
    private final UserField userField;

    private final Collection<String> values;

    public UserFilterDto(UserField userField, Collection<String> values) {
        this.userField = userField;
        this.values = values;
    }
    //todo возможно это понадобиться @JsonProperty("userField") UserField userField,
    //                         @JsonProperty("values") Collection<String> values
}
