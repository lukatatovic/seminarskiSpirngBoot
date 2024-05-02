package com.example.demo;

import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.concurrent.ConcurrentMapCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import java.util.Arrays;

@Configuration
@EnableCaching
@EnableScheduling
public class CacheConfig {

    @Bean
    public CacheManager cacheManager(){
        ConcurrentMapCacheManager cacheManager=new ConcurrentMapCacheManager();
        cacheManager.setAllowNullValues(false);
        //t o d o automobil ne postoji al samo za primer
        cacheManager.setCacheNames(Arrays.asList("vozacCache","automobilCache"));
        System.out.println("Cache su"+cacheManager.getCacheNames());
        return cacheManager;
    }
    @CacheEvict(value = "vozacCache",allEntries = true)
    @Scheduled(fixedDelay = 10000,initialDelay = 0)
    public void evictVozacCache(){
        System.out.println("Evict vozac cache: ");
    }
}
