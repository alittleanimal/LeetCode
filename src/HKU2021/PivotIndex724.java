package HKU2021;

import org.junit.Test;

public class PivotIndex724 {
    public int pivotIndex(int[] nums) {
        if (nums.length < 3) {
            if (nums.length == 1) return 0;
            return -1;
        }

        int[] recordArray = new int[nums.length];
        recordArray[0] = nums[0];

        for (int i = 1; i < nums.length; i++) {
            recordArray[i] = recordArray[i - 1] + nums[i];
        }

        if (recordArray[nums.length - 1] - recordArray[0] == 0)
            return 0;

        for (int j = 1; j < nums.length; j++) {
            if (recordArray[j - 1] == recordArray[nums.length - 1] - recordArray[j])
                return j;
        }
        return -1;
    }

    public int pivotIndexBetterSol(int[] nums) {
        int sum = 0;

        for (int num: nums) {
            sum += num;
        }

        int leftSum = 0;
        for (int i = 0; i < nums.length; i++) {
            if (leftSum * 2 == sum - nums[i])
                return i;
            leftSum += nums[i];
        }
        return -1;
    }

    @Test
    public void test724() {
        System.out.println(pivotIndexBetterSol(new int[]{1,2}));
    }
}
