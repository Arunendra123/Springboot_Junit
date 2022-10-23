package com.junit.caching;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CacheApplicationTest {

    @Autowired
    private CacheApplication cacheApplication;

    @Test
    public void getDataTest() {
        CacheApplication.Data date=cacheApplication.getData();
        System.out.println(date);
    }

    @Test
    public void getData_methodCallTest(){
        CacheApplication.Data date1=cacheApplication.getData();
        System.out.println(date1);
        CacheApplication.Data date2=cacheApplication.getData();
        System.out.println(date2);
        CacheApplication.Data date3=cacheApplication.getData();
        System.out.println(date3);

        cacheApplication.evictSingleCacheValue();
        CacheApplication.Data date4=cacheApplication.getData();
        System.out.println(date4);
    }
}
