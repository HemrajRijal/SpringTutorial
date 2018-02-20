package com.hemraj.demo;

import org.springframework.stereotype.Component;

import java.util.Random;

/**
 * Author: hemraj
 * Date:  1/30/18.
 */
@Component
public class RandomFortuneService implements FortuneService {
    //    Create String of Array
    private String data[] = {
            "Beware of dog :) ",
            "Diligence is the mother of good luck",
            "The journey is the reward"
    };

    //    Create random number generator
    Random generator = new Random();

    @Override
    public String getDailyFortune() {
        //  Pick random string from array
        int index = generator.nextInt(data.length);
        String fortune = data[index];
        return fortune;
    }
}
