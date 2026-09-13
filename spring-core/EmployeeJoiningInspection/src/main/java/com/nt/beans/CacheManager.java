package com.nt.beans;

import com.nt.accesser.*;

import java.util.ArrayList;
import java.util.List;

public class CacheManager {
    private static CacheManager instance;
    private Cache cache;
    private List<IAccessor> accessor;

    private CacheManager(){
        accessor =new ArrayList<IAccessor>();
        cache =Cache.getInstance();
        init();
    }
    public void init(){
        accessor.add(new PropertiesAccessor());
        accessor.add(new DBAccessor());
        //it can be as as per need
        accessor.add(new JsonAccesor());
        accessor.add(new XmlAccessor());
        accessor.add(new FileSystemAccessor());

        for(IAccessor iAccessor: accessor){
            cache.put(iAccessor.getKey(),iAccessor.getData());
        }
    }
    public static synchronized CacheManager getInstance(){
        if(instance == null){
            instance =new CacheManager();
        }
        return instance;
    }
}
