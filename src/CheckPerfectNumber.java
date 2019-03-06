import java.util.ArrayList;
import java.util.List;

/**
 * 对于一个 正整数，如果它和除了它自身以外的所有正因子之和相等，我们称它为“完美数”。

 给定一个 正整数 n， 如果他是完美数，返回 True，否则返回 False
 */
public class CheckPerfectNumber {
    public static boolean checkPerfectNumber(int num) {
        if (num == 0 || num == 1) {
            return false;
        }

        List<Integer> divisorList = getDivisor(num);
        int sum = 0;
        for (int i = 0; i < divisorList.size(); i++) {
            sum += divisorList.get(i);
        }

        if (sum == num) {
            return true;
        } else {
            return false;
        }
    }

    private static List<Integer> getDivisor(int num) {
        List<Integer> divisorList = new ArrayList<>();

        for (int i = 1; i<= num/2; i++) {
            if (num%i == 0) {
                divisorList.add(i);
            }
        }

        return divisorList;
    }

    public static void main(String[] args) {
        boolean temp = checkPerfectNumber(28);
        System.out.println(temp);
    }
}
