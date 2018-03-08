package com.hemraj.demo.aopdemo.dao;

import com.hemraj.demo.aopdemo.Account;
import org.springframework.stereotype.Component;

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

}
