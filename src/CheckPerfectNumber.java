import java.util.ArrayList;
import java.util.List;

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
