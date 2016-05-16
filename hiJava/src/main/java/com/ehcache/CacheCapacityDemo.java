package com.ehcache;

import org.ehcache.Cache;
import org.ehcache.CacheManager;
import org.ehcache.config.builders.CacheConfigurationBuilder;
import org.ehcache.config.builders.CacheManagerBuilder;
import org.ehcache.config.builders.ResourcePoolsBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.stream.IntStream;

/**
 * Created by gavin on 16-5-17.
 */
public class CacheCapacityDemo {
    private static final Logger log = LoggerFactory.getLogger(CacheCapacityDemo.class);
    public static final Long SIZE_TO_CACHE = 100L;

    public static void main(String...args){
        CacheManager cacheManager = CacheManagerBuilder.newCacheManagerBuilder().build(true);

        Cache<Long, CachedEntity> entityCache = cacheManager.createCache("entityCache",
                CacheConfigurationBuilder.newCacheConfigurationBuilder(
                        Long.class,
                        CachedEntity.class,
                        ResourcePoolsBuilder.heap(10)
                ).build()
        );

        Long key = null;
        CachedEntity value = null;

        log.debug("Start to cache entities.");

        for(int i = 0; i<SIZE_TO_CACHE; i++){
            key = Long.valueOf(i);
            value = new CachedEntity(key, "CachedEntity"+key);
            log.debug("try to cache : {}", value);
            entityCache.put(key, value);

        }

        log.debug("Start to pull cached entities.");
        IntStream.range(0,SIZE_TO_CACHE.intValue()).forEach((i)->{
            Long getKey = Long.valueOf(i);
            log.debug("try to pull with key : {}", getKey);
            CachedEntity getValue = entityCache.get(getKey);
            log.debug("pulled entity : {}", getValue);
        });
    }

    public static class CachedEntity{
        Long id;
        String label;
        byte[] contents = new byte[10*1024];

        public CachedEntity(Long id, String label) {
            this.id = id;
            this.label = label;
        }

        public Long getId() {
            return id;
        }

        public String getLabel() {
            return label;
        }

        public byte[] getContents() {
            return contents;
        }

        @Override
        public String toString() {
            return "CachedEntity{" +
                    "label='" + label + '\'' +
                    ", id=" + id +
                    '}';
        }
    }
}
