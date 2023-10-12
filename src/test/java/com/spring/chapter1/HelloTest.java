package com.spring.chapter1;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.config.RuntimeBeanReference;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.context.support.StaticApplicationContext;

class HelloTest {

    @Test
    @DisplayName("빈 등록 테스트")
    void registerSingletonBean() {
        StaticApplicationContext ac = new StaticApplicationContext();
        ac.registerSingleton("hello1", Hello.class);

        Hello hello1 = ac.getBean("hello1", Hello.class);
        assertThat(hello1).isNotNull();
    }

    @Test
    @DisplayName("BeanDefinition을 바로 만들어 Bean으로 등록하기")
    void BeanDefinitionTest() {
        StaticApplicationContext ac = new StaticApplicationContext();
        RootBeanDefinition helloDef = new RootBeanDefinition(Hello.class);

        // propertyValue는 프러퍼티에 들어갈 값을 지정한다. <name이라는 프러퍼티에 Spring 저장!>
        helloDef.getPropertyValues().addPropertyValue("name", "Spring");

        ac.registerBeanDefinition("hello2", helloDef);
        Hello hello2 = ac.getBean("hello2", Hello.class);

        ac.registerSingleton("hello1", Hello.class);
        Hello hello1 = ac.getBean("hello1", Hello.class);

        assertThat(hello2.sayHello()).isEqualTo("Hello Spring");

        assertThat(hello1).isNotEqualTo(hello2);
        assertThat(ac.getBeanFactory().getBeanDefinitionCount()).isEqualTo(2);
    }

    @Test
    @DisplayName("DI 정보 테스트")
    void DITest() {
        StaticApplicationContext ac = new StaticApplicationContext();
        ac.registerBeanDefinition("printer", new RootBeanDefinition(StringPrinter.class));

        RootBeanDefinition helloDef = new RootBeanDefinition(Hello.class);
        helloDef.getPropertyValues().addPropertyValue("name", "Spring");
        // DI는 다른 빈의 아이디를 프로퍼티에 레퍼런스 타입으로 넣어주면 된다.
        helloDef.getPropertyValues()
            .addPropertyValue("printer", new RuntimeBeanReference("printer"));

        ac.registerBeanDefinition("hello", helloDef);

        Hello hello = ac.getBean("hello", Hello.class);
        hello.print();

        assertThat(ac.getBean("printer").toString()).isEqualTo("Hello Spring");
    }
}