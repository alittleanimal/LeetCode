package collection;

public class PivotIndex {

    public int pivotIndex(int[] nums) {
        int sum = 0;
        int left = 0;
        int right = 0;
        for (int num: nums) {
            sum += num;
        }

        for (int i=0; i<nums.length; i++) {
            right = sum - left -nums[i];
            if (left == right) {
                return i;
            }
            left += nums[i];
        }
        return -1;
    }
}
