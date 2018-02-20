package com.hem.mvcdemo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;


/**
 * Author: hemraj
 * Date:  2/1/18.
 */
@Controller
@RequestMapping("/hello")
public class HelloWordController {

    //    Need controller method to show initial form
    @RequestMapping("/showForm")
    public String showForm() {
        return "hello-world";
    }

    //    Need a controller method to process form
    @RequestMapping("/processForm")
    public String processForm() {
        return "welcome";
    }

    //    Add new method to read data
    @RequestMapping("/processFormVersionTwo")
    public String letsShoutOut(HttpServletRequest request, Model model) {
//        read the request parameter from html form
        String name = request.getParameter("studentName");

//        Convert data all to caps
        name = name.toUpperCase();


//        create the message
        String result = "Yo!  " + name;

//        Add message to the model
        model.addAttribute("message", result);

        return "welcome";

    }


    //    Add new method to read data
    @RequestMapping("/processFormVersionThree")
    public String processFormVersionThree(
            @RequestParam("studentName") String theName, Model model) {

//        Convert data all to caps
        theName = theName.toUpperCase();

        System.out.println("I am printed--------------------");
//        create the message
        String result = "Yo! Friend from v3 " + theName;

//        Add message to the model
        model.addAttribute("message", result);

        return "welcome";

    }


}
