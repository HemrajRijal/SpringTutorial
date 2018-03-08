package com.hemraj.demo.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * Author: hemraj
 * Date:  3/7/18.
 */
@Aspect
@Component
public class MyDemoLoggingAspect {

    //    Make a One point expression and re-use
    @Pointcut("execution(* com.hemraj.demo.aopdemo.dao.*.*( ..))")
    public void forDAOPackage() {
    }

    //    create pointcut method for getter
    @Pointcut("execution(* com.hemraj.demo.aopdemo.dao.*.get*( ..))")
    public void forGetter() {

    }


    //    create pointcut method for setter
    @Pointcut("execution(* com.hemraj.demo.aopdemo.dao.*.set*( ..))")
    public void forSetter() {

    }

    //    create pointcut:-Exclude getter and setter and include other method
    @Pointcut("forDAOPackage() && !(forGetter() || forSetter())")
    public void forDAOPackageNoGetterAndSetter() {

    }

//    This is where we add all of our related advices for logging

    //    Lets start with @Before annotation
//    @Before("execution(public void add*( ..))")
    @Before("forDAOPackageNoGetterAndSetter()")
    public void beforeAddAccountAdvice() {
        System.out.println("\n ======> EXecuting before Advice on addAccount");
    }

    @Before("forDAOPackageNoGetterAndSetter()")
    public void performAPIAnalytics() {
        System.out.println(" =====> Analysing API");
    }
}
