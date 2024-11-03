package com.vinicius;

import java.util.TreeSet;

public class TreeSetOperations {
    private TreeSet<Student> students = new TreeSet<>();

    public boolean addStudent(Student student) {
        return students.add(student);
    }

    public TreeSet<Student> getStudents() {
        return students;
    }
}
