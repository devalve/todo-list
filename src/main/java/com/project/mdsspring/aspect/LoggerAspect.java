package com.project.mdsspring.aspect;

import com.project.mdsspring.annotation.Loggable;
import com.project.mdsspring.service.context.UserContext;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(2)
public class LoggerAspect {
    private final UserContext userContext;

    public LoggerAspect(UserContext userContext) {
        this.userContext = userContext;
    }

    @After("@annotation(loggable)")
    public void logger(JoinPoint joinPoint, Loggable loggable) {
        String nickname = userContext.getNickname();

        System.out.printf(
                "[nickname = %s] Execute: %s",
                nickname, joinPoint.getSignature().getName()
        );
    }
}
