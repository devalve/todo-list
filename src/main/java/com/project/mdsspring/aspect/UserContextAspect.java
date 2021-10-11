package com.project.mdsspring.aspect;

import com.project.mdsspring.service.context.UserContext;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Objects;

@Aspect
@Component
@Order(1)
public class UserContextAspect {

    public static final String HEADER_NAME_NICKNAME = "nickname";

    private final UserContext userContext;

    public UserContextAspect(UserContext userContext) {
        this.userContext = userContext;
    }

    @Before("execution(public * *(..)) && within(@org.springframework.web.bind.annotation.RestController *)")
    public void setUserContext() {
        HttpServletRequest request = ((ServletRequestAttributes)
                Objects.requireNonNull(RequestContextHolder.getRequestAttributes())).getRequest();
        String nickname = request.getHeader(HEADER_NAME_NICKNAME);
        userContext.setNickname(nickname);
    }
}
