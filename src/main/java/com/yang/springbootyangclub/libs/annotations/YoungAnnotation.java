package com.yang.springbootyangclub.libs.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * package name : com.yang.springbootyangclub.libs.annotations
 * Date : 2023-08-15
 * Author : zilet
 * Project : springboot-yangclub
 * Description :
 */

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface YoungAnnotation {
    String value() default "";
    String version() default "1.0.0";

}
