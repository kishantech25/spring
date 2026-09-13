package com.i18n.filter;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MethodCOnfig {

    @Bean(name = "a")
    public A getA(){
        return new A();
    }

    @Bean(name = "b")
    public B getB()
    {
        return new B();
    }

}
