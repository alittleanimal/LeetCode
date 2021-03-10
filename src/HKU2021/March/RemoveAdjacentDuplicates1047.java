package HKU2021.March;

import org.junit.Test;

import java.util.Stack;

public class RemoveAdjacentDuplicates1047 {
    public String removeDuplicates(String S) {
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < S.length(); i++) {
            if (!stack.isEmpty() && stack.peek() == S.charAt(i)) {
                stack.pop();
                continue;
            }
            stack.push(S.charAt(i));
        }
        int len = stack.size();
        char[] returnArray = new char[len];
        for (int i = len - 1; i >= 0; i--) {
            returnArray[i] = stack.pop();
        }

        return new String(returnArray);
    }

    public String removeDuplicatesBetter(String S) {
        StringBuilder stringBuilder = new StringBuilder();
        int top = -1;
        for (int i = 0; i < S.length(); i++) {
            if (top >= 0 && stringBuilder.charAt(top) == S.charAt(i)) {
                stringBuilder.deleteCharAt(top);
                top--;
            } else {
                stringBuilder.append(S.charAt(i));
                top++;
            }
        }
        return stringBuilder.toString();
    }

    @Test
    public void test1047() {
        System.out.println(removeDuplicatesBetter("abbaca"));
    }
}
