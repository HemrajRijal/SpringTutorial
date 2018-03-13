package com.hemraj.demo.aopdemo.aspect;

import com.hemraj.demo.aopdemo.Account;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
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

    //    Adding method for AfterThrowing
    @AfterThrowing(pointcut = "execution(* com.hemraj.demo.aopdemo.dao.AccountDAO.findAccount(..))",
            throwing = "exc")
    public void AfterAddAccountAdviceException(JoinPoint theJoinPoint, Throwable exc) {
        System.out.println("\n ======> Executing After Throwing Advice on addAccount");

//        Display method signature
        MethodSignature methodSignature = (MethodSignature) theJoinPoint.getSignature();
        System.out.println("Method--->" + methodSignature);

//        Display Exception
        System.out.println("The Exception we caught is--->" + exc);
    }


    //    @Before("execution(public void add*( ..))")
    @Before("com.hemraj.demo.aopdemo.aspect.AOPExpression.forDAOPackageNoGetterAndSetter()()")
    public void beforeAddAccountAdvice(JoinPoint theJoinPoint) {
        System.out.println("\n ======> EXecuting before Advice on addAccount");

//        Display method signature
        MethodSignature methodSignature = (MethodSignature) theJoinPoint.getSignature();
        System.out.println("Method--->" + methodSignature);

//        Display method arguments


//        get the arguments
        Object[] obj = theJoinPoint.getArgs();

//        Loop through arguments and print the arguments
        for (Object tempArg : obj) {
            System.out.println("tempArg->>>" + tempArg);

            if (tempArg instanceof Account) {
//                downcast and print account specific stuff
                Account theAccount = (Account) tempArg;

                System.out.println("Account name--->" + theAccount.getName());
                System.out.println("Account level--->" + theAccount.getLevel());
            }
        }
    }
}
