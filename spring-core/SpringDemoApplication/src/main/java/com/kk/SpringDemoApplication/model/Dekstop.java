package com.kk.SpringDemoApplication.model;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary
public class Dekstop implements Computer {

    @Override
    public void compile() {
        System.out.println("Compiling in Dekstop");
    }
}
