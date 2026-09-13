package com.nt.config;

import org.glassfish.jersey.server.ResourceConfig;

public class MyApplication extends ResourceConfig {

    public MyApplication(){
        packages("com.nt.service");
    }
}
