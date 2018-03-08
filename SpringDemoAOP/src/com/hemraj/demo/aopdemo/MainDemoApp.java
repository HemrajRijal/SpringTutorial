package com.hemraj.demo.aopdemo;

import com.hemraj.demo.aopdemo.dao.AccountDAO;
import com.hemraj.demo.aopdemo.dao.MembershipDAO;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Author: hemraj
 * Date:  3/7/18.
 */
public class MainDemoApp {
    public static void main(String[] args) {
//        read spring config java file
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(DemoConfig.class);


//        get the bean from container
        AccountDAO accountDAO = context.getBean("accountDAO", AccountDAO.class);


//        Get the membership bean from container
        MembershipDAO membershipDAO = context.getBean("membershipDAO", MembershipDAO.class);

//        call the business method
        accountDAO.addAccount();

//        Call the membership business method
        membershipDAO.addAccount();

//        close the context
        context.close();

    }
}
