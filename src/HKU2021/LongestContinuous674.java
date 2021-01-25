package HKU2021;

import org.junit.Test;

/**
 * 674. Longest Continuous Increasing Subsequence
 */
public class LongestContinuous674 {
    public int findLengthOfLCIS(int[] nums) {
        if (nums.length == 0) return 0;
        int result = 0;
        int tempResult = 1;

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > nums[i - 1]) {
                tempResult++;
            } else {
                if (result < tempResult) {
                    result = tempResult;
                }
                tempResult = 1;
            }
        }
        return Math.max(result, tempResult);
    }

    @Test
    public void test674() {
        System.out.println(findLengthOfLCIS(new int[]{2, 3, 4, 5, 6}));
    }
}
