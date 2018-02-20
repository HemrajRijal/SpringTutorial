package com.hemraj.demo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Author: hemraj
 * Date:  1/30/18.
 */
public class FileFortuneTest {

    public static void main(String[] args) {
// load spring config
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

//        Retrieve bean from xml
        FortuneService fortuneService = context.getBean("fileFortuneService", FortuneService.class);

//        Call method
        System.out.println(fortuneService.getDailyFortune());

//        Close the context
        context.close();

    }
}
