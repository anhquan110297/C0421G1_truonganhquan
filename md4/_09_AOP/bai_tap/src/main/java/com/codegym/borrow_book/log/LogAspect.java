package com.codegym.borrow_book.log;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class LogAspect {
    @Pointcut("execution(* com.codegym.borrow_book.controllers.action*(..))")
    public void methodPointCut(){
    }

    @AfterReturning("methodPointCut()")
    public void afterChange (JoinPoint joinPoint){
        System.err.println("The library changed "+joinPoint.getSignature().getName());
    }
}
