package com.codegym.borrow_book.aspec;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class BookAspec {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @AfterThrowing("execution(* com.codegym.borrow_book.controller.BookController.*(..))")
    public void logAfterMethodReturn(JoinPoint joinPoint){
        String nameMethod  = joinPoint.getSignature().getName();
        logger.error("tên phương thức " + nameMethod);
    }

    @After("execution( * com.codegym.borrow_book.controller.BookController.*(..))")
    public void clickToBooks(JoinPoint joinPoint) {
        String methodName = joinPoint.getSignature().getName();
        System.err.println("Phương thức được gọi là: " + methodName);
    }

}
