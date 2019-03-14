import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class ExpressiveWords {

    public static int expressiveWords(String S, String[] words) {
        List<String> patternList = new ArrayList<>();
        char[] chars = S.toCharArray();
        if (chars.length == 0) {
            return 0;
        }
        patternList.add(String.valueOf(chars[0]));
        for (int i = 1; i < chars.length; i++) {
            if (chars[i] == chars[i - 1]) {
                String temp = patternList.get(patternList.size() - 1);
                patternList.set(patternList.size() - 1, temp + chars[i]);
            } else {
                patternList.add(String.valueOf(chars[i]));
            }
        }

        StringBuilder pattern = new StringBuilder();
        for (String patternString : patternList) {
            if (patternString.length() > 2) {
                pattern.append(patternString.substring(0, 1)).append("+");
            } else {
                pattern.append(patternString);
            }
        }
        int count = 0;
        for (String word : words) {
            if (Pattern.matches(pattern.toString(), word) && word.length() <= S.length()) {
                count++;
            }
        }

        return count;
    }

    public static void main(String[] args) {

        String[] temp = {"hello", "hi", "helo"};
        String[] temp1 = {"aaaa"};
        System.out.println(expressiveWords("aaa", temp1));
    }
}
