public class WiggleMaxLength {
    public static int wiggleMaxLength(int[] nums) {
        if (nums.length < 2) {
            return nums.length;
        }
        int[] difference = new int[nums.length - 1];
        for (int i = 1; i < nums.length; i++) {
            difference[i - 1] = nums[i] - nums[i - 1];
        }

        boolean overZero = difference[0] > 0;
        boolean startZero = difference[0] == 0;
        int sum = difference[0] == 0 ? 0 : 1;
        for (int i = 1; i < difference.length; i++) {
            if ((overZero || startZero) && difference[i] < 0) {
                sum++;
                overZero = false;
                startZero = false;
            }
            if ((!overZero || startZero) && difference[i] > 0) {
                sum++;
                overZero = true;
                startZero = false;
            }
        }
        return sum + 1;
    }

    public static void main(String[] args) {
        int[] testSum = {3,3,3,4,2};
        System.out.println(wiggleMaxLength(testSum));
    }

    public int betterWiggleMaxLength(int[] nums) {
        int n = nums.length;
        if (n < 2) {
            return n;
        }
        int up = 1;
        int down = 1;
        for (int i = 1; i < n; i++) {
            if (nums[i] > nums[i - 1]) {
                up = down + 1;
            }
            if (nums[i] < nums[i - 1]) {
                down = up + 1;
            }
        }
        return Math.max(up, down);
    }
}
