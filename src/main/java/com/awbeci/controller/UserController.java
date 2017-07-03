package com.awbeci.controller;

import com.awbeci.model.UserInfo;
import com.awbeci.service.CacheService;
import com.awbeci.service.ExCacheService;
import com.awbeci.service.RedisCache;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    CacheService cacheService;

    @Autowired
    ExCacheService exCacheService;

    @RequestMapping(value = "/user")
    public String getUser(){
//        RedisCache redisCache = new RedisCache("192.168.0.1","8890");
//        redisCache.setTimeout(70);
//        ExCacheService exCacheService = new ExCacheService(redisCache);

//        return "Hello SpringBoot"+cacheService.getCache("me");
        return "this is user and cacheinfo is :"+this.exCacheService.getCache("awbeci");
    }

    @RequestMapping(value = "/userinfo")
    public UserInfo getUserInfo(){
        return new UserInfo("zhangwei","19");
    }
}
