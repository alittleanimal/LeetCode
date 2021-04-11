package HKU2021.nowcoder;

import java.util.Scanner;
import java.util.TreeSet;

public class huaweiTest4 {
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

        TreeSet<Integer> set = new TreeSet<>();
        for (String string : strings) {
            set.add(Integer.parseInt(string));
        }


        int res = 0;
        for (Integer item: set) {
            res += item + 1;
        }

        System.out.println(res);
    }
}
