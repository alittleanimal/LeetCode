package HKU2021.March;

import org.junit.Test;

import java.util.Stack;

public class PolishNotation150 {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();

        int a, b;
        for (String item : tokens) {
            if (item.equals("+") || item.equals("-") || item.equals("*") || item.equals("/")) {
                a = stack.pop();
                b = stack.pop();
                switch (item) {
                    case "+":
                        stack.push(b + a);
                        break;
                    case "-":
                        stack.push(b - a);
                        break;
                    case "*":
                        stack.push(b * a);
                        break;
                    case "/":
                        stack.push(b / a);
                        break;
                }
            } else {
                stack.push(Integer.parseInt(item));
            }
        }

        return stack.pop();
    }

    @Test
    public void test150() {
        System.out.println(evalRPN(new String[]{"10","6","9","3","+","-11","*","/","*","17","+","5","+"}));
    }
}
