package com.awbeci.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Service;

@Service
@ConfigurationProperties(prefix = "cache")
public class CacheService {

    public String getCache_type() {
        return cache_type;
    }

    public void setCache_type(String cache_type) {
        this.cache_type = cache_type;
    }

    //    @Value(value = "${cache.cache_type}")
    String cache_type;

    public String[] getCache_services() {
        return cache_services;
    }

    public void setCache_services(String[] cache_services) {
        this.cache_services = cache_services;
    }

    String[]  cache_services;

    public String getCache(String key){
        for (String s:this.cache_services){
            System.out.println(s);
        }
        return " get cache content:"+cache_type;
    }
}
