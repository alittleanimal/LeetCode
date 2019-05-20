package Preparation;

import java.util.HashMap;
import java.util.Map;


public class ContainDuplicate {
	public boolean containsDuplicate(int[] nums) {
		Map<Integer, Integer> recordMap = new HashMap();
		for(int i: nums) {
			if (!recordMap.containsKey(nums[i])) {
				recordMap.put(nums[i], 0);
			}else {
				return true;
			}
		}
		return false;
    }
	
	public boolean containsNearbyDuplicate(int[] nums, int k) {
		if (k == 0) {
			return false;
		}
		Map<Integer, Integer> recoredMap = new HashMap<>();
		for(int i=0; i<nums.length; i++) {
			if (!recoredMap.containsKey(nums[i])) {
				recoredMap.put(nums[i], i);
			} else {
				int index = recoredMap.get(nums[i]);
				if (i-index <= k) {
					return true;
				} else {
					recoredMap.put(nums[i], i);
				}
			}
		}
		return false;  
    }
}
