package HKU2021.March;

import org.junit.Test;

public class RemoveDuplicatesFromSortedListII82 {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode dummy = new ListNode(0, head);
        int record;
        ListNode cur = dummy;
        while (cur.next != null && cur.next.next != null) {

            if (cur.next.val == cur.next.next.val) {
                record = cur.next.val;
                while (cur.next != null && cur.next.val == record) {
                    cur.next = cur.next.next;
                }
            } else {
                cur = cur.next;
            }
        }
        return dummy.next;
    }

    @Test
    public void test82() {
        ListNode node5 = new ListNode(5);
        ListNode node4 = new ListNode(2, node5);
        ListNode node3 = new ListNode(2, node4);
        ListNode node2 = new ListNode(1, node3);
        ListNode node1 = new ListNode(1, node2);
//        deleteDuplicatesOther(node2);
        deleteDuplicatesOne(node1);
    }

    public ListNode deleteDuplicatesOther(ListNode head) {
        ListNode dummy = new ListNode();
        ListNode cur = dummy;

        while (head != null) {
            if (head.next == null || head.val != head.next.val) {
                cur.next = head;
                cur = cur.next;
            }

            while (head.next != null && head.val == head.next.val) {
                head = head.next;
            }
            head = head.next;
        }
        cur.next = null;
        return dummy.next;
    }

    public ListNode deleteDuplicatesOne(ListNode head) {
        ListNode dummy = new ListNode(0, head);
        ListNode cur = dummy.next;

        while (cur != null && cur.next != null) {
            if (cur.val == cur.next.val) {
                cur.next = cur.next.next;
            } else {
                cur = cur.next;
            }
        }

        return dummy.next;
    }
}


class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}
