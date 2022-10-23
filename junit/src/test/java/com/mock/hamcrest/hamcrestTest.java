package com.mock.hamcrest;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;

public class hamcrestTest {

    @Test
    public void test_1(){
        List<Integer> list= Arrays.asList(3,4,5,6,7,4);
        assertThat(list,hasSize(6));
        assertThat(list,hasItems(4,7));
        assertThat(list,everyItem(lessThan(10)));

        Integer[] nums={3,5,3,5,6,7,4};
        assertThat(nums,arrayWithSize(7));
    }
}
