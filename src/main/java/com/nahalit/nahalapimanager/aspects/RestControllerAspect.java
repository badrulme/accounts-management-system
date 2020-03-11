package com.nahalit.nahalapimanager.aspects;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;


@Aspect
@Component
public class RestControllerAspect {
    private final Logger logger = LoggerFactory.getLogger(getClass());


    @Before("execution(public * com.nahalit.nahalapimanager.controller.*Controller.*(..))")
    public void generalAllMethodBeforeAspect() {
        logger.info("Before execute all controller method");
    }

    @After("execution(public * com.nahalit.nahalapimanager.controller.*Controller.*(..))")
    public void generalAllMethodAfterAspect() {
        logger.info("After execute all controller method");
    }

    @AfterReturning("execution(public * com.nahalit.nahalapimanager.controller.IN1001Controller.saveInUom(..))")
    public void saveInUomAfterReturning() {
        logger.info("After returning Save InUom");
    }
}
