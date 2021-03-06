package com.hem.springdemo.service;

import com.hem.springdemo.dao.CustomerDAO;
import com.hem.springdemo.entity.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Author: hemraj
 * Date:  3/4/18.
 */
@Service
public class CustomerServiceImpl implements CustomerService {

    //    Need to inject Customer DAO
    @Autowired
    private CustomerDAO customerDAO;

    @Override
    @Transactional
    public List<Customer> getCustomers() {
        return customerDAO.getCustomerList();
    }

    @Override
    @Transactional
    public void addCustomer(Customer customer) {
        customerDAO.saveCustomer(customer);
    }

    @Override
    @Transactional
    public Customer getCustomer(int theId) {
        return customerDAO.getCustomer(theId);
    }

    @Override
    @Transactional
    public void deleteCustomer(int theId) {
        customerDAO.deleteCustomer(theId);
    }
}
