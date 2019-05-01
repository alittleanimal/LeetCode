/**
 * 如果一个由 '0' 和 '1' 组成的字符串，是以一些 '0'（可能没有 '0'）后面跟着一些 '1'（也可能没有 '1'）的形式组成的，那么该字符串是单调递增的。

 我们给出一个由字符 '0' 和 '1' 组成的字符串 S，我们可以将任何 '0' 翻转为 '1' 或者将 '1' 翻转为 '0'。

 返回使 S 单调递增的最小翻转次数。
 */
public class MinFlipsMonoIncr {
    public static int minFlipsMonoIncr(String S) {
        int sum1 = 0;
        int sum0 = 0;
        boolean changeFlag = false;
        char[] charS = S.toCharArray();
        for (int i = 0; i < charS.length; i++) {
            if (charS[i] == '1') {
                changeFlag = true;
                sum1++;
            }
            if (charS[i] == '0' && changeFlag) {
                sum0++;
            }
        }
        return sum0 > sum1 ? sum1 : sum0;
    }

    /**
     * 1. 假定有一个分界点P，使前面的1和后面的0个数之和最小
     * 2. 计算出所有0的个数
     * 3. 遍历S， 如果S[i]为0，则P后面的0减一， 如果S[i]为1，则前面的1加一
     * 4. 每一步计算sum_0_after和sum_1_before的最小值
     * @param S
     * @return
     */
    public static int betterMinFlips(String S) {
        int sum_0_after = 0;
        int sum_1_before = 0;
        int returnNum = 0;
        for (char c: S.toCharArray()) {
            if (c == '0') {
                sum_0_after++;
            }
        }
        returnNum = sum_0_after;
        for (char c: S.toCharArray()) {
            if (c == '0') {
                sum_0_after--;
            } else {
                sum_1_before++;
            }
            returnNum = Math.min(returnNum, (sum_0_after + sum_1_before));
        }

        return returnNum;
    }

    public static void main(String[] args) {
        System.out.println(betterMinFlips("0101100011"));
    }
}

