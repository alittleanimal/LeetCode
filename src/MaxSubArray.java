/**
 * 给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
 *
 * 示例:
 *
 * 输入: [-2,1,-3,4,-1,2,1,-5,4],
 * 输出: 6
 * 解释: 连续子数组 [4,-1,2,1] 的和最大，为 6。
 * 进阶:
 *
 * 如果你已经实现复杂度为 O(n) 的解法，尝试使用更为精妙的分治法求解。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/maximum-subarray
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class MaxSubArray {
    public int[] maxSubArray(int[] nums) {
        int maxValue = nums[0];
        int rememberValue = 0;
        int left = 0;
        int right = 0;
        int possibleLeft = 0;
        int possibleRight = 0;
        for (int i = 0; i<nums.length; i++) {
            rememberValue += nums[i];
            if (maxValue < rememberValue) {
                maxValue = rememberValue;
                right = i;
                left = possibleLeft;
            }
            if (rememberValue < 0) {
                rememberValue = 0;
                possibleLeft = i;
            }
        }
        int[] returnResult = new int[right-left];
        if (left == 0 && right == 0) {
            returnResult[0] = nums[0];
        }else {
            for (int i = left+1, j=0; i<=right; i++, j++) {
                returnResult[j] = nums[i];
            }
        }
        return returnResult;
    }

    public static void main(String[] args) {
        MaxSubArray maxSubArray = new MaxSubArray();
        int[] nums = new int[]{-2,1,-3,4,-1,2,1,-5,4};
        for (int num: maxSubArray.maxSubArray(nums)) {
            System.out.println(num);
        }
    }
}
