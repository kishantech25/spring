package com.lookup.config;

import com.lookup.method.Container;
import com.lookup.method.RequestHandler;
import org.springframework.beans.factory.annotation.Lookup;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class LookMethodInjectionConfig {

    @Bean(name = "container")
    @Scope("singleton")
    public Container getContainer(){
        return new Container();
    }
    @Bean(name = "requestHandler")
    @Scope("prototype")
    @Lookup
    public RequestHandler getRequesthandler(){
        RequestHandler requestHandler =new RequestHandler();
        return requestHandler;

    }

}
