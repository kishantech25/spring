package com.nt.accesser;

import java.io.IOException;
import java.util.Properties;

public class PropertiesAccessor extends AbstractAccessor {
    public PropertiesAccessor(){
        super("cities");
    }
    @Override
    public Object getData() {
        Properties props=new Properties();
        try{
            //load the data from file
            props.load(this.getClass().getClassLoader().getResourceAsStream("city.properties"));
        }catch (IOException e){
            e.printStackTrace();
        }
        return props;
    }
}
