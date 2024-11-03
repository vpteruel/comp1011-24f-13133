package com.vinicius;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.TreeSet;

public class TreeSetOperationsTest {

    private TreeSetOperations treeSetOps;
    private Student student1;
    private Student student2;
    private Student student3;
    private Student studentDuplicate;

    @BeforeEach
    void setUp() {
        treeSetOps = new TreeSetOperations();
        student1 = new Student(1, "John", "john@example.com");
        student2 = new Student(2, "Charlie", "charlie@example.com");
        student3 = new Student(3, "Fred", "fred@example.com");
        studentDuplicate = new Student(1, "John", "john@example.com");
    }

    @Test
    void testAddStudent() {
        treeSetOps.addStudent(student1);
        treeSetOps.addStudent(student2);
        treeSetOps.addStudent(student3);
        treeSetOps.addStudent(studentDuplicate); // Should not add duplicate

        TreeSet<Student> students = treeSetOps.getStudents();
        assertEquals(3, students.size(), "TreeSet should contain only unique students by ID.");
        assertEquals("Charlie", students.first().getName(), "First student should be Charlie in alphabetical order.");
        assertEquals("John", students.last().getName(), "Last student should be John in alphabetical order.");
    }

    @Test
    void testGetStudents() {
        treeSetOps.addStudent(student1);
        treeSetOps.addStudent(student2);
        treeSetOps.addStudent(student3);

        assertEquals(3, treeSetOps.getStudents().size(), "TreeSet should contain the correct size of students.");
    }
}
