package com.awbeci.config;

import com.awbeci.service.CacheService;
import com.awbeci.service.ExCacheService;
import com.awbeci.service.RedisCache;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;

@Configuration
public class MyConfig {

    @Value("${cache.cache_timeout}")
    int timeout;

    @Bean
    public RedisCache redisCache(){
        RedisCache r = new RedisCache("127.0.0.2","6690");
        r.setTimeout(this.timeout);
        return r;
    }

    //注意：这里的方法名(类似配置文件里的bean id)和autowire里面的类变量名要一样
    @Bean
    public ExCacheService exCacheService(){
        ExCacheService exCacheService = new ExCacheService(this.redisCache());
        return exCacheService;
    }

    //优先application.properties配置，
    @Bean
    public DataSource dataSource(){
        org.apache.tomcat.jdbc.pool.DataSource dataSource = new org.apache.tomcat.jdbc.pool.DataSource();
        dataSource.setUrl("jdbc:mysql://192.168.10.10:3306/awbeci?characterEncoding=utf-8");
        dataSource.setUsername("homestead");
        dataSource.setPassword("secret");
        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
        return dataSource;
    }

    //设置事务
    @Bean
    public DataSourceTransactionManager dataSourceTransactionManager(){
        DataSourceTransactionManager dataSourceTransactionManager = new DataSourceTransactionManager();
        dataSourceTransactionManager.setDataSource(this.dataSource());
        return dataSourceTransactionManager;
    }
}
