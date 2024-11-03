package com.vinicius;

import java.util.HashSet;

public class HashSetOperations {
    private HashSet<Student> students = new HashSet<>();

    public boolean addStudent(Student student) {
        return students.add(student);
    }

    public HashSet<Student> getStudents() {
        return students;
    }
}
