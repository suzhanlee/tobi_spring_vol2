package com.spring;

import static javax.swing.JRootPane.NONE;

import com.spring.chapter1.AppConfig;
import com.spring.chapter1.ChildAppConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

@SpringBootApplication
public class TobiSpringVol2Application {

    public static void main(String[] args) {
//        SpringApplication.run(TobiSpringVol2Application.class, args);
        new SpringApplicationBuilder()
            .sources(TobiSpringVol2Application.class)
            .web(WebApplicationType.NONE)
            .child(AppConfig.class)
            .web(WebApplicationType.NONE)
            .child(ChildAppConfig.class)
            .web(WebApplicationType.NONE)
            .run(args);
    }

}
