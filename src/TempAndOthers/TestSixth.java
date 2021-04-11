package TempAndOthers;

public class TestSixth {

    public void heapSort(int[] nums) {
        for (int i = nums.length / 2 - 1; i >= 0; i--) {
            adjustHeap(nums, i, nums.length);
        }

        for (int j = nums.length - 1; j > 0; j--) {
            int temp = nums[0];
            nums[0] = nums[j];
            nums[j] = temp;

            adjustHeap(nums, 0, j);
        }
    }

    private void adjustHeap(int[] nums, int i, int length) {
        int temp = nums[i];

        for (int j = i * 2 + 1; j < length; j++) {
            if (j + 1 < length && nums[j] < nums[j + 1]) {
                j++;
            }
            if (nums[j] > temp) {
                nums[i] = nums[j];
                i = j;
            } else {
                break;
            }
        }
        nums[i] = temp;
    }


    public Node ListSort(Node node) {
        if (node == null || node.next == null) {
            return node;
        }

        Node dummy = new Node(0, node);
        Node cur = dummy.next;
        Node next = cur.next;

        while (next != null) {
            if (cur.value > next.value) {
                cur.next = next.next;

                Node pre = dummy.next;
                Node next1 = pre.next;

                while (next1.value < next.value) {
                    pre = pre.next;
                    next1 = next1.next;
                }

                pre.next = next;
                next.next = next1;

                next = cur.next;
            } else {
                cur = cur.next;
                next = cur.next;
            }

        }
        return dummy.next;
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
}
