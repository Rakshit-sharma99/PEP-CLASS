public class LinkedListAllInOne {

    // Singly Linked List Node
    static class Node {
        int data;
        Node next;
        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    // Doubly Linked List Node
    static class DNode {
        int data;
        DNode next, prev;
        DNode(int data) {
            this.data = data;
            this.next = this.prev = null;
        }
    }

    // Detect Loop in Linked List
    static boolean detectLoop(Node head) {
        Node slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) return true;
        }
        return false;
    }

    // Check if Linked List is Sorted
    static boolean isSorted(Node head) {
        while (head != null && head.next != null) {
            if (head.data > head.next.data) return false;
            head = head.next;
        }
        return true;
    }

    // Sort the Given Linked List (Merge Sort)
    static Node sortList(Node head) {
        if (head == null || head.next == null) return head;

        Node mid = getMid(head);
        Node right = mid.next;
        mid.next = null;

        Node left = sortList(head);
        Node r = sortList(right);

        return merge(left, r);
    }

    static Node getMid(Node head) {
        Node slow = head, fast = head.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    // Delete Node Without Head Pointer
    static void deleteNodeWithoutHead(Node node) {
        node.data = node.next.data;
        node.next = node.next.next;
    }

    // Merge Two Sorted Linked Lists
    static Node merge(Node a, Node b) {
        if (a == null) return b;
        if (b == null) return a;

        if (a.data < b.data) {
            a.next = merge(a.next, b);
            return a;
        } else {
            b.next = merge(a, b.next);
            return b;
        }
    }

    // Remove All Occurrences of Given Value
    static Node removeAllOccurrences(Node head, int x) {
        while (head != null && head.data == x)
            head = head.next;

        Node curr = head;
        while (curr != null && curr.next != null) {
            if (curr.next.data == x)
                curr.next = curr.next.next;
            else
                curr = curr.next;
        }
        return head;
    }

    // Rotate Singly Linked List by K Nodes
    static Node rotateSingly(Node head, int k) {
        if (head == null || k == 0) return head;

        Node curr = head;
        int count = 1;

        while (count < k && curr != null) {
            curr = curr.next;
            count++;
        }

        if (curr == null) return head;

        Node kthNode = curr;
        while (curr.next != null)
            curr = curr.next;

        curr.next = head;
        head = kthNode.next;
        kthNode.next = null;

        return head;
    }

    // Rotate Doubly Linked List by K Nodes
    static DNode rotateDoubly(DNode head, int k) {
        if (head == null || k == 0) return head;

        DNode curr = head;
        int count = 1;

        while (count < k && curr != null) {
            curr = curr.next;
            count++;
        }

        if (curr == null) return head;

        DNode kthNode = curr;
        while (curr.next != null)
            curr = curr.next;

        curr.next = head;
        head.prev = curr;

        head = kthNode.next;
        head.prev = null;
        kthNode.next = null;

        return head;
    }

    // Print Singly Linked List
    static void printList(Node head) {
        while (head != null) {
            System.out.print(head.data + " ");
            head = head.next;
        }
        System.out.println();
    }

    // MAIN FUNCTION (Run what you want by uncommenting)
    public static void main(String[] args) {

        // Create Singly Linked List
        Node head = new Node(1);
        head.next = new Node(3);
        head.next.next = new Node(5);
        head.next.next.next = new Node(2);
        head.next.next.next.next = new Node(4);

        // Detect Loop
        // System.out.println(detectLoop(head));

        // Check Sorted
        // System.out.println(isSorted(head));

        // Sort Linked List
        // head = sortList(head);
        // printList(head);

        // Delete Node Without Head Pointer (delete node with value 3)
        // deleteNodeWithoutHead(head.next);
        // printList(head);

        // Remove All Occurrences (remove 2)
        // head = removeAllOccurrences(head, 2);
        // printList(head);

        // Rotate Singly Linked List by 2
        // head = rotateSingly(head, 2);
        // printList(head);

        // Create Doubly Linked List
        DNode dhead = new DNode(1);
        dhead.next = new DNode(2);
        dhead.next.prev = dhead;
        dhead.next.next = new DNode(3);
        dhead.next.next.prev = dhead.next;

        // Rotate Doubly Linked List by 1
        // dhead = rotateDoubly(dhead, 1);
    }
}
