package com.junit.caching.controller;

import com.junit.caching.CacheApplication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CacheController {

    @Autowired
    private CacheApplication cacheApplication;

    @RequestMapping(value = "/data",
            method = RequestMethod.GET)
    public CacheApplication.Data getData(){
             return cacheApplication.getData();
    }

    @RequestMapping(value = "/evict",
            method = RequestMethod.GET)
    public String evictData(){
         cacheApplication.evictSingleCacheValue();
         return "Evicted";
    }
}
