package com.hemraj.demo.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

/**
 * Author: hemraj
 * Date:  3/7/18.
 */
@Aspect
@Component
public class MyDemoLoggingAspect {
//    This is where we add all of our related advices for logging

    //    Lets start with @Before annotation
    @Before("execution(public void add*())")
    public void beforeAddAccountAdvice() {
        System.out.println("\n ======> EXecuting before Advice on addAccount");
    }
}
