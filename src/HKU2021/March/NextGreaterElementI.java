package HKU2021.March;

import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class NextGreaterElementI {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {

        if (nums1.length == 0 || nums2.length == 0)
            return new int[0];

        int[] dp = new int[nums2.length];
        boolean[] changed = new boolean[nums2.length];
        dp[0] = nums2[0];
        changed[0] = false;

        for (int i = 1; i < nums2.length; i++) {
            dp[i] = nums2[i];
            changed[i] = false;
            for (int j = 0; j < i; j++) {
                if (!changed[j] && nums2[i] > dp[j]) {
                    dp[j] = nums2[i];
                    changed[j] = true;
                }
            }
        }

        int index;
        int[] res = new int[nums1.length];
        for (int i = 0; i < nums1.length; i++) {
            index = Arrays.binarySearch(nums2, nums1[i]); // binarySearch sorted array...
            if (!changed[index])
                res[i] = -1;
            else
                res[i] = dp[index];
        }
        return res;
    }

    @Test
    public void test496() {
        System.out.println(Arrays.toString(nextGreaterElementBetter(new int[]{2, 4}, new int[]{1, 2, 3, 4})));
    }

    public int[] nextGreaterElementBetter(int[] nums1, int[] nums2) {
        Stack<Integer> stack = new Stack<>();
        Map<Integer, Integer> recordMap = new HashMap<>();

        for (int value : nums2) {
            while (!stack.isEmpty() && value > stack.peek()) {
                recordMap.put(stack.pop(), value);
            }

            stack.push(value);
        }
        while (!stack.isEmpty()) {
            recordMap.put(stack.pop(), -1);
        }

        int[] res = new int[nums1.length];
        for (int i = 0; i < nums1.length; i++) {
            res[i] = recordMap.get(nums1[i]);
        }
        return res;
    }

}
