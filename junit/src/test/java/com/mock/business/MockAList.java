package com.mock.business;

import org.junit.Test;
import java.util.List;

import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.junit.jupiter.api.Assertions.*;

public class MockAList {

    @Test
    public void testListSize_WithMock_Test() {
           List list= mock(List.class);
           when(list.size()).thenReturn(8);
           assertEquals(8,list.size());
    }

    @Test
    public void testListSize_With_MultipleValue_WithMock_Test() {
        List list= mock(List.class);
        when(list.size()).thenReturn(8).thenReturn(30).thenReturn(40);
        assertEquals(8,list.size());
        assertEquals(30,list.size());
        assertEquals(40,list.size());
    }

    @Test
    public void testListGet_WithMock_Test() {
        List list= mock(List.class);
        when(list.get(0)).thenReturn(48);
        assertEquals(48,list.get(0));
    }

    @Test
    public void testListGet_WithMock1_Test() {
        List list= mock(List.class);
        when(list.get(0)).thenReturn("Arunendra");
        assertEquals("Arunendra",list.get(0));
    }

    @Test
    public void testListGet_WithMock2_Test() {
        List list= mock(List.class);
        when(list.get(anyInt())).thenReturn("Arunendra");
        assertEquals("Arunendra",list.get(0));
        assertEquals("Arunendra",list.get(1));
        assertEquals("Arunendra",list.get(2));
    }

    @Test(expected=NullPointerException.class)
    public void testListGet_ThrowException_WithMock2_Test() {
        List list= mock(List.class);
        when(list.get(anyInt())).thenThrow(new NullPointerException());
        assertEquals("Arunendra",list.get(0));
        assertEquals("Arunendra",list.get(1));
        assertEquals("Arunendra",list.get(2));
    }
}
