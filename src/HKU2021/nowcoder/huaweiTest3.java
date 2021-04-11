package HKU2021.nowcoder;

import java.util.Scanner;

public class huaweiTest3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        String target = sc.nextLine();
        int index = sc.nextInt();

        int len = str.length();
        String strRepeat = str + str + str;
        index = index + len;

        int leftCount = 3000;
        int indexCount = 0;
        for (int i = index; i < strRepeat.length(); i++) {
            if (strRepeat.charAt(i) == target.charAt(indexCount))
                indexCount++;
            if (indexCount == target.length()) {
                leftCount = i - index;
                break;
            }
        }

        int rightCount = 3000;
        indexCount = 0;
        for (int i = index; i >= 0; i--) {
            if (strRepeat.charAt(i) == target.charAt(indexCount))
                indexCount++;
            if (indexCount == target.length()) {
                rightCount = index - i;
                break;
            }
        }

        if (leftCount == 3000 && rightCount == 3000) {
            leftCount = findAgain(str, target, index - len);
            String reverse = new StringBuffer(str).reverse().toString();
            rightCount = findAgain(reverse, target, len - 1 - (index - len));
        }

        System.out.println(Math.min(leftCount, rightCount));

    }

    private static int findAgain(String str, String target, int index) {
        int tempIndex;
        int count = 0;
        int targetIndex = 0;
        for (int i = index; i < str.length() * 10; i++) {
            tempIndex = index * str.length();
            if (str.charAt(tempIndex) == target.charAt(targetIndex)) {
                targetIndex++;
            }

            if (targetIndex == target.length()) {
                return count;
            }
            count++;
        }

        return count;
    }
}
