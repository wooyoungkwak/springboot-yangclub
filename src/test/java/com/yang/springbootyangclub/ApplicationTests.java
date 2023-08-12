package com.yang.springbootyangclub;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@EntityScan(
	basePackages ={"com.yang.springbootyangclub"}
)
@Configuration
@EnableAutoConfiguration
@ComponentScan(basePackages = {"com.yang"}, excludeFilters = {@ComponentScan.Filter(SpringBootApplication.class)})
@SpringBootTest
public class ApplicationTests {

	public static void main(String[] args) {
		SpringApplication.run(ApplicationTests.class, args);
	}

}
