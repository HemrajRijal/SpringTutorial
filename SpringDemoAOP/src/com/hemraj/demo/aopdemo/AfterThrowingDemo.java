package com.hemraj.demo.aopdemo;

import com.hemraj.demo.aopdemo.dao.AccountDAO;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

/**
 * Author: hemraj
 * Date:  3/7/18.
 */
public class AfterThrowingDemo {
    public static void main(String[] args) {
//        read spring config java file
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(DemoConfig.class);


//        get the bean from container
        AccountDAO accountDAO = context.getBean("accountDAO", AccountDAO.class);

//        call the method to find the accounts
        List<Account> accounts = null;

        try {
            //        Add boolean value to simulate expression
            boolean flag = true;
            accounts = accountDAO.findAccount(flag);
        } catch (Exception ex) {
            System.out.println("Main app caught Exception-->" + ex);
        }


//Display Accounts
        System.out.println("Main Program: After Throwing demo App");
        System.out.println("---------------------------");
        System.out.println(accounts);

//        close the context
        context.close();

    }
}
