package com.awbeci.service;

import org.springframework.stereotype.Service;

@Service
public class ExCacheService {


    public ExCacheService(ICache iCache) {
        this.iCache = iCache;
    }

    public ExCacheService() {
    }

    public ICache getiCache() {
        return iCache;
    }

    public void setiCache(ICache iCache) {
        this.iCache = iCache;
    }

    ICache iCache;

    public String getCache(String key){
        return iCache.Get(key);
    }
}