package HKU2021;

public class SwapNodesInPairs24 {
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null)
            return head;
        ListNode returnNode = head.next;
        head.next = swapPairs(returnNode.next);
        returnNode.next = head;

        return returnNode;
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
}
