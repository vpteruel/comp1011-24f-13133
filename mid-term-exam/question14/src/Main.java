public class Main {
    public static void main(String[] args) {
        System.out.println("Singly Linked List");
        System.out.println();

        SinglyLinkedList<String> list = new SinglyLinkedList<>();

        // add new nodes
        list.addNode("Banana");
        list.addNode("Apple");
        list.addNode("Strawberry");
        list.addNode("Kiwi");

        list.displayNodes();
        System.out.println();
    }
}