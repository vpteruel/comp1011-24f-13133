package com.vinicius;

public class Main {
    public static void main(String[] args) {

        System.out.println("\n\n");
        execSinglyLinkedList();

        System.out.println("\n\n");
        execDoublyLinkedList();

        System.out.println("\n\n");
        execCircularLinkedList();

        System.out.println("\n\n");
    }

    public static void execSinglyLinkedList() {
        
        System.out.println("Singly Linked List");

        SinglyLinkedList<Integer> list = new SinglyLinkedList<>();

        // add new nodes
        list.addNode(10);
        list.addNode(20);
        list.addNode(30);
        list.addNode(40);

        // display nodes
        System.out.println("\nLinked List after adding nodes:");
        list.displayNodes();

        // delete a node
        list.deleteNode(20);
        System.out.println("\nLinked List after deleting node with value 20:");
        list.displayNodes();
    }

    public static void execDoublyLinkedList() {
        
        System.out.println("Doubly Linked List");

        DoublyLinkedList<Integer> list = new DoublyLinkedList<>();

        // add new nodes
        list.addNode(10);
        list.addNode(20);
        list.addNode(30);
        list.addNode(40);

        // display nodes
        System.out.println("\nDoubly Linked List after adding nodes:");
        list.displayNodes();

        // delete a node
        list.deleteNode(20);
        System.out.println("\nDoubly Linked List after deleting node with value 20:");
        list.displayNodes();
    }

    public static void execCircularLinkedList() {
        
        System.out.println("Circular Linked List");

        CircularLinkedList<Integer> list = new CircularLinkedList<>();

        // add new nodes
        list.addNode(10);
        list.addNode(20);
        list.addNode(30);
        list.addNode(40);

        // display nodes
        System.out.println("\nCircular Linked List after adding nodes:");
        list.displayNodes();

        // delete a node
        list.deleteNode(20);
        System.out.println("\nCircular Linked List after deleting node with value 20:");
        list.displayNodes();
    }
}