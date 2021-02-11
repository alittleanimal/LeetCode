package HKU2021;

import org.junit.Test;

import java.util.Arrays;

public class PermutationInString567 {
    public boolean checkInclusion(String s1, String s2) {
        int len = s1.length();
        if (len > s2.length()) return false;
        int[] arrays = new int[26];
        int[] recordArrays = new int[26];

        for (int i = 0; i < len; i++) {
            arrays[s1.charAt(i) - 'a']++;
            recordArrays[s2.charAt(i) - 'a']++;
        }

        if (Arrays.equals(arrays, recordArrays)) {
            return true;
        }

        for (int i = len; i < s2.length(); i++) {
            recordArrays[s2.charAt(i) - 'a']++;
            recordArrays[s2.charAt(i - len) - 'a']--;
            if (Arrays.equals(arrays, recordArrays)) {
                return true;
            }
        }
        return false;
    }

    @Test
    public void test567() {
        System.out.println(checkInclusion("ab", "eidbaooo"));
    }
}
