import java.util.*;

/**
 * 输入: [5, 4, 3, 2, 1]
 输出: ["Gold Medal", "Silver Medal", "Bronze Medal", "4", "5"]
 解释: 前三名运动员的成绩为前三高的，因此将会分别被授予 “金牌”，“银牌”和“铜牌” ("Gold Medal", "Silver Medal" and "Bronze Medal").
 余下的两名运动员，我们只需要通过他们的成绩计算将其相对名次即可。
 */
public class FindRelativeRanks {

    public static String[] findRelativeRanks(int[] nums) {
        int[] rememberArray = new int[nums.length];
        System.arraycopy(nums, 0, rememberArray, 0, nums.length);
        Arrays.sort(nums);

        Map<Integer, String> recordMap = new HashMap<>();
        for (int i = nums.length - 1; i >= 0; i--) {
            if (i == nums.length - 1) {
                recordMap.put(nums[i], "Gold Medal");
            } else if (i == nums.length - 2) {
                recordMap.put(nums[i], "Silver Medal");
            } else if (i == nums.length - 3) {
                recordMap.put(nums[i], "Bronze Medal");
            } else {
                recordMap.put(nums[i], String.valueOf(nums.length - i));
            }
        }

        List<String> returnList = new ArrayList<>();
        for (int num : rememberArray) {
            returnList.add(recordMap.get(num));
        }
        return returnList.toArray(new String[returnList.size()]);
    }

    public static void main(String[] args) {
        int[] test = {7, 1, 6, 5, 4, 3, 2};
        String[] result = findRelativeRanks(test);
        System.out.println(result);
    }
}
