package HKU2021;

import org.junit.Test;

/**
 * 643. Maximum Average Subarray I
 */
public class MaximumAverageSubarrayI643 {
    public double findMaxAverage(int[] nums, int k) {
        int left = 0;
        int max = Integer.MIN_VALUE;
        int tempMax = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i - left + 1 > k) {
                max = Math.max(max, tempMax);
                tempMax -= nums[left];
                left++;
            }
            tempMax += nums[i];
        }
        return Math.max(max, tempMax) / (double) k;
    }

    public double findMaxAverageB(int[] nums, int k) {
        int sum = 0;
        for (int i = 0; i < k; i++) {
            sum += nums[i];
        }

        int sumK = sum;
        for (int j = k; j < nums.length; j++) {
            sumK = sumK + nums[j] - nums[j - k];
            sum = Math.max(sumK, sum);
        }

        double ans = sum / (double) k;
        return ans;
    }

    @Test
    public void test643() {
        System.out.println(findMaxAverage(new int[]{9, 7, 3, 5, 6, 2, 0, 8, 1, 9}, 6));
    }
}
