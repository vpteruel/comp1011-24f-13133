package com.vinicius;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class DoublyLinkedListTest {

    private DoublyLinkedList<Integer> list;

    @BeforeEach
    void setUp() {
        list = new DoublyLinkedList<>();
        list.addNode(1);
        list.addNode(2);
        list.addNode(3);
    }

    @Test
    void testAddNode() {
        list.addNode(4);
        String result = list.traverseForward();
        assertEquals("1 ➔ 2 ➔ 3 ➔ 4", result);
    }

    @Test
    void testDeleteNode() {
        list.deleteNode(2);
        String result = list.traverseForward();
        assertEquals("1 ➔ 3", result);
    }

    @Test
    void testTraverseForward() {
        String result = list.traverseForward();
        assertEquals("1 ➔ 2 ➔ 3", result);
    }

    @Test
    void testTraverseBackward() {
        String result = list.traverseBackward();
        assertEquals("3 ➔ 2 ➔ 1", result);
    }
}
