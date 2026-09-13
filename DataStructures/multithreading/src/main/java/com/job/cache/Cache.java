package com.job.cache;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class Cache {
    private static Cache instance;
    private Map<String,Object> dataMap;

    private  Cache(){
        dataMap=new ConcurrentHashMap<>();
    }

    public static synchronized Cache getInstance(){
        if(instance == null){
            instance = new Cache();
        }
        return instance;
    }

    public void put(String key,Object value){
        dataMap.put(key,value);
    }
    public Object get(String key){
        return dataMap.get(key);
    }
    public void remove(String key){
        dataMap.remove(key);
    }
    public void clear(){
        dataMap.clear();
    }
    public Map<String,Object> getDataMap(){
        return dataMap;
    }
    public void setDataMap(Map<String,Object> dataMap){
        this.dataMap = dataMap;
    }
    public boolean containsKey(String key){
        return dataMap.containsKey(key);
    }
    public int size(){
        return dataMap.size();
    }
}

