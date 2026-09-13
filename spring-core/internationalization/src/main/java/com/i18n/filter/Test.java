package com.i18n.filter;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Test {

    public static void main(String[] args) {

        ApplicationContext factory=new AnnotationConfigApplicationContext(MethodCOnfig.class);

        A a =factory.getBean("a",A.class);
        B b =factory.getBean("b",B.class);

        System.out.println(b.hashCode()+" : "+a.hashCode());
    }
}
