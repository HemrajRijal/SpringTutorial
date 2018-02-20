package com.hemraj.demo;

/**
 * Author: hemraj
 * Date:  1/31/18.
 */
public class SadFortuneService implements FortuneService {
    @Override
    public String getDailyFortune() {
        return "Today is a sad day :(";
    }
}
