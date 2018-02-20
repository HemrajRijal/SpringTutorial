package com.hemraj.demo;

import org.springframework.stereotype.Component;

/**
 * Author: hemraj
 * Date:  1/30/18.
 */
@Component
public class HappyFortuneService implements FortuneService {

    @Override
    public String getDailyFortune() {
        return "Today is your lucy day!";
    }

}
