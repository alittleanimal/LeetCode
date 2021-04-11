package HKU2021;

import org.junit.Test;

import java.util.*;

public class ThreeSum15 {
    public List<List<Integer>> threeSum(int[] nums) {
        int len = nums.length;
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < len; i++) {
            Map<Integer, Integer> recordMap = new HashMap<>();
            int temp = 13 - nums[i];
            for (int j = i + 1; j < len; j++) {
                if (recordMap.containsKey(temp - nums[j])) {
                    res.add(Arrays.asList(nums[i], nums[j], temp - nums[j]));
                } else {
                    recordMap.put(nums[j], j);
                }
            }
        }
        return res;
    }

    public static List<List<Integer>> threeSum(int[] nums, int target) {
        List<List<Integer>> resultList = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            Map<Integer, Integer> map = new HashMap<>();
            int d1 = target - nums[i];
            //寻找两数之和等于d1的组合
            for (int j = i + 1; j < nums.length; j++) {
                int d2 = d1 - nums[j];
                if (map.containsKey(d2)) {
                    resultList.add(Arrays.asList(nums[i], d2, nums[j]));
                }
                map.put(nums[j], j);
            }
        }
        return resultList;
    }

    public List<List<Integer>> threeSumSearch(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        int len = nums.length;
        if (len < 3)
            return res;

        for (int i = 0; i < len; i++) {
            if (nums[i] > 0) {
                break;
            }
            if (i > 0 && nums[i] == nums[i-1]) {
                continue;
            }
            int j = i + 1, k = len - 1;
            int temp = -nums[i];
            while (j < k) {
                if (temp == nums[j] + nums[k]) {
                    res.add(Arrays.asList(nums[i], nums[j], nums[k]));
                    j++;
                    k--;
                    while (j < k && nums[k] == nums[k + 1] && nums[j] == nums[j - 1]) {
                        j++;
                        k--;
                    }
                } else if (temp > nums[j] + nums[k]) {
                    while (j < k && nums[j + 1] == nums[j])
                        j++;
                    j++;
                } else {
                    while (j < k && nums[k - 1] == nums[k]) {
                        k--;
                    }
                    k--;
                }
            }
        }
        return res;
    }

    @Test
    public void test15() {
        System.out.println(threeSumSearch(new int[]{-2,0,0,2,2}).toString());
    }
}
