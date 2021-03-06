package com.hemraj.demo.aopdemo;

import com.hemraj.demo.aopdemo.dao.AccountDAO;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

/**
 * Author: hemraj
 * Date:  3/7/18.
 */
public class AfterReturningDemo {
    public static void main(String[] args) {
//        read spring config java file
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(DemoConfig.class);


//        get the bean from container
        AccountDAO accountDAO = context.getBean("accountDAO", AccountDAO.class);

//        call the method to find the accounts
        List<Account> accounts = accountDAO.findAccount(false);


//Display Accounts
        System.out.println("Main Program: After returning demo App");
        System.out.println("---------------------------");
        System.out.println(accounts);

//        close the context
        context.close();

    }
}
