package com.junit.service;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(Parameterized.class)
public class ParameterizedCalculatorServiceTestJUnit4 {

    private CalculatorService calculatorService;
    private Long a;
    private Long b;
    private Long expected;

    public ParameterizedCalculatorServiceTestJUnit4(Long a,Long b,Long expected){
        this.a=a;
        this.b=b;
        this.expected=expected;
    }

    @Before
    public void setup() {
        calculatorService=new CalculatorService();
    }

    @Parameterized.Parameters
    public static Collection<Long[]> parameters(){
        Long expectedOutput[][] = new Long[][]{
                {3L,4L,7L},
                {20L,30l,50L},
                {80L,90L,170L}
        };
        return Arrays.asList(expectedOutput);
    }

    @Test
    public void addTest(){
        Long actual=calculatorService.add(a,b);
        assertEquals(expected,actual);
    }
}
