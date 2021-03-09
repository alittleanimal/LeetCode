package HKU2021.March;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * 131. Palindrome Partitioning
 */
public class PalindromePartitioning131 {
    List<List<String>> ret = new ArrayList<>();
    List<String> ans = new ArrayList<>();
    int len;

    public List<List<String>> partition(String s) {
        len = s.length();
        getPartition(s.toCharArray(), 0);
        return ret;
    }

    private void getPartition(char[] charArray, int index) {
        if (index == len) {
            ret.add(new ArrayList<>(ans));
            return;
        }

        for (int i = index; i < len; i++) {
            if (findPalindrome(charArray, index, i)) {
                ans.add(new String(charArray, index, i + 1 - index));
                getPartition(charArray, i + 1);
                ans.remove(ans.size() - 1);
            }
        }
    }

    private boolean findPalindrome(char[] chars, int left, int right) {
        for (int i = left, j = right; i < j; i++, j--) {
            if (chars[i] != chars[j])
                return false;
        }
        return true;
    }

    @Test
    public void test131() {
        System.out.println(partition("abbad"));
    }
}
