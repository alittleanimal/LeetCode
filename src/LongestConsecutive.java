import java.util.*;

/**
 * 给定一个未排序的整数数组，找出最长连续序列的长度。

 要求算法的时间复杂度为 O(n)。

 示例:

 输入: [100, 4, 200, 1, 3, 2]
 输出: 4
 解释: 最长连续序列是 [1, 2, 3, 4]。它的长度为 4。


 */
public class LongestConsecutive {

    private static int longestConsecutive(int[] nums) {
        Arrays.sort(nums);
        List<Integer> rememberList = new ArrayList<>();
        List<Integer> newList = new ArrayList<>();
        if(nums.length != 0 && nums.length != 1) {
            newList.add(nums[0]);
            for (int i = 1; i < nums.length; i++) {
                System.out.println(nums[i]);
                if(nums[i] == nums[i-1] + 1) {
                    newList.add(nums[i]);
                } else if(nums[i] == nums[i-1]) {
                    continue;
                }else {
                    if (newList.size() > rememberList.size()) {
                        rememberList = new ArrayList<>(newList);
                    }
                    newList.clear();
                    newList.add(nums[i]);
                }
            }

            if (newList.size() > rememberList.size()) {
                rememberList = new ArrayList<>(newList);
            }
            return rememberList.size();
        } else if (nums.length == 1){
            return 1;
        } else {
            return 0;
        }

    }

    public int longestConsecutiveSample(int[] nums) {
        /**
         利用一个map保存各个候选最长序列的左右边界及其长度, 例如{1,2,3,4,5}中数字1和5对应的长度都是5
         依次遍历每个数num, 如果map中存在num-1或num+1则更新num所处的序列长度及其边界值
         **/
        int ret = 0;
        Map<Integer, Integer> map = new HashMap<>();

        for(int num : nums) {
            if(!map.containsKey(num)) {
                // 获取左右边界对应的序列长度
                int left = map.getOrDefault(num-1, 0);
                int right = map.getOrDefault(num+1, 0);
                // 更新最长序列长度
                int len = left+right+1;
                ret = len > ret ? len : ret;
                map.put(num-left, len);
                map.put(num+right, len);
                // 把num加入map中防止重复判断(关键在于将num加入keyset中, value可以是任意值)
                map.put(num, len);
            }
        }
        return ret;
    }

    public static void main(String[] args) {
        System.out.println("Hello World!");
        int[] a = {1,2,0,1};
        int test = longestConsecutive(a);
        System.out.println(test);
    }

}
