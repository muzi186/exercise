package com.ehcache;

import org.ehcache.Cache;
import org.ehcache.CacheManager;
import org.ehcache.config.builders.CacheConfigurationBuilder;
import org.ehcache.config.builders.CacheManagerBuilder;
import org.ehcache.config.builders.ResourcePoolsBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by gavin on 16-5-16.
 */
public class SimpleEhcacheDemo {
    private static final Logger log = LoggerFactory.getLogger(SimpleEhcacheDemo.class);

    public static void main(String... args){
        CacheManager cacheManager = CacheManagerBuilder.newCacheManagerBuilder()
                .withCache(
                        "preConfigured",
                        CacheConfigurationBuilder.newCacheConfigurationBuilder(
                                Long.class,
                                String.class,
                                ResourcePoolsBuilder.heap(100)
                        ).build()
                ).build(true);

        Cache<Long, String> preConfigured = cacheManager.getCache("preConfigured", Long.class, String.class);

        Cache<Long, String> myCache = cacheManager.createCache("myCache",
                CacheConfigurationBuilder.newCacheConfigurationBuilder(Long.class, String.class, ResourcePoolsBuilder.heap(100)).build());

        Long key = 1L;
        String value = "da one!";


        log.debug("put {{},{}}", key, value);
        myCache.put(1L, "da one!");

        String getValue = myCache.get(1L);

        log.debug("get value:"+ getValue);

        log.debug("put {1L, 'incubate'} into preConfigured");
        preConfigured.put(1L, "incubate");
        getValue = preConfigured.get(1L);

        log.debug("get value from preConfigured:{}" , getValue);

        key = 1L;
        value="incubate advanced";
        log.debug("put {{}, '{}'} into preConfigured.", key, value);
        preConfigured.put(key, value);
        getValue = preConfigured.get(key);
        log.debug("get value with key : {} from preConfigured : {}", key, getValue);

        cacheManager.close();
    }
}
