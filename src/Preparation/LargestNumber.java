package Preparation;

import java.util.Arrays;
import java.util.Comparator;

public class LargestNumber {
	
	public String largestNumber(int[] nums) {
		String[] numString = new String[nums.length];
		for(int i=0; i<nums.length; i++) {
			numString[i] = nums[i]+"";
		}
        Arrays.sort(numString, new Comparator<String>() {
			@Override
			public int compare(String o1, String o2) {
				return -(o1+o2).compareTo(o2+o1);
			} 	
		});
        StringBuilder stringBuilder = new StringBuilder();
        for(String string: numString) {
        	stringBuilder.append(string);
        }
        return stringBuilder.toString();
    }
	
	public static void main(String[] args) {
		LargestNumber largestNumber = new LargestNumber();
		int[] nums = new int[]{3,30,34,5,9};
		System.out.println(largestNumber.largestNumber(nums));
	}
}
