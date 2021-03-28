package HKU2021;

import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TwoSum1 {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> recordMap = new HashMap<>();
        int[] res = new int[2];

        for (int i = 0; i < nums.length; i++) {
            if (recordMap.containsKey(target - nums[i])) {
                res[0] = recordMap.get(target - nums[i]);
                res[1] = i;
            } else {
                recordMap.put(nums[i], i);
            }
        }

        return res;
    }

    @Test
    public void test1() {
        System.out.println(Arrays.toString(twoSum(new int[]{2, 7, 11, 15}, 9)));
    }
}
