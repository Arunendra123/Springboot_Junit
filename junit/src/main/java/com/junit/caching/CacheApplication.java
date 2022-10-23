package com.junit.caching;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;

@Component
public class CacheApplication {

    @Autowired
    private CacheManager cacheManager;

    public class Data {
        public Data(String dName, Integer dValuel) {
            this.dName = dName;
            this.dValuel = dValuel;
        }

        private String dName;
        private Integer dValuel;

        public String getdName() {
            return dName;
        }

        public void setdName(String dName) {
            this.dName = dName;
        }

        public Integer getdValuel() {
            return dValuel;
        }

        public void setdValuel(Integer dValuel) {
            this.dValuel = dValuel;
        }

        @Override
        public String toString() {
            return "Data{" +
                    "dName='" + dName + '\'' +
                    ", dValuel=" + dValuel +
                    '}';
        }
    }

    @Cacheable(cacheNames = { "data" }, key = "'data'")
    public Data getData(){
        System.out.println("Cache is Empty, calling method");
        return new Data("One",1);
    }

    public void evictSingleCacheValue() {
        System.out.println("Evicting data...");
        cacheManager.getCache("data").evict("data");
    }
    public void evictSingleCacheValue(String cacheName, String cacheKey) {
        System.out.println("Evicting data...");
        cacheManager.getCache(cacheName).evict(cacheKey);
    }
}
