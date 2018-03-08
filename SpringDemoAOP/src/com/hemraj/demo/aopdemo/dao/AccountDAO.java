package com.hemraj.demo.aopdemo.dao;

import com.hemraj.demo.aopdemo.Account;
import org.springframework.stereotype.Component;

/**
 * Author: hemraj
 * Date:  3/7/18.
 */
@Component
public class AccountDAO {

    public void addAccount(Account account, boolean vifFlag) {
        System.out.println(getClass() + ":Doing my DB work on background");
    }


    public void goToWork() {
        System.out.println(getClass()+"------->goToWork-------------->");
    }
}
