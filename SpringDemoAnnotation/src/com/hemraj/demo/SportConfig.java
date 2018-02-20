package com.hemraj.demo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

/**
 * Author: hemraj
 * Date:  1/31/18.
 */
@Configuration
@PropertySource("classpath:sport.properties")
public class SportConfig {

    //    Define bean for sad fortune service
    public FortuneService sadFortuneService() {
        return new SadFortuneService();
    }


    //    Define bean for swim coach and inject dependency
    @Bean
    public Coach swimCoach() {
        return new SwimCoach(sadFortuneService());
    }

}
