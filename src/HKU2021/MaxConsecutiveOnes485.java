package HKU2021;

public class MaxConsecutiveOnes485 {
    public int findMaxConsecutiveOnes(int[] nums) {
        int left = 0, count = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                count = Math.max(count, i - left);
                left = i + 1;
            }
        }

        return Math.max(count, nums.length - left);
    }
}
