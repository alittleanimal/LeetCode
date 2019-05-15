package Preparation;

import java.util.HashMap;
import java.util.Map;

/**
 * 给定一个大小为 n 的数组，找到其中的众数。众数是指在数组中出现次数大于 ⌊ n/2 ⌋ 的元素。

 你可以假设数组是非空的，并且给定的数组总是存在众数。

 示例 1:

 输入: [3,2,3]
 输出: 3

 示例 2:

 输入: [2,2,1,1,1,2,2]
 输出: 2


 */
public class MajorityElement {
    public int majorityElement(int[] nums) {
        Map<Integer,Integer> recordMap = new HashMap<>();
        int maxNum = 0;
        for (int i: nums) {
            if (recordMap.get(i) == null) {
                recordMap.put(i,1);
                maxNum = maxNum==0 ? 1:maxNum;
            } else {
                int temp = recordMap.get(i) + 1;
                recordMap.put(i, temp);
                if (temp > maxNum) {
                    maxNum = temp;
                }
            }
        }

        if (maxNum > nums.length/2) {
            for (Map.Entry<Integer, Integer> map : recordMap.entrySet()) {
                if (map.getValue().equals(maxNum)) {
                    return map.getKey();
                }
            }
        }
        return -1;
    }

    /**
     * 采用摩尔投票法，num为当前阶段出现次数超过半数的元素
     * @param nums
     * @return
     */
    private int betterMajorityElement(int[] nums) {
        int count = 0;
        int num = nums[0];
        for (int i=0; i<nums.length; i++) {
            if (num == nums[i]) {
                count++;
            }else {
                count--;
                if (count == 0) {
                    num = nums[i];
                    count ++;
                }
            }
        }
        return num;
    }
}
