package com.yamzil.springretrydemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.resilience.annotation.EnableResilientMethods;

@SpringBootApplication
@EnableResilientMethods
public class SpringRetryDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringRetryDemoApplication.class, args);
    }

}
