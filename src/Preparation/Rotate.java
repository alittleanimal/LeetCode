package Preparation;

public class Rotate {
    public void rotate(int[] nums, int k) {
        int temp = nums[0];
        int length = nums.length;
        int i = 0;
        for (int j = 0; j < nums.length; j++) {
            i = (i + k) % length;
            int remember = nums[i];
            nums[i] = temp;
            temp = remember;
        }
    }

    public static void main(String[] args) {
        Rotate rotate = new Rotate();
        int[] nums = new int[]{1,2,3,4,5,6,7};
        rotate.rotate(nums, 3);
        for (int i: nums) {
            System.out.println(i);
        }

    }
}
