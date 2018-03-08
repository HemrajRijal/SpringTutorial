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
        Account account = new Account();
        accountDAO.addAccount(account, true);
        accountDAO.goToWork();

//        Call the getter and setter methods
        accountDAO.setName("Hemraj");
        accountDAO.setServiceCode("VIP");
        accountDAO.getName();
        accountDAO.getServiceCode();

//        Call the membership business method
        membershipDAO.addAccount();
        membershipDAO.wannaSleep();

//        close the context
        context.close();

    }
}
