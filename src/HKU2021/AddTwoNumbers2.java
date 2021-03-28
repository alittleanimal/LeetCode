package HKU2021;

import org.junit.Test;

public class AddTwoNumbers2 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int increase = 0;
        ListNode res = new ListNode(0, null);
        ListNode dummy = res;

        while (l1 != null || l2 != null || increase != 0) {
            int temp1, temp2;

            temp1 = l1 == null ? 0 : l1.val;
            temp2 = l2 == null ? 0 : l2.val;
            int sum = temp1 + temp2 + increase;
            res.next = new ListNode(sum % 10, null);
            increase = sum / 10;
            res = res.next;

            l1 = l1 == null ? null : l1.next;
            l2 = l2 == null ? null : l2.next;
        }

        return dummy.next;
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

    @Test
    public void test2() {
        ListNode node5 = new ListNode(9, null);
        ListNode node4 = new ListNode(9, node5);
        ListNode node3 = new ListNode(9, node4);
        ListNode node2 = new ListNode(9, node3);
        ListNode node1 = new ListNode(9, node2);

        addTwoNumbers(node1, node3);
    }
}
