package com.hemraj.demo.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * Author: hemraj
 * Date:  3/9/18.
 */
@Component
@Aspect
@Order(1)
public class CloudAnalyticsAspects {

    @Before("com.hemraj.demo.aopdemo.aspect.AOPExpression.forDAOPackageNoGetterAndSetter()")
    public void performCloudAnalytics() {
        System.out.println("=====>Performing cloud analytics operation on a async way");
    }
}
