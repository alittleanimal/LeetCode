package HKU2021.nowcoder;

import java.util.Arrays;
import java.util.Scanner;

public class huaweiTest {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input;
        String[] strs;
        String[] score;

        int[] res = new int[26];
        Arrays.fill(res, -1);


        while (sc.hasNext()) {
            input = sc.nextLine();
            strs = input.split(" ");
            score = strs[1].split(":");

            if (res[strs[0].charAt(0) - 'a'] == -1) {
                res[strs[0].charAt(0) - 'a']++;
            }
            if (res[strs[0].charAt(2) - 'a'] == -1) {
                res[strs[0].charAt(2) - 'a']++;
            }

            if (Integer.parseInt(score[0]) > Integer.parseInt(score[1])) {
                res[strs[0].charAt(0) - 'a'] += 3;
            } else if (Integer.parseInt(score[0]) == Integer.parseInt(score[1])) {
                res[strs[0].charAt(0) - 'a']++;
                res[strs[0].charAt(2) - 'a']++;
            } else {
                res[strs[0].charAt(2) - 'a'] += 3;
            }
        }

        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < res.length; i++) {
            if (res[i] != -1) {
                if (i != 0) {
                    builder.append(",");
                }
                builder.append((char) ('a' + i));
                builder.append(" ");
                builder.append(res[i]);
            }
        }
        System.out.println(builder.toString());
    }
}
