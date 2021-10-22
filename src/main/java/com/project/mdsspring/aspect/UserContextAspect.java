package com.project.mdsspring.aspect;

import com.project.mdsspring.service.context.UserContext;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(1)
public class UserContextAspect {


    private final UserContext userContext;

    public UserContextAspect(UserContext userContext) {
        this.userContext = userContext;
    }

    @Before("execution(public * *(..)) && within(@org.springframework.web.bind.annotation.RestController *)")
    public void setUserContext() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String nickname = auth.getName();
        userContext.setNickname(nickname);
    }
}
