package com.hem.springdemo.dao;

import com.hem.springdemo.entity.Customer;

import java.util.List;

/**
 * Author: hemraj
 * Date:  3/2/18.
 */
public interface CustomerDAO {

    public List<Customer> getCustomerList();

    public void saveCustomer(Customer customer);

    public  Customer getCustomer(int theId);
}
