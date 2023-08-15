package com.yang.springbootyangclub.config;

import com.yang.springbootyangclub.AnnotationSample;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * package name : com.yang.springbootyangclub.config
 * Date : 2023-08-15
 * Author : zilet
 * Project : springboot-yangclub
 * Description :
 */

@Configuration
public class AnnotationConfig {

    @Bean
    public AnnotationSample annotationSample(){
        return new AnnotationSample();
    }

}
