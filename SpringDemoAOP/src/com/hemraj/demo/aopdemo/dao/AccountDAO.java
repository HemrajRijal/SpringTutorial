package com.hemraj.demo.aopdemo.dao;

import org.springframework.stereotype.Component;

/**
 * Author: hemraj
 * Date:  3/7/18.
 */
@Component
public class AccountDAO {

    public void addAccount() {
        System.out.println(getClass() + ":Doing my DB work on background");
    }
}
