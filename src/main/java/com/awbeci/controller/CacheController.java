package com.awbeci.controller;

import com.awbeci.service.CacheService;
import com.awbeci.service.ExCacheService;
import com.awbeci.service.RedisCache;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CacheController {
    @Autowired
    CacheService cacheService;

    @Autowired
    ExCacheService exCacheService;

    @RequestMapping("cache1")
    public String getCache(){
        RedisCache redisCache = new RedisCache("192.168.0.1","8890");
        redisCache.setTimeout(70);
        ExCacheService exCacheService = new ExCacheService(redisCache);
        return "customer cacheinfo by call ExCheService:"+exCacheService.getCache("me");
    }

    @RequestMapping(value = "/cache2")
    public String getCache2(){
        return "autowired cacheinfo:"+cacheService.getCache("me");
    }

    @RequestMapping("/cache3")
    public String getExCache(){
        return "autowired excacheinfo with IoC :"+this.exCacheService.getCache("awbeci");
    }

}
