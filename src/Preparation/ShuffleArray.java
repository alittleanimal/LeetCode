package Preparation;

import java.util.Random;

public class ShuffleArray {
	private int[] recordNums;

	public ShuffleArray(int[] nums) {
		recordNums = nums;
	}

	/** Resets the array to its original configuration and return it. */
	public int[] reset() {
		return recordNums;
	}

	/** Returns a random shuffling of the array. */
	public int[] shuffle() {
		Random random = new Random();
		int temp = 0;
		int randomInt = 0;
		int[] returnList = recordNums.clone();
		for (int j = recordNums.length - 1; j > 0; j--) {
			// random a Integer in [0,a)
			randomInt = random.nextInt(j + 1);
			temp = returnList[randomInt];
			returnList[randomInt] = returnList[j];
			returnList[j] = temp;
		}
		return returnList;
	}

	public static void main(String[] args) {
		int[] nums = new int[] { 1, 2, 3, 4 };
		ShuffleArray shuffleArray = new ShuffleArray(nums);
		int[] returnList = shuffleArray.shuffle();
		for (int i : returnList) {
			System.out.println(i);
		}
	}

}
