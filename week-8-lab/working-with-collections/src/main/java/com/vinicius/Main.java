package com.vinicius;

public class Main {
    public static void main(String[] args) {
        // create some students
        Student[] students = new Student[]{
                new Student(1, "John", "john@example.com"),
                new Student(2, "Charlie", "charlie@example.com"),
                new Student(3, "Fred", "fred@example.com"),
                new Student(1, "John", "john@example.com")
        };

        managerHashSetOps(students);

        managerTreeSetOps(students);

        managerStackOps(students);
    }

    public static void managerHashSetOps(Student[] students) {
        HashSetOperations hashSetOps = new HashSetOperations();

        System.out.println("******* ******* ******* HashSet ******* ******* *******");

        // add students to HashSet
        for (Student student : students) {
            boolean hasAdded = hashSetOps.addStudent(student);
            if (hasAdded) {
                System.out.println("Student " + student.getName() + " added.");
            } else {
                System.out.println("Student " + student.getName() + " already exists.");
            }
        }

        // display students in HashSet
        System.out.println();
        System.out.println("Students in HashSet:");
        for (Student student : hashSetOps.getStudents()) {
            System.out.println(student);
        }

        System.out.println();
    }

    public static void managerTreeSetOps(Student[] students) {
        TreeSetOperations treeSetOps = new TreeSetOperations();

        System.out.println("******* ******* ******* TreeSet ******* ******* *******");

        // add students to TreeSet
        for (Student student : students) {
            boolean hasAdded = treeSetOps.addStudent(student);
            if (hasAdded) {
                System.out.println("Student " + student.getName() + " added.");
            } else {
                System.out.println("Student " + student.getName() + " already exists.");
            }
        }

        // display students in TreeSet
        System.out.println();
        System.out.println("Students in TreeSet (sorted by name):");
        for (Student student : treeSetOps.getStudents()) {
            System.out.println(student);
        }

        System.out.println();
    }

    public static void managerStackOps(Student[] students) {
        StackOperations stackOps = new StackOperations();

        System.out.println("******* ******* ******* Stack ******* ******* *******");

        // add students to TreeSet
        for (Student student : students) {
            boolean hasAdded = stackOps.pushStudent(student);
            if (hasAdded) {
                System.out.println("Student " + student.getName() + " has pushed.");
            } else {
                System.out.println("Student " + student.getName() + " already exists.");
            }
        }

        // display students in Stack
        System.out.println();
        System.out.println("Current stack of recently added students:");
        for (Student student : stackOps.getStudents()) {
            System.out.println(student);
        }

        // remove student to Stack
        Student poppedStudent = stackOps.popStudent();
        if (poppedStudent != null) {
            System.out.println("Student " + poppedStudent.getName() + " has popped.");
        } else {
            System.out.println("Stack is empty.");
        }

        // display students in Stack
        System.out.println();
        System.out.println("Current stack of students:");
        for (Student student : stackOps.getStudents()) {
            System.out.println(student);
        }

        System.out.println();
    }
}