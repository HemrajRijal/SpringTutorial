package com.hem.springdemo.service;

import com.hem.springdemo.entity.Customer;

import java.util.List;

/**
 * Author: hemraj
 * Date:  3/4/18.
 */
public interface CustomerService {

    public List<Customer> getCustomers();

    public void addCustomer(Customer customer);

    public Customer getCustomer(int theId);

    public void deleteCustomer(int theId);
}
