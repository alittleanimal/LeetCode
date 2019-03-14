import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class ExpressiveWords {

    /**
     * 有时候人们会用额外的字母来表示额外的情感，比如 "hello" -> "heeellooo", "hi" -> "hiii"。我们将连续的相同的字母分组，并且相邻组的字母都不相同。我们将一个拥有三个或以上字母的组定义为扩张状态（extended），如第一个例子中的 "e" 和" o" 以及第二个例子中的 "i"。 此外，"abbcccaaaa" 将有分组 "a" , "bb" , "ccc" , "dddd"；其中 "ccc" 和 "aaaa" 处于扩张状态。

     对于一个给定的字符串 S ，如果另一个单词能够通过将一些字母组扩张从而使其和 S 相同，我们将这个单词定义为可扩张的（stretchy）。我们允许选择一个字母组（如包含字母 c ），然后往其中添加相同的字母 c 使其长度达到 3 或以上。注意，我们不能将一个只包含一个字母的字母组，如 "h"，扩张到一个包含两个字母的组，如 "hh"；所有的扩张必须使该字母组变成扩张状态（至少包含三个字母）。

     输入一组单词，输出其中可扩张的单词数量。

     示例：
     输入：
     S = "heeellooo"
     words = ["hello", "hi", "helo"]
     输出：1
     解释：
     我们能通过扩张"hello"的"e"和"o"来得到"heeellooo"。
     我们不能通过扩张"helo"来得到"heeellooo"因为"ll"不处于扩张状态。
     * @param S
     * @param words
     * @return
     */
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

    public int betterSolution(String S, String[] words) {
        int count = 0;
        for (String w : words) {
            int i = 0;
            int j = 0;
            if (w.length() <= S.length()) {
                for (j = 0; j < S.length(); j++) {
                    /* Error in Java
                        if (i < w.length() && w[i] == S[j]) i++;
                        else if (S[j] == S[j - 1] && (S[j] == S[j + 1] || S[j] == S[j - 2])) ; //判断是否连续的字符，如果是则什么都不做
                        else break;
                    */
                }
            }
            if (i == w.length() && j == S.length()) count++; //类似于双指针 最后只要i与j相等及说明可以扩张得到
        }
        return count;
    }
}
