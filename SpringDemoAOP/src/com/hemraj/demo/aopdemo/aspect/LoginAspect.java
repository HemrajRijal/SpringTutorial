package com.hemraj.demo.aopdemo.aspect;

import com.hemraj.demo.aopdemo.Account;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import sun.rmi.runtime.Log;

import java.util.logging.Logger;

/**
 * Author: hemraj
 * Date:  3/9/18.
 */
@Component
@Aspect
@Order(2)
public class LoginAspect {

    //    Create Logger
    Logger myLogger = Logger.getLogger(getClass().getName());

    //    Adding After finally Service
    @After("execution(* com.hemraj.demo.aopdemo.dao.AccountDAO.findAccount(..))")
    public void AfterFinallyAdvice(JoinPoint theJoinPoint) {
        //        Display method signature
        MethodSignature methodSignature = (MethodSignature) theJoinPoint.getSignature();
        myLogger.info("Method--->" + methodSignature);
        myLogger.info("\n ======> Executing After Finally Advice on addAccount");
    }

    //    Adding method for AfterThrowing
    @AfterThrowing(pointcut = "execution(* com.hemraj.demo.aopdemo.dao.AccountDAO.findAccount(..))",
            throwing = "exc")
    public void AfterAddAccountAdviceException(JoinPoint theJoinPoint, Throwable exc) {
        myLogger.info("\n ======> Executing After Throwing Advice on addAccount");

//        Display method signature
        MethodSignature methodSignature = (MethodSignature) theJoinPoint.getSignature();
        myLogger.info("Method--->" + methodSignature);

//        Display Exception
        myLogger.info("The Exception we caught is--->" + exc);
    }


    //    @Before("execution(public void add*( ..))")
    @Before("com.hemraj.demo.aopdemo.aspect.AOPExpression.forDAOPackageNoGetterAndSetter()()")
    public void beforeAddAccountAdvice(JoinPoint theJoinPoint) {
        myLogger.info("\n ======> EXecuting before Advice on addAccount");

//        Display method signature
        MethodSignature methodSignature = (MethodSignature) theJoinPoint.getSignature();
        myLogger.info("Method--->" + methodSignature);

//        Display method arguments


//        get the arguments
        Object[] obj = theJoinPoint.getArgs();

//        Loop through arguments and print the arguments
        for (Object tempArg : obj) {
            myLogger.info("tempArg->>>" + tempArg.toString());

            if (tempArg instanceof Account) {
//                downcast and print account specific stuff
                Account theAccount = (Account) tempArg;

                myLogger.info("Account name--->" + theAccount.getName());
                myLogger.info("Account level--->" + theAccount.getLevel());
            }
        }
    }


    //    Adding Around Service demo
    @Around("execution(* com.hemraj.demo.aopdemo.service.TrafficFortuneService.getFortune(..))")
    public Object aroundGetFortuneService(ProceedingJoinPoint theProceedingJoinPoint) throws Throwable {
//        Print out the method we  are advising on
        MethodSignature methodSignature = (MethodSignature) theProceedingJoinPoint.getSignature();
        myLogger.info("Method--->" + methodSignature);
        myLogger.info("\n ======> Executing After Finally Advice on addAccount");

//        get the begin timestamp
        long begin = System.currentTimeMillis();

//        now lets execute the method
        Object result = theProceedingJoinPoint.proceed();

//        get ending timestamp
        long end = System.currentTimeMillis();

//        compute duration and display it
        long duration = end - begin;
        myLogger.info("\n=======>Duration:" + duration / 1000.0 + "seconds");

        return result;
    }
}
