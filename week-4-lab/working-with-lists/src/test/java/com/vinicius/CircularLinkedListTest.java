package com.vinicius;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CircularLinkedListTest {

    private CircularLinkedList<Integer> list;

    @BeforeEach
    void setUp() {
        list = new CircularLinkedList<>();
        list.addNode(1);
        list.addNode(2);
        list.addNode(3);
    }

    @Test
    void testAddNode() {
        list.addNode(4);
        String result = list.traverseList();
        assertEquals("1 ➔ 2 ➔ 3 ➔ 4", result);
    }

    @Test
    void testDeleteNode() {
        list.deleteNode(2);
        String result = list.traverseList();
        assertEquals("1 ➔ 3", result);
    }

    @Test
    void testTraverseList() {
        String result = list.traverseList();
        assertEquals("1 ➔ 2 ➔ 3", result);
    }
}
