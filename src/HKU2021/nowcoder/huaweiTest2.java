package HKU2021.nowcoder;

import java.util.Arrays;
import java.util.Scanner;

public class huaweiTest2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        String[] strings = input.split(", ");
        if (strings.length == 1) {
            System.out.println(0);
            return;
        }

        int len = strings.length;

        strings[0] = strings[0].substring(1);
        strings[len - 1] = strings[len - 1].substring(0, 1);

        int[] intString = new int[len];
        for (int i = 0; i < len; i++) {
            intString[i] = Integer.parseInt(strings[i]);
        }
        Arrays.sort(intString);

        int res;
        if (intString[0] == intString[len - 1]) {
            res = intString[0] + 1;
        } else {
            res = intString[0] + intString[len - 1] + 2;
        }

        System.out.println(res);
    }
}
