package HKU2021;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * 697. Degree of an Array
 */
public class DegreeOfAnArray697 {
    public int findShortestSubArray(int[] nums) {
        int count = 1;
        Map<Integer, int[]> recordMap = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            // count, first appear index, last appear index
            int[] tempArray = recordMap.getOrDefault(nums[i], new int[]{});
            if (tempArray.length == 0) {
                recordMap.put(nums[i], new int[]{1, i, i});
            } else {
                tempArray[0]++;
                tempArray[2] = i;
                recordMap.put(nums[i], tempArray);
                count = Math.max(count, tempArray[0]);
            }
        }

        int finalCount = count;
        int res = Integer.MAX_VALUE;
        for (Map.Entry<Integer, int[]> mapItem: recordMap.entrySet()) {
            if (finalCount == mapItem.getValue()[0]) {
                res = Math.min(res, mapItem.getValue()[2] - mapItem.getValue()[1] + 1);
            }
        }
        return res;
    }

    @Test
    public void test697() {
        System.out.println(findShortestSubArray(new int[]{1,2,2,3,1,4,2}));
    }
}
