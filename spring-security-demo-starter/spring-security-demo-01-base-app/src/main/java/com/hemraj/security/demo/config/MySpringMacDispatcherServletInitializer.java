package com.hemraj.security.demo.config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

/**
 * Author: hemraj
 * Date:  7/4/18.
 */
public class MySpringMacDispatcherServletInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {
    @Override
    protected String[] getServletMappings() {
        return new String[]{"/"};
    }

    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class[]{DemoConfig.class};
    }

    @Override
    protected Class<?>[] getRootConfigClasses() {
        return null;
    }
}
