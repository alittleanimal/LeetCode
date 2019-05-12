package Preparation;

import java.util.HashMap;
import java.util.Map;

public class SingleNumber {
    public int singleNumber(int[] nums) {
        Map<Integer, Boolean> recordMap = new HashMap<>();
        for (int i: nums) {
            if (recordMap.get(i) == null) {
                recordMap.put(i, true);
            } else {
                recordMap.remove(i);
            }
        }

        return recordMap.keySet().iterator().next();
    }

    /**
     * 相同数字异或为0，2^2^3^1^1=0^3^0=3；
     * @param nums
     * @return
     */
    public int singleNumberBetter(int[] nums) {
        int num = 0;
        for(int i = 0; i < nums.length; i++){
            num = num ^ nums[i];
        }
        return num;
    }

    public static void main(String[] args) {
        int[] data = new int[]{0};
        SingleNumber sol = new SingleNumber();
        System.out.println(sol.singleNumberBetter(data));
    }
}
