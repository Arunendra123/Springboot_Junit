package com.mock.service.impl;

import com.mock.service.ToDoService;

import java.util.List;
import java.util.stream.Collectors;

public class ToDoBusinessImpl {

    private ToDoService toDOService;

    public ToDoBusinessImpl(ToDoService toDOService) {
        this.toDOService = toDOService;
    }

    public List<String> filterToDO(String word, String user){
        List<String> filteredToDO=toDOService.retrieveTODO(user);
        return filteredToDO.stream().filter((u)->{
            if(u.contains(word)){
                return true;
            } else {
                return false;
            }
        }).collect(Collectors.toList());
    }
}
