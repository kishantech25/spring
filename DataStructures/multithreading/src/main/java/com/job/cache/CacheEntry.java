package com.job.cache;

public class CacheEntry {
    private final Object value;
    private final long expiryTime;
    public CacheEntry(Object value, long expiryTime){
        this.value = value;
        this.expiryTime = expiryTime;
    }
    public Object getValue(){
        return value;
    }
    public boolean isExpired(){
        return System.currentTimeMillis() > expiryTime;
    }
    public long getExpiryTime(){
        return expiryTime;
    }


}
