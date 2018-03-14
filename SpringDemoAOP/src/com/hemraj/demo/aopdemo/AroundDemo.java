package com.hemraj.demo.aopdemo;

import com.hemraj.demo.aopdemo.service.TrafficFortuneService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.logging.Logger;

/**
 * Author: hemraj
 * Date:  3/7/18.
 */
public class AroundDemo {
    public static void main(String[] args) {
//        read spring config java file
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(DemoConfig.class);

//        Use Logger (Spring use this to print log)
        Logger myLogger = Logger.getLogger(AroundDemo.class.getName());


//        get the bean from container
        TrafficFortuneService trafficFortuneService = context.getBean("trafficFortuneService", TrafficFortuneService.class);


        myLogger.info("Main program: Around demo App");
        myLogger.info("Calling Fortune Service");

        String data = trafficFortuneService.getFortune();

        myLogger.info("\n My fortune is --->  " + data);

        myLogger.info("Finished");

//        close the context
        context.close();

    }
}
