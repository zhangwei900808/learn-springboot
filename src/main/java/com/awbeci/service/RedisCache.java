package com.awbeci.service;

public class RedisCache implements ICache{

    String ip;
    String port;
    int timeout=60;

    public RedisCache(String ip, String port) {
        this.ip = ip;
        this.port = port;
    }

    public String getIp() {
        return ip;

    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getPort() {
        return port;
    }

    public void setPort(String port) {
        this.port = port;
    }

    public int getTimeout() {
        return timeout;
    }

    public void setTimeout(int timeout) {
        this.timeout = timeout;
    }

    @Override
    public String Get(String key) {
        return "获取redis缓存，key是："+key+",ip是："+this.getIp()+"，端口是："+this.getPort()+",超时时间是："+getTimeout();
    }
}
