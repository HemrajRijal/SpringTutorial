package com.hemraj.demo.aopdemo;

import com.hemraj.demo.aopdemo.service.TrafficFortuneService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Author: hemraj
 * Date:  3/7/18.
 */
public class AroundDemo {
    public static void main(String[] args) {
//        read spring config java file
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(DemoConfig.class);


//        get the bean from container
        TrafficFortuneService trafficFortuneService = context.getBean("trafficFortuneService", TrafficFortuneService.class);


        System.out.println("Main program: Around demo App");
        System.out.println("Calling Fortune Service");

        String data = trafficFortuneService.getFortune();

        System.out.println("\n My fortune is --->  " + data);

        System.out.println("Finished");

//        close the context
        context.close();

    }
}
