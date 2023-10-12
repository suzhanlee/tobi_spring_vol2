package com.spring.chapter1;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.jndi.support.SimpleJndiBeanFactory;

public class Main {

    // interface
    BeanFactory beanFactory = new SimpleJndiBeanFactory();

    // interface
    ApplicationContext applicationContext = new AnnotationConfigApplicationContext();

}
