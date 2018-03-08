package com.hemraj.demo.aopdemo;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * Author: hemraj
 * Date:  3/7/18.
 */
@Configuration
@EnableAspectJAutoProxy
@ComponentScan("com.hemraj.demo.aopdemo")
public class DemoConfig {

}
