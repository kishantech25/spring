package com.nt.accessor;

import java.io.IOException;
import java.util.Properties;

public class PropertiesAccessor extends AbstractAssesor{
    public PropertiesAccessor(String key){
        super(key);
    }
    @Override
    public Object getData(){
        Properties props =new Properties();
        try{
            props.load(this.getClass().getClassLoader().getResourceAsStream("city.properties"));
        }
        catch (IOException e){
            e.printStackTrace();
        }
        return props;
    }
}
