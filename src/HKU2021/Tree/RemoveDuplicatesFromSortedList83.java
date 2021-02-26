package HKU2021.Tree;

/**
 * 83. Remove Duplicates from Sorted List
 */
public class RemoveDuplicatesFromSortedList83 {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null)
            return head;

        if (head.next.val != head.val) {
            head.next = deleteDuplicates(head.next);
            return head;
        } else
            return deleteDuplicates(head.next);
    }

    private class ListNode {
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

    public ListNode deleteDuplicatesOther(ListNode head) {
        if (head == null)
            return null;
        ListNode originalHead = head;
        while (head.next != null) {
            if (head.val == head.next.val)
                head.next = head.next.next;
            else
                head = head.next;
        }
        return originalHead;
    }
}
