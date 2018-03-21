package com.hem.springdemo.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.util.logging.Logger;

/**
 * Author: hemraj
 * Date:  3/19/18.
 */
@Component
@Aspect
public class CRMLoggingAspects {
    //    Set up logger
    private Logger myLogger = Logger.getLogger(getClass().getName());

    //    Set up pointcut declaration
    @Pointcut("execution(* com.hem.springdemo.controller.*.*(..))")
    public void forController() {

    }

    //    For Service Package
    @Pointcut("execution(* com.hem.springdemo.service.*.*(..))")
    public void forService() {

    }

    //    For DAO package
    @Pointcut("execution(* com.hem.springdemo.dao.*.*(..))")
    public void forDAO() {

    }

    //    Combine all fot Application flow
    @Pointcut("forController() ||forDAO() || forService()")
    public void forAppFlow() {

    }

    //    Add @Before Annotation
    @Before("forAppFlow()")
    public void before(JoinPoint theJoinPoint) {

//        Display method we are calling
        String theMethod = theJoinPoint.getSignature().toLongString();
        myLogger.info("====>@Before Advice Method====>" + theMethod);


//        Display arguments to the methods
        Object[] args = theJoinPoint.getArgs();

//        Loop through and display arguments
        for (Object tempObject : args) {
            myLogger.info("====> arguments:---" + tempObject);
        }

    }

    // Add @AfterReturning Annotation
    @AfterReturning(pointcut = "forAppFlow()", returning = "result")
    public void afterFlow(JoinPoint theJoinPoint, Object result) {
//        Display method we are calling
        String theMethod = theJoinPoint.getSignature().toLongString();
        myLogger.info("====>@After Returning Advice Method====>" + theMethod);

//      Display the result
        myLogger.info("=====> results----.<=>" + result);
    }
}
