package HKU2021.LeetCodeCampus;

import org.junit.Test;

import java.util.*;

public class ArrayAndString {

    // 3. 无重复字符的最长子串
    public int lengthOfLongestSubstring(String s) {
        Set<Character> set = new HashSet<>();
        int left = 0;
        int maxCount = 0;

        for (int i = 0; i < s.length(); i++) {
            while (set.contains(s.charAt(i))) {
                set.remove(s.charAt(left));
                left++;
            }
            set.add(s.charAt(i));
            maxCount = Math.max(maxCount, i - left + 1);
        }
        return maxCount;
    }

    // 4. 寻找两个正序数组的中位数
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int len1 = nums1.length;
        int len2 = nums2.length;
        if (len1 == 0 && len2 == 0)
            return 0.0;

        int target = (len1 + len2) / 2;
        int index = 0;
        int i = 0, j = 0;
        int[] record = new int[len1 + len2];

        while (index <= target && i < len1 && j < len2) {
            if (nums1[i] < nums2[j]) {
                record[index] = nums1[i];
                i++;
            } else {
                record[index] = nums2[j];
                j++;
            }
            index++;
        }

        while (index <= target && i == len1) {
            record[index] = nums2[j];
            j++;
            index++;
        }
        while (index <= target && j == len2) {
            record[index] = nums1[i];
            i++;
            index++;
        }

        if ((len1 + len2) % 2 == 0) {
            return (record[target - 1] + record[target]) / 2.0;
        } else {
            return record[target];
        }
    }

    // 15. 三数之和
    public List<List<Integer>> threeSum(int[] nums) {
        int left, right;
        int len = nums.length;
        if (len < 3)
            return new ArrayList<>();
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        int sum;
        for (int i = 0; i < len; i++) {
            if (i > 0 && nums[i] == nums[i - 1])
                continue;
            left = i + 1;
            right = len - 1;

            while (left < right) {

                sum = nums[i] + nums[left] + nums[right];
                if (sum == 0) {
                    res.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    left++;
                    right--;
                    while (left < right && nums[right] == nums[right + 1] && nums[left] == nums[left - 1]) {
                        left++;
                        right--;
                    }

                } else if (sum > 0) {
                    right--;
                    while (left < right && nums[right] == nums[right + 1])
                        right--;

                } else {
                    left++;
                    while (left < right && nums[left] == nums[left - 1])
                        left++;
                }
            }
        }
        return res;
    }

    @Test
    public void test() {
//        System.out.println(lengthOfLongestSubstring(" "));
//        System.out.println(findMedianSortedArrays(new int[]{2}, new int[]{}));
        System.out.println(threeSum(new int[]{0, 0, 0}));
    }


}
