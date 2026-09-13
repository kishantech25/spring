package com.nt.beans;

import com.nt.accesser.IAccessor;

import java.util.List;

public class CacheLoader {
    private Cache cache;
    private List<IAccessor> accessors;
    public CacheLoader(Cache cache,List<IAccessor> accessors){
        this.cache=cache;
        this.accessors=accessors;
    }
    public void loadAll(){

        for(IAccessor accessor: accessors){
            cache.put(accessor.getKey(),accessor.getData());
        }
    }
}
