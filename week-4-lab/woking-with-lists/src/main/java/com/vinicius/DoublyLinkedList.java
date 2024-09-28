package com.vinicius;

public class DoublyLinkedList<T> {

    private Node<T> head;
    private Node<T> tail;

    public DoublyLinkedList() {
        this.head = null;
        this.tail = null;
    }

    public void addNode(T data) {

        Node<T> newNode = new Node<>(data);

        if (head == null) {
            head = newNode;
            tail = newNode;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
    }

    public boolean deleteNode(T key) {
        
        Node<T> temp = head;

        // check if the list is empty
        if (temp == null) {
            return false; // Node not found
        }
    
        // if head node itself holds the key
        if (temp.data.equals(key)) {
            head = temp.next;
            if (head != null) {
                head.prev = null;
            } else {
                tail = null;
            }
            return true;
        }
    
        // search for the key to be deleted
        while (temp != null && !temp.data.equals(key)) {
            temp = temp.next;
        }
    
        if (temp == null) {
            return false;
        }
    
        // unlink the node from the list
        if (temp.next != null) {
            temp.next.prev = temp.prev;
        }
    
        if (temp.prev != null) {
            temp.prev.next = temp.next;
        }
    
        return true;
    }

    public void displayNodes() {

        if (head == null) {
            System.out.println("The list is empty.");
            return;
        }

        System.out.print("Forward: ");
        System.out.print(traverseForward());
        
        System.out.print("\nBackward: ");
        System.out.print(traverseBackward());
    }

    public String traverseForward() {

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

    public String traverseBackward() {
        
        if (head == null) {
            return "";
        }

        StringBuilder result = new StringBuilder();
        Node<T> current = head;

        // move to the end of the list
        while (current.next != null) {
            current = current.next;
        }

        while (current != null) {
            result.append(current.data);
            current = current.prev;
            
            if (current != null) {
                result.append(" ➔ ");
            }
        }

        return result.toString(); 
    }
}