package Preparation;

public class MoveZeroes {
	public void moveZeroes(int[] nums) {
        int numberIndex = 0;
        for(int i=0; i<nums.length; i++) {
        	if (nums[i] != 0) {
				nums[numberIndex] = nums[i];
				numberIndex++;
			}
        }
        for(int i=numberIndex; i<nums.length; i++) {
        	nums[i] = 0;
        }
    }
}
