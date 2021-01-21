package HKU2021;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * 628. Maximum Product of Three Numbers
 */
public class MaxProduct628 {
    public int maximumProduct(int[] nums) {
        if (nums.length == 3) return nums[0] * nums[1] * nums[2];
        if (nums.length == 4) {
            int max = Math.max(nums[0] * nums[1] * nums[2], nums[0] * nums[1] * nums[3]);
            max = Math.max(max, nums[0] * nums[2] * nums[3]);
            return Math.max(max, nums[1] * nums[2] * nums[3]);
        }
        List<Integer> list = new ArrayList<>();
        for (int num : nums) {
            list.add(num);
        }
        Collections.sort(list);

        int len = list.size();
        if (list.get(0) < 0 && list.get(1) < 0) {
            return Math.max(list.get(0) * list.get(1) * list.get(len - 1), list.get(len - 3) * list.get(len - 2) * list.get(len - 1));
        } else {
            return list.get(len - 3) * list.get(len - 2) * list.get(len - 1);
        }
    }

    /**
     * 最大的三个的正数
     * 或者最小的两个负数和最大的正数
     * @param nums
     * @return
     */
    public int maximumProductBetterSol(int[] nums) {
        Arrays.sort(nums);
        return Math.max(nums[nums.length - 1] * nums[nums.length - 2] * nums[nums.length - 3], nums[0] * nums[1] * nums[nums.length - 1]);
    }

    @Test
    public void test628() {
        System.out.println(maximumProductBetterSol(new int[]{-100, -2, -3, 1}));
    }
}
