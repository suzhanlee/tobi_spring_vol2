package com.spring.chapter1;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

class AnnotatedHelloTest {

    @Test
    @DisplayName("빈 스캐너는 @Component를 감지할 수 있다.")
    void beanScanner() {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(
            "com.spring.chapter1"
        );

        AnnotatedHello hello = ctx.getBean("annotatedHello", AnnotatedHello.class);
        assertThat(hello).isNotNull();
    }

}