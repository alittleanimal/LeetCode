package HKU2021.March;

import org.junit.Test;

import java.util.Stack;

public class BasicCalculator224 {
    public int calculate(String s) {
        Stack<Character> opStack = new Stack<>();
        Stack<Integer> numStack = new Stack<>();
        numStack.push(0);

        s = s.replaceAll("\\(-", "(0-");
        int len = s.length();

        char[] chars = s.toCharArray();

        for (int i = 0; i < len; i++) {
            if (chars[i] == ' ')
                continue;

            if (Character.isDigit(chars[i])) {
                int num = 0;
                while (i < len && Character.isDigit(chars[i])) {
                    num = num * 10 + (chars[i] - '0');
                    i++;
                }
                numStack.push(num);
                i--;
                continue;
            }

            if (chars[i] == '+' || chars[i] == '-') {
                while (!opStack.isEmpty() && opStack.peek() != '(') {
                    calculateNums(opStack, numStack);
                }
                opStack.push(chars[i]);
                continue;
            }

            if (chars[i] == '(') {
                opStack.push(chars[i]);
                continue;
            }

            if (chars[i] == ')') {
                while (!opStack.isEmpty() && opStack.peek() != '(') {
                    calculateNums(opStack, numStack);
                }
                opStack.pop();
            }
        }

        while (!opStack.isEmpty()) {
            calculateNums(opStack, numStack);
        }

        return numStack.pop();
    }

    private void calculateNums(Stack<Character> opStack, Stack<Integer> numStack) {
        char operator = opStack.pop();
        int num1 = numStack.pop();
        int num2 = numStack.pop();
        if (operator == '+')
            numStack.push(num1 + num2);
        else if (operator == '-')
            numStack.push(num2 - num1);
    }

    @Test
    public void test224() {
        System.out.println(calculate("-2+(-3+2+1)"));
    }
}
