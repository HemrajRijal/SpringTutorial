package com.hemraj.demo.aopdemo.dao;

import org.springframework.stereotype.Component;

/**
 * Author: hemraj
 * Date:  3/7/18.
 */
@Component
public class MembershipDAO {

    public void addAccount() {
        System.out.println("\n");
        System.out.println(getClass() + "\n Doing Some real stuff on membership part of the file");
    }

    public boolean wannaSleep() {
        System.out.println(getClass()+"-->I am going to sleep");
        return false;
    }
}
