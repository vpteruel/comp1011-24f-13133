package com.vinicius;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Stack;

public class StackOperationsTest {

    private StackOperations stackOps;
    private Student student1;
    private Student student2;
    private Student student3;

    @BeforeEach
    void setUp() {
        stackOps = new StackOperations();
        student1 = new Student(1, "John", "john@example.com");
        student2 = new Student(2, "Charlie", "charlie@example.com");
        student3 = new Student(3, "Fred", "fred@example.com");
    }

    @Test
    void testPushStudent() {
        stackOps.pushStudent(student1);
        stackOps.pushStudent(student2);
        stackOps.pushStudent(student3);

        Stack<Student> students = stackOps.getStudents();
        assertEquals(3, students.size(), "Stack should contain all added students.");
        assertEquals(student3, students.peek(), "Top of the stack should be the last pushed student.");
    }

    @Test
    void testPopStudent() {
        stackOps.pushStudent(student1);
        stackOps.pushStudent(student2);
        stackOps.popStudent();

        Stack<Student> students = stackOps.getStudents();
        assertEquals(1, students.size(), "Stack should contain only one student after one pop.");
        assertEquals(student1, students.peek(), "Top of the stack should be the remaining student after pop.");
    }

    @Test
    void testGetStudents() {
        stackOps.pushStudent(student1);
        stackOps.pushStudent(student2);
        stackOps.pushStudent(student3);

        assertEquals(3, stackOps.getStudents().size(), "Stack should contain the correct size of students.");
    }
}
