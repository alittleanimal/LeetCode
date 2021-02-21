package HKU2021;

import org.junit.Test;

import java.util.TreeMap;

public class LongestContinuesSubarray1438 {
    public int longestSubarray(int[] nums, int limit) {
        int left = 0, count = 0;
        int[] maxMinArray = new int[]{nums[0], nums[0]}; // {max, min}

        for (int i = 0; i < nums.length; i++) {
            updateMaxMin(maxMinArray, nums, i);

            while (maxMinArray[0] - maxMinArray[1] > limit && left < nums.length) {
                count = Math.max(count, i - left + 1);
                updateMaxMin(maxMinArray, nums, left);
                left++;
            }
        }

        return Math.max(count, nums.length - left);
    }

    private void updateMaxMin(int[] maxMinArray, int[] nums, int i) {
        if (nums[i] < maxMinArray[1]) // min
            maxMinArray[1] = nums[i];
        if (nums[i] > maxMinArray[0]) // max
            maxMinArray[0] = nums[i];
    }

    @Test
    public void test1438() {
        System.out.println(longestSubarrayBetterSol(new int[]{4,2,2,2,4,4,2,2}, 0));
    }

    public int longestSubarrayBetterSol(int[] nums, int limit) {
        TreeMap<Integer, Integer> treeMap = new TreeMap<>();

        int count = 0, left = 0;

        for (int i = 0; i < nums.length; i++) {
            treeMap.put(nums[i], treeMap.getOrDefault(nums[i], 0) + 1);
            while (treeMap.lastKey() - treeMap.firstKey() > limit) {
                count = Math.max(count, i - left);
                treeMap.put(nums[left], treeMap.get(nums[left]) - 1);
                if (treeMap.get(nums[left]) == 0) {
                    treeMap.remove(nums[left]);
                }
                left++;
            }
        }

        return Math.max(count, nums.length - left);
    }
}
