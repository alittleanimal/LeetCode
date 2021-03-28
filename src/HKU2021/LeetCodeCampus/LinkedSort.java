package HKU2021.LeetCodeCampus;

import org.junit.Test;

public class LinkedSort {
    // LinkedList,
    public void bubbleSortList(Node root) {
        Node head = root;
        while (true) {
            boolean exchange = false;
            while (root.next != null) {
                if (root.value > root.next.value) {
                    Node temp = root.next;
                    root.next.next = root;
                    root.next = temp.next;
                    exchange = true;
                }
                root = root.next;
            }
            if (!exchange) {
                break;
            }

            root = head;
        }
    }

    class Node {
        int value;
        Node next;

        public Node(int value) {
            this.value = value;
            this.next = null;
        }

        public Node(int value, Node next) {
            this.value = value;
            this.next = next;
        }
    }

    public Node insertSortList(Node node) {
        if (node == null || node.next == null) {
            return node;
        }

        Node dummy = new Node(0, node);
        Node cur = node;
        Node next = cur.next;

        while (next != null) {
            if (cur.value > next.value) {
                cur.next = next.next;

                Node temp1 = dummy;
                Node temp2 = temp1.next;

                while (temp2.value < next.value) {
                    temp1 = temp2;
                    temp2 = temp2.next;
                }

                temp1.next = next;
                next.next = temp2;

                next = cur.next;
            } else {
                cur = next;
                next = next.next;
            }
        }

        return dummy.next;
    }

    @Test
    public void test() {
        Node node5 = new Node(5);
        Node node4 = new Node(4, node5);
        Node node3 = new Node(7, node4);
        Node node2 = new Node(9, node3);
        Node node1 = new Node(1, node2);

        insertSortList(node1);
    }

}
