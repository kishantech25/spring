package com.nt.beans;

import java.io.IOException;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.ConcurrentHashMap;

public class Cache {

    private static Cache instance;
    private Map<String, Object> dataMap;

    private Cache(){
        dataMap=new ConcurrentHashMap<String,Object>();
    }
    public static Cache getInstance(){
        if(instance ==null){
            synchronized (Cache.class){
                if (instance == null){
                    instance =new Cache();
                }
            }
        }
        return instance;
    }
    public void put(String key,Object value){
        System.out.println("Storing in Cache");
        dataMap.put(key,value);
    }
    public Object get(String key){
        System.out.println("Getting from cache");
        return dataMap.get(key);
    }
    public boolean containsKey(String key){
        System.out.println("Check in cache");
        return dataMap.containsKey(key);
    }


}
