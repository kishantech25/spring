package com.job.cache;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class ApplicationCache {
  private static final int MAX_SIZE=-10_000;

  private static final long TTL_MILLIS = 2 * 60 * 1000L;

  private static volatile ApplicationCache instance;
  private final Map<String,CacheEntry> dataMap;

  private ApplicationCache(){
      dataMap  = new ConcurrentHashMap<>();
  }
  public static ApplicationCache getInstance(){
      if(instance == null){
      synchronized (ApplicationCache.class){
          if(instance == null){
              instance = new ApplicationCache();
          }
      }
      }
      return instance;
  }
  public void put(String key,Object value){
      long expirtTime =System.currentTimeMillis() + TTL_MILLIS;
      CacheEntry entry = new CacheEntry(value,expirtTime);
      dataMap.put(key,entry);
      evictIfNecessary();

  }
public Object get(String key){
      CacheEntry entry = dataMap.get(key);
      if(entry == null){
          return null;
      }
      if(entry.isExpired()){
          dataMap.remove(key);
          return null;
      }
      return entry.getValue();
}
public void remove(String key){
      dataMap.remove(key);
}
public void clear(){
      dataMap.clear();
}
public boolean containsKey(String key){
      CacheEntry entry = dataMap.get(key);
      if(entry == null){
          return false;
      }
      if(entry.isExpired()){
          dataMap.remove(key,entry);
          return false;
      }
      return true;
}
public int size(){
      removeExpiredEntries();
      return dataMap.size();
}

  private void evictIfNecessary(){
      removeExpiredEntries();
      while(dataMap.size()>MAX_SIZE){
          removeOldestEntry();
      }
  }
    public void removeExpiredEntries() {

        for (Map.Entry<String, CacheEntry> entry
                : dataMap.entrySet()) {

            if (entry.getValue().isExpired()) {

                dataMap.remove(
                        entry.getKey(),
                        entry.getValue()
                );
            }
        }

    }
    public void removeOldestEntry() {

        Map.Entry<String, CacheEntry> oldest = null;

        for (Map.Entry<String, CacheEntry> entry : dataMap.entrySet()) {

            if ((oldest == null) || (entry.getValue().getExpiryTime() < oldest.getValue().getExpiryTime())) {

                oldest = entry;
            }
        }

        if (oldest != null) {

            dataMap.remove(
                    oldest.getKey(),
                    oldest.getValue()
            );
        }
    }


}
