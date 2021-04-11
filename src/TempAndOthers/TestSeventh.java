package TempAndOthers;

import java.util.Arrays;

public class TestSeventh {

    private TestSeventh() {
    }

    private volatile static TestSeventh instance = null;

    public TestSeventh getInstance() {
        if (instance == null) {
            synchronized (TestSeventh.class) {
                if (instance == null) {
                    instance = new TestSeventh();
                }
            }
        }
        return instance;
    }

    public Node listSort(Node root) {
        if (root == null || root.next == null)
            return root;
        Node dummy = new Node(0, root);
        Node cur = root;
        Node next = cur.next;

        while (next != null) {
            if (cur.value <= next.value) {
                cur = next;
                next = next.next;
            } else {
                cur.next = next.next;

                Node n1 = dummy;
                Node n2 = dummy.next;

                while (n2.value <= next.value) {
                    n1 = n2;
                    n2 = n2.next;
                }
                n1.next = next;
                next.next = n2;

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

    public void quickSort(int[] nums) {
        if (nums.length != 0) {
            quickSort(nums, 0, nums.length - 1);
        }
        System.out.println(Arrays.toString(nums));
    }

    public void quickSort(int[] nums, int low, int high) {
        if (low < high) {
            int mid = getMiddle(nums, low, high);
            quickSort(nums, low, mid);
            quickSort(nums, mid + 1, high);
        }
    }

    private int getMiddle(int[] nums, int low, int high) {
        int target = nums[low];

        while (low < high) {
            while (low < high && nums[high] >= target) {
                high--;
            }
            nums[low] = nums[high];
            while (low < high && nums[low] < target) {
                low++;
            }
            nums[high] = nums[low];
        }
        nums[low] = target;
        return low;
    }

    private void mergeSort(int[] nums) {
        if (nums.length == 0)
            return;

        mergeSort(nums, 0, nums.length - 1);
        System.out.println(Arrays.toString(nums));
    }

    private void mergeSort(int[] nums, int low, int high) {
        if (low < high) {
            int mid = (low + high) / 2;
            mergeSort(nums, low, mid);
            mergeSort(nums, mid + 1, high);
            merge(nums, low, mid, high);
        }
    }

    private void merge(int[] nums, int low, int mid, int high) {
        int[] temp = new int[high - low + 1];
        int index = 0;

        int l = low, r = mid + 1;
        while (l <= mid && r <= high) {
            if (nums[l] <= nums[r]) {
                temp[index++] = nums[l++];
            } else {
                temp[index++] = nums[r++];
            }
        }

        while (l <= mid) {
            temp[index++] = nums[l++];
        }

        while (r <= mid) {
            temp[index++] = nums[r++];
        }

        for (int i = 0; i < temp.length; i++) {
            nums[low + i] = temp[i];
        }
    }

    public void heapSort(int[] nums) {
        for (int i = nums.length / 2 - 1; i >= 0; i--) {
            adjustHeap(nums, i, nums.length);
        }

        for (int j = nums.length - 1; j > 0; j--) {
            int temp = nums[j];
            nums[j] = nums[0];
            nums[0] = temp;
            adjustHeap(nums, 0, j);
        }
    }

    private void adjustHeap(int[] nums, int i, int length) {
        int temp = nums[i];

        for (int j = i * 2 + 1; j < length; j = j * 2 + 1) {
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
}
