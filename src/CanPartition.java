public class CanPartition {
    /**
     * 给定一个只包含正整数的非空数组。是否可以将这个数组分割成两个子集，使得两个子集的元素和相等。

     注意:

     每个数组中的元素不会超过 100
     数组的大小不会超过 200

     示例 1:

     输入: [1, 5, 11, 5]

     输出: true

     解释: 数组可以分割成 [1, 5, 5] 和 [11].



     示例 2:

     输入: [1, 2, 3, 5]

     输出: false

     解释: 数组不能分割成两个元素和相等的子集.

     * @param nums
     * @return
     */
    public static boolean canPartition(int[] nums) {
        int n = nums.length;
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += nums[i];
        }
        int t = sum / 2;
        if (sum % 2 != 0) {
            return false;
        }
        int[] dp = new int[t + 1];
        for (int i = 0; i < n; i++) {
            for (int j = t; j >= nums[i]; j--) {
                dp[j] = Math.max(dp[j], dp[j - nums[i]] + nums[i]);
            }
        }
        if (dp[t] == t) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        int[] test = {1,5,11,5};
        System.out.println(canPartition(test));
    }
}
