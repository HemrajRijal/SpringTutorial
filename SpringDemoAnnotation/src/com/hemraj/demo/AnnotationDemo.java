package com.hemraj.demo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Author: hemraj
 * Date:  1/26/18.
 */
public class AnnotationDemo {

    public static void main(String[] args) {
        //        Read spring config file
        ClassPathXmlApplicationContext context =
                new ClassPathXmlApplicationContext("applicationContext.xml");

        //get the bean from spring container
        Coach tCoach = context.getBean("tennisCoach", Coach.class);

        //        Call our method
        System.out.println(tCoach.getDailyWorkOut());

        System.out.println(tCoach.getDailyFortune());

        //close the context
        context.close();
    }
}
