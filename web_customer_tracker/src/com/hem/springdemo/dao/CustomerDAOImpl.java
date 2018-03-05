package com.hem.springdemo.dao;

import com.hem.springdemo.entity.Customer;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Author: hemraj
 * Date:  3/2/18.
 */
@Repository
public class CustomerDAOImpl implements CustomerDAO {

    //    Need to inject the  Session Factory
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<Customer> getCustomerList() {
//        Get the current hibernate session
        Session currentSession = sessionFactory.getCurrentSession();

//        Create query
        Query<Customer> theQuery = currentSession.createQuery("from Customer ", Customer.class);

//        execute query and get result
        List<Customer> customers = theQuery.getResultList();

//        return the result
        return customers;
    }
}
