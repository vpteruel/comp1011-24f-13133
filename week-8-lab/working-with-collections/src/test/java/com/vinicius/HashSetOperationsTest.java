package com.vinicius;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.HashSet;

public class HashSetOperationsTest {

    private HashSetOperations hashSetOps;
    private Student student1;
    private Student student2;
    private Student student3;
    private Student studentDuplicate;

    @BeforeEach
    void setUp() {
        hashSetOps = new HashSetOperations();
        student1 = new Student(1, "John", "john@example.com");
        student2 = new Student(2, "Charlie", "charlie@example.com");
        student3 = new Student(3, "Fred", "fred@example.com");
        studentDuplicate = new Student(1, "John", "john@example.com");
    }

    @Test
    void testAddStudent() {
        hashSetOps.addStudent(student1);
        hashSetOps.addStudent(student2);
        hashSetOps.addStudent(student3);
        hashSetOps.addStudent(studentDuplicate); // Should not add duplicate

        HashSet<Student> students = hashSetOps.getStudents();
        assertEquals(3, students.size(), "HashSet should contain only unique students by ID.");
        assertTrue(students.contains(student1), "HashSet should contain student1.");
        assertTrue(students.contains(student2), "HashSet should contain student2.");
    }

    @Test
    void testGetStudents() {
        hashSetOps.addStudent(student1);
        hashSetOps.addStudent(student2);
        hashSetOps.addStudent(student3);
        
        assertEquals(3, hashSetOps.getStudents().size(), "HashSet should contain the correct size of students.");
    }
}
