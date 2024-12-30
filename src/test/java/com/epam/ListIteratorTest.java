package com.epam;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.ListIterator;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ListIteratorTest {

    private final ArrayList<String> list = new ArrayList<>();

    @BeforeEach
    void initialize() {
        list.add("1");
        list.add("2");
        list.add("3");
    }

    @Test
    void iteratorRemove() {
        ListIterator<String> iterator = list.listIterator();
        iterator.next();
        iterator.remove();

        System.out.println(list);

        assertEquals(2, list.size());
    }
}
