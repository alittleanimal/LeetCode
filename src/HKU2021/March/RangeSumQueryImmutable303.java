package HKU2021.March;

/**
 * 303. Range Sum Query - Immutable
 */
public class RangeSumQueryImmutable303 {

    private int[] nums;
    private int[] dp;
    private int dpRecord;

    public RangeSumQueryImmutable303(int[] nums) {
        this.nums = nums;
        dp = new int[nums.length];
        dpRecord = 0;

        if (nums.length != 0) {
            dp[0] = nums[0];
            dpRecord = 1;
        }
    }

    public int sumRange(int i, int j) {
        if (nums.length == 0)
            return 0;

        if (j >= dpRecord) {
            for (; dpRecord <= j; dpRecord++) {
                dp[dpRecord] = dp[dpRecord - 1] + nums[dpRecord];
            }
        }

        if (i == 0)
            return dp[j];
        else
            return dp[j] - dp[i - 1];
    }


    public static void main(String[] args) {
        RangeSumQueryImmutable303 rs = new RangeSumQueryImmutable303(new int[]{1});
        System.out.println(rs.sumRange(0, 0));
//        System.out.println(rs.sumRange(2, 5));
//        System.out.println(rs.sumRange(0, 5));
    }
}
