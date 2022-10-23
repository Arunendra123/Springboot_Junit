package com.junit.service;

public class CalculatorService {

    public Long add(Long a, Long b){
        return a+b;
    }
    public Long sub(Long a, Long b){
        return a-b;
    }
    public Long multiply(Long a, Long b){
        return a*b;
    }
    public Long divide(Long a, Long b){
        return a/b;
    }

    public boolean isLessTen(int num){
        return num<10?true:false;
    }
}
