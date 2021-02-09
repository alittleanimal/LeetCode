package HKU2021;

import org.junit.Test;

/**
 * 376. Wiggle Subsequence
 */
public class WiggleSubsequence376 {
    public int wiggleMaxLength(int[] nums) {
        int up = 1, down = 1;
        int res = 0;

        if (nums.length < 2) return nums.length;

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > nums[i - 1]) {
                up = down + 1;
            } else if (nums[i] < nums[i - 1]) {
                down = up + 1;
            }
            res = Math.max(res, Math.max(up, down));
        }
        return res;
    }

    @Test
    public void test376() {
        System.out.println(wiggleMaxLength(new int[]{1, 17, 5, 10, 13, 15, 10, 5, 16, 8}));
    }
}
