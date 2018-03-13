package com.hemraj.demo.aopdemo.dao;

import com.hemraj.demo.aopdemo.Account;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * Author: hemraj
 * Date:  3/7/18.
 */
@Component
public class AccountDAO {
    private String name;

    private String serviceCode;

    public void addAccount(Account account, boolean vifFlag) {
        System.out.println(getClass() + ":Doing my DB work on background");
    }


    public void goToWork() {
        System.out.println(getClass() + "------->goToWork-------------->");
    }

    public String getName() {
        System.out.println(getClass() + ": in getName()");
        return name;
    }

    public void setName(String name) {
        System.out.println(getClass() + ": in setName()");
        this.name = name;
    }

    public String getServiceCode() {
        System.out.println(getClass() + ": in getServiceCode()");
        return serviceCode;
    }

    public void setServiceCode(String serviceCode) {
        System.out.println(getClass() + ": in setServiceCode()");
        this.serviceCode = serviceCode;
    }

    //    Add new method findAccount
    public List<Account> findAccount() {
        List<Account> accounts = new ArrayList<>();

//        create sample accounts
        Account account1 = new Account("Hemraj", "Platinum");
        Account account2 = new Account("Ramesh", "Platinum");
        Account account3 = new Account("Sandip", "Platinum");

//        Add them t0 the account list
        accounts.add(account1);
        accounts.add(account2);
        accounts.add(account3);

        return accounts;
    }

}
