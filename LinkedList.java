class Node {
    int data;
    Node next;
}

class LinkedList {
    Node head;

    void searchAndUpdate(int oldVal, int newVal) {
        Node temp = head;

        while (temp != null) {
            if (temp.data == oldVal) {
                temp.data = newVal;
                return;
            }
            temp = temp.next;
        }
    }

    public static void main(String[] args) {
        LinkedList list = new LinkedList();

        // manually creating nodes (basic way)
        list.head = new Node();
        list.head.data = 10;

        list.head.next = new Node();
        list.head.next.data = 20;

        list.head.next.next = new Node();
        list.head.next.next.data = 30;

        // update 20 -> 99
        list.searchAndUpdate(20, 99);

        // print list
        Node temp = list.head;
        while (temp != null) {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }
        System.out.println("null");
    }
}
