package com.junit.service;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.*;
import org.springframework.test.context.event.annotation.AfterTestClass;
import org.springframework.test.context.event.annotation.BeforeTestClass;

import java.util.Arrays;

public class CalculatorServiceTest {

    @BeforeTestClass
    public static void beforeClass(){
        System.out.println("Before Class");
    }

    @AfterTestClass
    public static void afterClass(){
        System.out.println("After Class");
    }

    private CalculatorService calculatorService;
    private Long expected;
    private Long actual;


    @BeforeEach
    public void setup(){
        calculatorService=new CalculatorService();
    }

    @AfterEach
    public void printValue(){
        System.out.println("Expected: "+expected +" and Actual: "+actual);
    }

    @BeforeAll
    public static void setupBeforeAll(){
        System.out.println("Before All: Connect to DB");
    }

    @AfterAll
    public static void setupAfterAll(){
        System.out.println("After All: Cleanup All the connection");
    }

    @Test
     void addTest(){
        expected=50L;
        actual=calculatorService.add(30L,20L);
        assertEquals(expected,actual);
     }

    @Test
    void subTest(){
        expected=10L;
        actual=calculatorService.sub(30L,20L);
        assertEquals(expected,actual);
    }

    @Test
    void multiplyTest(){
        expected=600L;
        actual=calculatorService.multiply(30L,20L);
        assertEquals(expected,actual);
    }

    @Test
    void divideTest(){
        expected=1L;
        actual=calculatorService.divide(30L,30L);
        assertEquals(expected,actual);
    }

    @Test
    public void checkIfNumberIsGreaterThanTen(){
        assertFalse(calculatorService.isLessTen(100));
    }

    @Test
    public void checkIfNumberIsLessThanTen(){
        assertTrue(calculatorService.isLessTen(9));
    }

    @Test
    public void checkIfArrayElementsAreEquals(){
        int a[]={4,5,7,2,3};
        Arrays.sort(a);
        int b[]={2,3,4,5,7};
        assertArrayEquals(a,b);
    }

    @Test
    @DisplayName("Throw Exception when variable is null")
    void testExpectedExceptionWithParentType() {
        int a[]=null;
        assertThrows(NullPointerException.class, () -> {
            Arrays.sort(a);
        });
    }

    @Test
    public void testResultNotNull(){
        String result="result";
        assertNotNull(result);
    }

    @Test
    public void testResultNull(){
        String result=null;
        assertNull(result);
    }

    /*  @Test(expected=NullPointerException.class) //Junit 4
    void testExpectedExceptionWithParentType() {
            int a[]=null;
            Arrays.sort(a);
    }*/

    @Nested
    class MathTest{

        private Math  math;

        @BeforeEach
        public void  setup(){
            math=new Math();
        }

        @Test
        public void sqaureTest(){
             assertEquals(25D,math.sqaure(5D));
        }
    }
}
