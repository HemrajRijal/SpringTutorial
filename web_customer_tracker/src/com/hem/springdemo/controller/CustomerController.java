package com.hem.springdemo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Author: hemraj
 * Date:  2/26/18.
 */
@Controller
@RequestMapping("/customer")
public class CustomerController {
    @RequestMapping("/list")
    public String listCustomers() {
        System.out.println("I am Called>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
        return "list-customers";
    }

}