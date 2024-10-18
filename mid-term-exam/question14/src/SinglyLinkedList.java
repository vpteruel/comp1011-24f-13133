public class SinglyLinkedList<T> {

    // the head node of the linked list
    private Node<T> head;

    public SinglyLinkedList() {
        this.head = null;
    }

    public void addNode(T data) {

        Node<T> newNode = new Node<>(data);

        // if the list is empty, set the head to the new node
        if (head == null) {
            head = newNode;
        } else {
            // traverse to the end of the list and add the new node
            Node<T> current = head;
            while (current.next != null) {
                current = current.next; // move to the next node
            }
            current.next = newNode; // link the new node at the end of the list
        }
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
        Node<T> current = head; // start at the head of the list

        // traverse the list until the end
        while (current != null) {
            result.append(current.data); // append the current node's data to the result
            current = current.next; // move to the next node

            // if there's a next node, append an arrow to indicate the link
            if (current != null) {
                result.append(" ➔ ");
            }
        }

        return result.toString(); // return the accumulated result as a string
    }
}