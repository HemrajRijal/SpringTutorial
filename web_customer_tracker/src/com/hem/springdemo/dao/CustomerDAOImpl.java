package com.hem.springdemo.dao;

import com.hem.springdemo.entity.Customer;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

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
        Query<Customer> theQuery = currentSession.createQuery("from Customer order by firstName", Customer.class);

//        execute query and get result
        List<Customer> customers = theQuery.getResultList();

//        return the result
        return customers;
    }

    @Override
    public void saveCustomer(Customer customer) {
//        get the current hibernate session
        Session session = sessionFactory.getCurrentSession();

//        Save/Update the customer
        session.saveOrUpdate(customer);
    }

    @Override
    public Customer getCustomer(int theId) {

//        get current hibernate session
        Session session = sessionFactory.getCurrentSession();

//        Now retrieved/get from database using primary key
        Customer theCustomer = session.get(Customer.class, theId);

        return theCustomer;
    }
}
