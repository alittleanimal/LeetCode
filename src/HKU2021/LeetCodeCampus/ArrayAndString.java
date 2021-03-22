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

    // 238. 除自身以外数组的乘积
    public int[] productExceptSelf(int[] nums) {
        if (nums.length == 0)
            return new int[0];

        int len = nums.length;
        int[] rightArray = new int[len];
        rightArray[len - 1] = 1;
        for (int i = len - 2; i >= 0; i--) {
            rightArray[i] = rightArray[i + 1] * nums[i + 1];
        }

        int leftRecord = 1;
        int[] res = new int[len];
        for (int i = 0; i < len; i++) {
            res[i] = leftRecord * rightArray[i];
            leftRecord *= nums[i];
        }
        return res;
    }

    // 415. 字符串相加
    public String addStrings(String num1, String num2) {
        int i = num1.length() - 1, j = num2.length() - 1;
        StringBuilder stringBuilder = new StringBuilder();
        int add = 0;
        int x, y, sum;
        while (i >= 0 || j >= 0 || add != 0) {
            x = i >= 0 ? num1.charAt(i) - '0' : 0;
            y = j >= 0 ? num2.charAt(j) - '0' : 0;
            sum = x + y + add;
            stringBuilder.append(sum % 10);
            add = sum / 10;
            i--;
            j--;
        }
        stringBuilder.reverse();
        return stringBuilder.toString();
    }

    // 1300. 转变数组后最接近目标值的数组和
    public int findBestValue(int[] arr, int target) {
        Arrays.sort(arr);
        int len = arr.length;
        int[] prefix = new int[len + 1];
        for (int i = 1; i <= len; i++) {
            prefix[i] = arr[i - 1] + prefix[i - 1];
        }

        int l = 0, r = arr[len - 1];
        int ans = 0;
        while (l <= r) {
            int middle = (l + r) / 2;
            int index = Arrays.binarySearch(arr, middle);
            if (index < 0) {
                index = -index - 1;
            }

            int sum = prefix[index] + (len - index) * middle;

            if (sum == target) {
                break;
            }
            if (sum < target) {
                ans = middle;
                l = middle + 1;
            } else {
                r = middle - 1;
            }
        }

        int chooseSmall = check(arr, ans);
        int chooseBig = check(arr, ans + 1);
        return Math.abs(chooseSmall - target) <= Math.abs(chooseBig - target) ? ans : ans + 1;
    }

    private int check(int[] arr, int x) {
        int ret = 0;
        for (int num : arr) {
            ret += Math.min(num, x);
        }
        return ret;
    }

    @Test
    public void test() {
//        System.out.println(lengthOfLongestSubstring(" "));
//        System.out.println(findMedianSortedArrays(new int[]{2}, new int[]{}));
//        System.out.println(threeSum(new int[]{0, 0, 0}));
//        System.out.println(Arrays.toString(productExceptSelf(new int[]{1, 2})));
//        System.out.println(addStrings("12342", "123"));
        System.out.println(findBestValue(new int[]{48772,52931,14253,32289,75263}, 40876));
    }


}
