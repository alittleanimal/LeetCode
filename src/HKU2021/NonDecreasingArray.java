package HKU2021;

/**
 * 665. Non-decreasing Array
 */
public class NonDecreasingArray {
    /**
     *  A: 4，2，3
     * 	B: -1，4，2，3
     * 	C: 2，3，3，2，4
     * 首先如果再前面的数不存在，比如例子A，4前面没有数字了，我们直接修改前面的数字为当前的数字2即可。
     * 而当再前面的数字存在，并且小于当前数时，比如例子B，-1小于2，我们还是需要修改前面的数字4为当前数字2；
     * 如果再前面的数大于当前数，比如例子C，3大于2，我们需要修改当前数2为前面的数3。
     * @param nums
     * @return
     */
    public boolean checkPossibility(int[] nums) {
        boolean hasDecrease = false;
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] > nums[i + 1]) {
                if (!hasDecrease) {
                    hasDecrease = true;
                    if (i == 0 || nums[i - 1] <= nums[i + 1])
                        nums[i] = nums[i + 1];
                    else
                        nums[i + 1] = nums[i];
                } else
                    return false;
            }
        }
        return true;
    }
}
