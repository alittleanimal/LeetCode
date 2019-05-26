import java.util.Stack;

/**
 * 找到右边第一个比他大的数
 */
public class FindRightMax {
    public int[] findRightMax(int[] nums) {
        Stack<Integer> singleStack = new Stack<>();
        int[] returnArray = new int[nums.length];
        singleStack.push(0);
        int len = nums.length;
        int i = 1;
        while (i < len) {
            if (singleStack.isEmpty() || nums[i] < nums[singleStack.peek()]) {
                singleStack.push(i);
                i++;
            } else {
                int temp = singleStack.pop();
                returnArray[temp] = i - temp;
            }
        }
        while (!singleStack.isEmpty()) {
            returnArray[singleStack.pop()] = -1;
        }
        return returnArray;
    }

    public static void main(String[] args) {
        FindRightMax findRightMax = new FindRightMax();
        int[] nums = {1, 3, 5, 4, 3, 6, 2, 9};
        int[] result = findRightMax.findRightMax(nums);
        for (int i : result) {
            System.out.println(i);
        }
    }
}
