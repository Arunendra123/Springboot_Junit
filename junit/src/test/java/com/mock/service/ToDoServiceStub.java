package com.mock.service;

import java.util.Arrays;
import java.util.List;

public class ToDoServiceStub implements ToDoService{
    @Override
    public List<String> retrieveTODO(String user) {
        return Arrays.asList("Hello Arunendra!!","What would you like to learn","Seems you know a lot");
    }
}
