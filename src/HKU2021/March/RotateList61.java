package HKU2021.March;

public class RotateList61 {
    // 61. Rotate List
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null || k == 0) {
            return head;
        }
        int count = 1;
        ListNode cur = head;
        while (cur.next != null) {
            cur = cur.next;
            count++;
        }

        k %= count;

        if (k == 0)
            return head;

        ListNode slow = head;
        ListNode fast = head;

        while (k-- > 0) {
            fast = fast.next;
        }

        while (fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }

        fast.next = head;
        head = slow.next;
        slow.next = null;

        return head;
    }
}
