package com.vinicius;

public class SinglyLinkedList<T> {

    private Node<T> head;

    public SinglyLinkedList() {
        this.head = null;
    }

    public void addNode(T data) {

        Node<T> newNode = new Node<>(data);

        if (head == null) {
            head = newNode;
        } else {
            Node<T> current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
    }

    public boolean deleteNode(T value) {

        if (head == null) {
            return false;
        }

        if (head.data.equals(value)) {
            head = head.next;
            return true;
        }

        Node<T> current = head;
        while (current.next != null) {
            if (current.next.data.equals(value)) {
                current.next = current.next.next;
                return true;
            }
            current = current.next;
        }

        return false;
    }

    public void displayNodes() {

        if (head == null) {
            System.out.println("The list is empty.");
            return;
        }

        System.out.print(traverseList());
    }

    public String traverseList() {

        StringBuilder result = new StringBuilder();
        Node<T> current = head;

        while (current != null) {
            result.append(current.data);
            current = current.next;
            
            if (current != null) {
                result.append(" ➔ ");
            }
        }

        return result.toString(); 
    }
}