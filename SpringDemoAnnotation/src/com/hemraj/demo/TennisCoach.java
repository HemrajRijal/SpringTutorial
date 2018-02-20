package com.hemraj.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

/**
 * Author: hemraj
 * Date:  1/26/18.
 */
@Component
public class TennisCoach implements Coach {

    /*We can autowired field using @Autowired on field*/
    private FortuneService fortuneService;

    public TennisCoach() {
       // System.out.println("Inside default constructor");
    }

    //    Auto wired setter method

    //    We can autowired any method
    @Autowired
    @Qualifier("fileFortuneService")
    public void setFortuneService(FortuneService fortuneService) {
        this.fortuneService = fortuneService;
    }

//    We can autowire constructor as ----->
    /*@Autowired
    public TennisCoach(FortuneService theFortuneService) {
        this.fortuneService = theFortuneService;
    }*/

    @Override
    public String getDailyWorkOut() {
        return "Practice Spring  5 hrs Daily";
    }

    @Override
    public String getDailyFortune() {
        return fortuneService.getDailyFortune();
    }

    @PostConstruct
    public void doMyInitStuff() {
        System.out.println("I am doing init stuff :) ");
    }

    @PreDestroy
    public void doMyCleanStuff() {
        System.out.println("I am Cleaning, ready to close :( ");
    }
}
