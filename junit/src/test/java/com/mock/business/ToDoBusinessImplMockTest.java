package com.mock.business;

import com.mock.service.ToDoService;
import com.mock.service.impl.ToDoBusinessImpl;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;

import java.util.Arrays;
import java.util.List;

import static org.mockito.BDDMockito.then;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;
import static org.mockito.BDDMockito.given;

public class ToDoBusinessImplMockTest {

    @Test
    public void filterToDO_with_mocking_the_method_Test() {
        ToDoService toDoService = mock(ToDoService.class);

        List<String> todo=Arrays.asList("Hello Arunendra!!","What would you like to learn","Seems you know a lot");
        when(toDoService.retrieveTODO("arunendra")).thenReturn(todo);

        ToDoBusinessImpl toDoBusiness = new ToDoBusinessImpl(toDoService);
        List<String> result=toDoBusiness.filterToDO("you", "arunendra");
        assertEquals(2,result.size());
    }

    @Test
    public void filterToDO_with_verify_method_call_Test() {
        ToDoService toDoService = mock(ToDoService.class);

        List<String> todo=Arrays.asList("Hello Arunendra!!","What would you like to learn","Seems you know a lot");
        when(toDoService.retrieveTODO("arunendra")).thenReturn(todo);

        ToDoBusinessImpl toDoBusiness = new ToDoBusinessImpl(toDoService);

        //checks if method invoked before calling method
        verify(toDoService,never()).retrieveTODO(anyString());

        List<String> result=toDoBusiness.filterToDO("you", "anystring");

        //checks if method invoked.
        verify(toDoService,times(1)).retrieveTODO(anyString());

        //checks if method invoked at least once.
        verify(toDoService,atLeastOnce()).retrieveTODO(anyString());
        assertEquals(0,result.size());
    }

    //BDDMockito
    //Given
    //When
    //Then
    @Test
    public void filterToDO_with_mocking_the_method_with_BDDMockito_Test() {
        ToDoService toDoService = mock(ToDoService.class);

        List<String> todo=Arrays.asList("Hello Arunendra!!","What would you like to learn","Seems you know a lot");
        given(toDoService.retrieveTODO(anyString())).willReturn(todo);

        ToDoBusinessImpl toDoBusiness = new ToDoBusinessImpl(toDoService);
        List<String> result=toDoBusiness.filterToDO("you", "arunendra");
        assertThat(result.size(),is(2));
    }

    //BDDMockito
    //Given
    //When
    //Then
    @Test
    public void filterToDO_with_verify_method_call_BDDMockito_Test() {

        // Mocking service
        ToDoService toDoService = mock(ToDoService.class);

        List<String> todo=Arrays.asList("Hello Arunendra!!","What would you like to learn","Seems you know a lot");
        given(toDoService.retrieveTODO(anyString())).willReturn(todo);

        ToDoBusinessImpl toDoBusiness = new ToDoBusinessImpl(toDoService);
        List<String> result=toDoBusiness.filterToDO("you", "anystring");
        //checks if method invoked
        then(toDoService).should(atLeastOnce()).retrieveTODO(anyString());
        assertThat(result.size(),is(2));
    }

    //capture Arguments
    @Test
    public void filterToDO_Capture_Arguments_Test() {
         ArgumentCaptor<String> stringArgumentCaptor=ArgumentCaptor.forClass(String.class);
        // Mocking service
        ToDoService toDoService = mock(ToDoService.class);

        List<String> todo=Arrays.asList("Hello Arunendra!!","What would you like to learn","Seems you know a lot");
        given(toDoService.retrieveTODO(anyString())).willReturn(todo);

        ToDoBusinessImpl toDoBusiness = new ToDoBusinessImpl(toDoService);
        List<String> result=toDoBusiness.filterToDO("you", "anystring");

        then(toDoService).should().retrieveTODO(stringArgumentCaptor.capture());

        assertThat(result.size(),is(2));
        assertThat(stringArgumentCaptor.getValue(),is("anystring"));
    }
}
