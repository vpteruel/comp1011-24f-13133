public class Node<T> {

    // the data stored in the Node
    T data;

    // a reference to the next Node in the linked list
    Node<T> next;

    public Node(T data) {

        this.data = data;
        this.next = null;
    }
}