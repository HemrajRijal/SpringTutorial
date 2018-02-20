package com.hemraj.demo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Author: hemraj
 * Date:  1/30/18.
 */
public class AnnotationBeanScopeDemoApp {

    public static void main(String[] args) {
//        load spring config file
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

//        Retrieve bean from container
        Coach theCoach = context.getBean("tennisCoach", Coach.class);

        Coach alphaCoach = context.getBean("tennisCoach", Coach.class);

        boolean result = (alphaCoach == theCoach);

        System.out.println("Both are Same--->" + result);

        System.out.println("Alpha memory location-->" + alphaCoach);

        System.out.println("the coach memory location-->" + theCoach);

//close the context
        context.close();


    }
}
