package Preparation;

public class MaxProduct {
    public int maxProduct(int[] nums) {

        int[] dpMax = new int[nums.length];
        int[] dpMin = new int[nums.length];
        dpMax[0] = dpMin[0] = nums[0];

        for (int i=1; i<nums.length; i++) {
            if (nums[i] >=0) {
                dpMax[i] = Math.max(dpMax[i-1]*nums[i], nums[i]);
                dpMin[i] = Math.min(dpMin[i-1]*nums[i], nums[i]);
            } else {
                dpMax[i] = Math.max(dpMin[i-1]*nums[i], nums[i]);
                dpMin[i] = Math.min(dpMax[i-1]*nums[i], nums[i]);
            }
        }

        int max = Integer.MIN_VALUE;
        for (int i=0; i<dpMax.length; i++) {
            if (max<dpMax[i]) {
                max = dpMax[i];
            }
        }

        return max;

    }

    public static void main(String[] args) {
        MaxProduct maxProduct = new MaxProduct();
        int[] nums = new int[]{2,3,-2,4,-5,-6,3};
        System.out.println(maxProduct.maxProduct(nums));

    }
}
