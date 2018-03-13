package com.hemraj.demo.aopdemo.aspect;

import com.hemraj.demo.aopdemo.Account;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Author: hemraj
 * Date:  3/13/18.
 */
@Component
@Aspect
public class AfterReturningAspects {

    //Add new advice for after returning on findAccounts Method
    @AfterReturning(
            pointcut = "execution(* com.hemraj.demo.aopdemo.dao.AccountDAO.findAccount(..))",
            returning = "result"
    )
    public void afterReturningFindAccountAdvice(JoinPoint theJoinPoint, List<Account> result) {
//Print out which method we are expecting on
        String method = theJoinPoint.getSignature().toShortString();
        System.out.println("\n Returning after @AfterReturning on method-->" + method);

//        Print out the result of method call
        System.out.println("The result is--->" + result);

//        Lets post-process the data, modify the data

//        Convert the account name to UpperCase
        convertNameToUpperCase(result);

//        Again print the result
        System.out.println("The Modified result is--->" + result);
    }

    private void convertNameToUpperCase(List<Account> result) {
//        Loop through accounts
        for (Account accoutn : result) {
//        get the uppercase version of Name
            String theUpperCaseName = accoutn.getName().toUpperCase();

//        Update the name of account
            accoutn.setName(theUpperCaseName);
        }


    }
}
