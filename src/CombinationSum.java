import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;

public class CombinationSum {

	private List<List<Integer>> resultList;
    public List<List<Integer>> combinationSum3(int k, int n) {
    	resultList = new ArrayList<>();
    	findCombination3(k, n, 1, new ArrayList<>());
    	return resultList;
    }
    
    private void findCombination3(int times, int target, int index, List<Integer> recordList) {
    	if (recordList.size() == times) {
    		if (target == 0) {				
    			resultList.add(new ArrayList<>(recordList));
			}
    		return;
		}
    	for (int i = index; i<10; i++) {
    		recordList.add(i);
    		findCombination3(times, target-i, i+1, recordList);
    		recordList.remove(recordList.size() - 1);
    	}
    }
    
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
		Arrays.sort(candidates);
		resultList = new ArrayList<>();
		findCombination2(target, 0, candidates, new ArrayList<>());
    	return resultList;   
    }
    
    private void findCombination2(int target, int index, int[] candidates, List<Integer> recordList) {
    	if (target == 0) {
    		if (!resultList.contains(recordList)) {				
    			resultList.add(new ArrayList<>(recordList));
			}
			return;
		} else if (target < 0) {
			return;
		}
    	
    	for (int i = index; i<candidates.length; i++) {
    		if (i > index && candidates[i - 1] == candidates[i]) {
				continue;
			}
    		recordList.add(candidates[i]);
    		findCombination2(target - candidates[i], i+1, candidates, recordList);
    		recordList.remove(recordList.size() - 1);
    	}
    }
    
    public int combinationSum4(int[] nums, int target) {
		int res = 0;
    	if (target == 0) {
			return 1;
		} 
		for (int i = 0; i<nums.length; i++) {
			if (target >= nums[i]) {				
				res += combinationSum4(nums, target - nums[i]);
			}
		}
		return res;
    }
    
    private int[] memo;

    public int combinationSum4_2(int[] nums, int target) {
        memo = new int[target + 1];
        Arrays.fill(memo, -1);
        memo[0] = 1;
        return search(nums, target);
    }

    private int search(int[] nums, int target) {
        if (memo[target] != -1) {
            return memo[target];
        }
        int res = 0;
        for (int num : nums) {
            if (target >= num) {
                res += search(nums, target - num);
            }
        }
        memo[target] = res;
        return res;
    }
    
    public static void main(String[] args) {
    	CombinationSum combinationSum = new CombinationSum();
//    	combinationSum.combinationSum3(2, 7);
    	int[] nums = {1,2,3};
    	int result = combinationSum.combinationSum4(nums, 4);
    	System.out.println(result);
    }
}
