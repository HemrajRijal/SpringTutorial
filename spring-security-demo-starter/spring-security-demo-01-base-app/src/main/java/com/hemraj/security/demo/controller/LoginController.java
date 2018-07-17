package com.hemraj.security.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Author: hemraj
 * Date:  7/5/18.
 */
@Controller
public class LoginController {
    @GetMapping("/showMyLoginPage")
    public String showLoginPage() {
        return "fancy-login";
    }
}
