package HKU2021;

import java.util.Arrays;

/**
 * 561. Array Partition I
 */
public class ArrayPartitionI561 {
    public int arrayPairSum(int[] nums) {
        Arrays.sort(nums);
        int result = 0;
        for (int i = 0; i < nums.length; i += 2) {
//            result += Math.min(nums[i], nums[i + 1]);
            // 把数组下标为偶数的数加起来
            result += nums[i];
        }
        return result;
    }
}
