package com.nt.cache;

import com.nt.accessor.IAccessor;

import java.util.List;

public class CacheManager {
    private Cache cache;
    private List<IAccessor> accessor;

    public CacheManager(Cache cache,List<IAccessor> accessor){
        this.cache=cache;
        this.accessor=accessor;
        init();
    }
    public void init(){
        for(IAccessor iAccessor: accessor){
            cache.put(iAccessor.getKey(),iAccessor.getData());
        }
    }
}
