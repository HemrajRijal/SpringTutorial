package com.hemraj.security.demo.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * Author: hemraj
 * Date:  7/5/18.
 */
@Configuration
@EnableWebSecurity
public class DemoSecurityConfig extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        //add our user to the in memory authentication
        auth.inMemoryAuthentication().withUser("Hemraj").password("test123")
                .roles("Employee");

        auth.inMemoryAuthentication().withUser("ramesh").password("test123")
                .roles("Manager");

        auth.inMemoryAuthentication().withUser("sandip").password("test123")
                .roles("Employee");


        auth.inMemoryAuthentication().withUser("sandesh").password("test123")
                .roles("Admin");

    }
}
