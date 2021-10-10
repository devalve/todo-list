package com.project.mdsspring.service.context.impl;

import com.project.mdsspring.service.context.UserContext;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.RequestScope;

@Component
@RequestScope
public class UserContextImpl implements UserContext {

    @Getter
    @Setter
    private String nickname = null;
}
