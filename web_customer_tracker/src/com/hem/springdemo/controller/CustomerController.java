package com.hem.springdemo.controller;

import com.hem.springdemo.entity.Customer;
import com.hem.springdemo.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * Author: hemraj
 * Date:  2/26/18.
 */
@Controller
@RequestMapping("/customer")
public class CustomerController {

    //    Need to inject Customer Service
    @Autowired
    private CustomerService customerService;

    @GetMapping("/list")
    public String listCustomers(Model theModel) {

//        get Customer form the DAO
        List<Customer> theCustomers = customerService.getCustomers();

//        Add the customer to the model
        theModel.addAttribute("customers", theCustomers);

        return "list-customers";
    }

}