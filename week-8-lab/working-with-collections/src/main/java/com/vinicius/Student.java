package com.vinicius;

import java.util.Objects;

public class Student implements Comparable<Student> {
    public int id;
    public String name;
    public String email;

    // constructor
    public Student(int id, String name, String email) {
        this.id = id;
        this.name = name;
        this.email = email;
    }

    // getters
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    // overriding equals and hashCode for unique identification by id
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Student student = (Student) obj;
        return id == student.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    // compare by name for TreeSet sorting
    @Override
    public int compareTo(Student other) {
        return this.name.compareTo(other.name);
    }

    // toString for display
    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
