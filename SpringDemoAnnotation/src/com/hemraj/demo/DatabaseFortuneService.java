package com.hemraj.demo;

import org.springframework.stereotype.Component;

/**
 * Author: hemraj
 * Date:  1/30/18.
 */
@Component
public class DatabaseFortuneService implements FortuneService {
    @Override
    public String getDailyFortune() {
        return "You will get updated fortune from database";
    }
}
