import java.util.HashMap;
import java.util.Map;


/**
 * 给定一个未排序的整数数组，找出其中没有出现的最小的正整数。

 示例 1:

 输入: [1,2,0]
 输出: 3

 示例 2:

 输入: [3,4,-1,1]
 输出: 2

 示例 3:

 输入: [7,8,9,11,12]
 输出: 1

 说明:

 你的算法的时间复杂度应为O(n)，并且只能使用常数级别的空间。

 */
public class FirstMissingPositive {

    public int firstMissingPositive(int[] nums) {
        Map<Integer, Boolean> saveMap = new HashMap<>();
        for (int num: nums) {
            if (num > 0) {
                saveMap.put(num, true);
            }
        }
        for (int i=1; i<100000; i++) {
            if (saveMap.get(i) == null) {
                return i;
            }
        }
        return 0;
    }

    public static int betterFirstMissingPositive(int[] nums) {
        int[] save = new int[nums.length];
        for (int num : nums) {
            if (num > 0 && num < nums.length) {
                save[num-1] = num;
            }
        }
        int i = 0;
        for (i = 0; i < save.length; i++) {
            if (save[i] != i + 1) {
                break;
            }
        }
        return i + 1;
    }

    public static void main(String[] args) {
        int[] test = {3, 4, -1, 1};

        System.out.println(betterFirstMissingPositive(test));
    }
}
