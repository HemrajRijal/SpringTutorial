package com.hem.mvcdemo.validation;

import javax.validation.Constraint;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Author: hemraj
 * Date:  2/7/18.
 */
@Constraint(validatedBy = CourseCodeConstraintValidator.class)
@Target({ElementType.METHOD, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface CourseCode {

    //    Define default course code
    public String value() default "Hem";


    //    Define default error message
    public String message() default "Must start with Hem";


    //   define default groups
    public Class<?>[] groups() default {};


    //    define default payloads
    public Class<?>[] payload() default {};
}
