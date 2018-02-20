package com.hemraj.demo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Author: hemraj
 * Date:  1/26/18.
 */
public class JavaConfigDemoApp {

    public static void main(String[] args) {
        //        Read spring config file
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(SportConfig.class);

        //get the bean from spring container
        SwimCoach tCoach = context.getBean("swimCoach", SwimCoach.class);

        //        Call our method
        System.out.println(tCoach.getDailyWorkOut());

        System.out.println(tCoach.getDailyFortune());


//        Call swim fields method
        System.out.println("Email-->" + tCoach.getEmail());
        System.out.println("Team-->" + tCoach.getTeam());
        //close the context
        context.close();
    }
}
