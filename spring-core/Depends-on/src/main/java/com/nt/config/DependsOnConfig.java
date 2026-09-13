package com.nt.config;

import com.nt.accessor.IAccessor;
import com.nt.accessor.PropertiesAccessor;
import com.nt.cache.Cache;
import com.nt.cache.CacheManager;
import com.nt.model.GetLoanDetails;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;

import java.util.Arrays;
import java.util.List;

@Configuration
public class DependsOnConfig {

    @Bean("cache")
    public Cache getCache(){
        return Cache.getInstance();
    }
    @Bean("propertiesAccessor")
    public IAccessor propertiesAccessor(){
        return new PropertiesAccessor("cities");
    }
    @Bean("cacheManager")
    public CacheManager getCacheManager(){
        List<IAccessor> accessors = Arrays.asList(propertiesAccessor());
        return new CacheManager(getCache(),accessors);
    }
    @Bean("getLoanDetails")
    @DependsOn("cacheManager")
    public GetLoanDetails getOfgetLoanDetails(){
        GetLoanDetails obj =new GetLoanDetails();
        obj.setCache(getCache());
        return obj;
    }
}
