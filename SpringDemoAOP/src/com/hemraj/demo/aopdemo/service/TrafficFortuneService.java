package com.hemraj.demo.aopdemo.service;

import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

/**
 * Author: hemraj
 * Date:  3/14/18.
 */
@Component
public class TrafficFortuneService {

    public String getFortune() {
//Simulate delay
        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

//        Return fortune
        return "Expect heavy traffic this morning";
    }

    public String getFortune(boolean tripWire) {
        if (tripWire) {
            throw new RuntimeException("Major Accident: Highway is closed");
        }
        return getFortune();
    }
}
