package com.hemraj.demo.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

/**
 * Author: hemraj
 * Date:  3/9/18.
 */
@Aspect
public class AOPExpression {
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
}
