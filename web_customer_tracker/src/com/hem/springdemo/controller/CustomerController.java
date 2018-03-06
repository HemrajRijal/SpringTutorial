package com.hem.springdemo.controller;

import com.hem.springdemo.entity.Customer;
import com.hem.springdemo.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/showFormAdd")
    public String showFormAdd(Model theModel) {
        Customer customers = new Customer();

        theModel.addAttribute("customer", customers);

        return "customer-form";
    }


    @PostMapping("/saveCustomer")
    public String addCustomer(@ModelAttribute("customer") Customer customer) {

//        Save Customer
        customerService.addCustomer(customer);
        return "redirect:/customer/list";
    }


    @GetMapping("/showFormForUpdate")
    public String showFormForUpdate(@RequestParam("customerId") int theId,
                                    Model theModel) {

        // get the customer from our service
        Customer theCustomer = customerService.getCustomer(theId);

        // set customer as a model attribute to pre-populate the form
        theModel.addAttribute("customer", theCustomer);

        // send over to our form
        return "customer-form";
    }
}