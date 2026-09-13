package com.nt.cache;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class Cache {
    private static Cache instance;
    private Map<String,Object> dataMap;
    private Cache(){
        dataMap=new ConcurrentHashMap<>();
    }
    public static synchronized Cache getInstance(){

           if(instance ==null){
               return instance=new Cache();
           }
           return instance;
    }
    //get Operation
    public Object get(String key){
        return dataMap.get(key);
    }
    //put operations
    public void put(String key,Object value){
        dataMap.put(key,value);
    }
    //contains
    public boolean containsKey(String key){
       return  dataMap.containsKey(key);
    }

}
