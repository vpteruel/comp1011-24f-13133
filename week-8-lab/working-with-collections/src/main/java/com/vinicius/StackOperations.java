package com.vinicius;

import java.util.Stack;

public class StackOperations {
    private Stack<Student> students = new Stack<>();

    public boolean pushStudent(Student student) {
        Student _student = students.push(student);
        return _student != null;
    }

    public Student popStudent() {
        if (!students.isEmpty()) {
            return students.pop();
        } else {
            return null;
        }
    }

    public Stack<Student> getStudents() {
        return students;
    }
}
