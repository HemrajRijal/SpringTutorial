package com.hemraj.demo.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * Author: hemraj
 * Date:  3/9/18.
 */
@Aspect
@Component
@Order(3)
public class APiAnalyticsAspects {
    @Before("com.hemraj.demo.aopdemo.aspect.AOPExpression.forDAOPackageNoGetterAndSetter()()")
    public void performAPIAnalytics() {
        System.out.println(" =====> Analysing API");
    }
}
