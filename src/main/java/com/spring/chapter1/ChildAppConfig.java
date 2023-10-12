package com.spring.chapter1;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ChildAppConfig {

    @Bean
    public Hello hello() {
        Hello hello = new Hello();
        hello.setName("Child");
        return hello;
    }
}
