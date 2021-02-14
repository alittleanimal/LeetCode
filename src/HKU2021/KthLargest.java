package HKU2021;

import java.util.Arrays;

public class KthLargest {

    private int k;
    private int[] recordNums;

    public KthLargest(int k, int[] nums) {
        this.k = k;
        this.recordNums = new int[k];

        Arrays.sort(nums);
        if (k > nums.length) {
            this.recordNums[0] = -100000;
            for (int i = 0; i < nums.length; i++) {
                this.recordNums[i + 1] = nums[i];
            }
        } else {
            int j = k - 1;
            for (int i = nums.length - 1; i > nums.length - k - 1; i--) {
                this.recordNums[j] = nums[i];
                j--;
            }
        }
    }

    public int add(int val) {
        if (val > this.recordNums[0]) {
            this.recordNums[0] = val;
            Arrays.sort(this.recordNums);
        }
        return this.recordNums[0];
    }
}
