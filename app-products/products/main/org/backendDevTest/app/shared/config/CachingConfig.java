package org.backendDevTest.app.shared.config;

import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.concurrent.ConcurrentMapCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.Scheduled;

@Configuration
@EnableCaching
public class CachingConfig {

    @Bean
    public CacheManager cacheManager(){
        return new ConcurrentMapCacheManager("product");
    }

    @CacheEvict(allEntries = true, value = {"product"})
    @Scheduled(fixedDelay = 24 * 60 * 1000 ,  initialDelay = 500)
    public void cacheEvict(){

    }
}
