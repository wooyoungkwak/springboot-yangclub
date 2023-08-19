package com.yang.springbootyangclub.config;

import com.yang.springbootyangclub.PropertiesSample;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;

/**
 * package name : com.yang.springbootyangclub.config
 * Date : 2023-07-24
 * Author : zilet
 * Project : springboot-yangclub
 * Description :
 */
@Configuration
@PropertySources({
        @PropertySource(value = "file://${user.home}/application.yml", ignoreResourceNotFound = true)
})
public class PropertiesConfig {

    @Value("${spring.datasource.username}")
    private String username;

    @Value("${spring.datasource.password}")
    private String password;

    @Bean
    public PropertiesSample propertiesSample(){
        return new PropertiesSample(username, password);
    }

}
