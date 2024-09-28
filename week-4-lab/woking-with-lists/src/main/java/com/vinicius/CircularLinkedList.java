package com.vinicius;

public class CircularLinkedList<T> {

    private Node<T> head;

    public CircularLinkedList() {
        this.head = null;
    }

    public void addNode(T data) {

        Node<T> newNode = new Node<>(data);
        
        if (head == null) {
            head = newNode;
            newNode.next = head;  // point the new node to itself, making it circular
        } else {
            Node<T> current = head;
            while (current.next != head) {
                current = current.next;
            }
            current.next = newNode;
            newNode.next = head;  // make the last node point to head
        }
    }

    public boolean deleteNode(T value) {

        if (head == null)  {
            return false;
        }

        Node<T> current = head, prev = null;

        // if the node to be deleted is the head node
        if (head.data.equals(value)) {
            if (head.next == head) {
                head = null;
                return true;
            }

            Node<T> last = head;
            while (last.next != head) {
                last = last.next;
            }
            last.next = head.next;
            head = head.next;
            return true;
        }

        // traverse the list to find the node to delete
        do {
            prev = current;
            current = current.next;
        } while (current != head && !current.data.equals(value));

        // if the node was found, unlink it
        if (current != head) {
            prev.next = current.next;
            return true;
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

        do {
            result.append(current.data);
            current = current.next;

            if (current != head) {
                result.append(" ➔ ");
            }
        } while (current != head);

        return result.toString(); 
    }
}