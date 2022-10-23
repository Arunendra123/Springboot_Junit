package com.mock.business;

import com.mock.service.ToDoService;
import com.mock.service.ToDoServiceStub;
import com.mock.service.impl.ToDoBusinessImpl;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class ToDoBusinessImplStubTest {

    @Test
    public void filterToDOTest() {
        ToDoService toDoServiceStub = new ToDoServiceStub();
        ToDoBusinessImpl toDoBusiness = new ToDoBusinessImpl(toDoServiceStub);
        List<String> result=toDoBusiness.filterToDO("you", "arunendra");
        assertEquals(2,result.size());
    }
}
