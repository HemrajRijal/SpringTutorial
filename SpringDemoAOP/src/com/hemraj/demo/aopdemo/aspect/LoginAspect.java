package com.hemraj.demo.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * Author: hemraj
 * Date:  3/9/18.
 */
@Component
@Aspect
@Order(2)
public class LoginAspect {

    //    @Before("execution(public void add*( ..))")
    @Before("com.hemraj.demo.aopdemo.aspect.AOPExpression.forDAOPackageNoGetterAndSetter()()")
    public void beforeAddAccountAdvice() {
        System.out.println("\n ======> EXecuting before Advice on addAccount");
    }
}
