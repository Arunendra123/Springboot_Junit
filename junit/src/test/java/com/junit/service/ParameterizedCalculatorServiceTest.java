package com.junit.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.*;

public class ParameterizedCalculatorServiceTest {

    private CalculatorService calculatorService;
    private Long expected;
    private Long actual;

    @BeforeEach
    public void setup(){
        calculatorService=new CalculatorService();
    }

    @ParameterizedTest
    @CsvSource(value={"3,5,8","45,45,90","4,8,12"})
    void addTest(Long a,Long b,Long expected){
        actual=calculatorService.add(a,b);
        assertEquals(expected,actual);
    }

    @ParameterizedTest (name="{0} is greater than 10")
    @ValueSource(ints={29,34,67,11,45,23,28})
    public void checkIfNumberIsGreaterThanTen(Integer expected){
        assertFalse(calculatorService.isLessTen(expected));
    }

    @Test
    @RepeatedTest(10)
    public void repeatedTest() {
         System.out.println("Repeated");
    }

   @Test
    void addTest_With_TimeOut(){
        assertTimeout(Duration.ofMillis(1),()->{
            expected=50L;
            actual=calculatorService.add(20L,30L);
            assertEquals(expected,actual);
        });
    }

    @Test
    @Disabled
    public void disabled(){

    }


}
