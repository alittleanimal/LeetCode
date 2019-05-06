import java.util.*;

/**
 * 给定一个整型数组, 你的任务是找到所有该数组的递增子序列，递增子序列的长度至少是2。

 示例:

 输入: [4, 6, 7, 7]
 输出: [[4, 6], [4, 7], [4, 6, 7], [4, 6, 7, 7], [6, 7], [6, 7, 7], [7,7], [4,7,7]]

 说明:

 给定数组的长度不会超过15。
 数组中的整数范围是 [-100,100]。
 给定数组中可能包含重复数字，相等的数字应该被视为递增的一种情况。


 */
public class FindSubsequences {
    private Set<List<Integer>> returnList = new HashSet<>();

    public List<List<Integer>> findSubsequences(int[] nums) {
        helper(nums, 0, new ArrayList<>());
        return  new ArrayList<>(returnList);
    }

    private void helper(int nums[], int start, List<Integer> saveArray) {
        if (saveArray.size() > 1) {
            List<Integer> temp = new ArrayList<>(saveArray);
            returnList.add(temp);
        }
        for (int i = start; i < nums.length; i++) {
            if (saveArray.size() == 0 || nums[i] >= saveArray.get(saveArray.size() - 1)) {
                saveArray.add(nums[i]);
                helper(nums, i + 1, saveArray);
                saveArray.remove(saveArray.size() - 1);
            }
        }
    }

    public static void main(String[] args) {
        int[] nums = {4,6,7,7};
        FindSubsequences findSubsequences = new FindSubsequences();
        List<List<Integer>> result = findSubsequences.findSubsequences(nums);
        Iterator iterator = result.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next().toString());
        }
    }
}
