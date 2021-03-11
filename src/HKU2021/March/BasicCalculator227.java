package HKU2021.March;

import org.junit.Test;

import java.util.Stack;

/**
 * 对于「任何表达式」而言，我们都使用两个栈 nums 和 ops：
 *
 * nums ： 存放所有的数字
 * ops ：存放所有的数字以外的操作
 * 然后从前往后做，对遍历到的字符做分情况讨论：
 *
 * 空格 : 跳过
 * ( : 直接加入 ops 中，等待与之匹配的 )
 * ) : 使用现有的 nums 和 ops 进行计算，直到遇到左边最近的一个左括号为止，计算结果放到 nums
 * 数字 : 从当前位置开始继续往后取，将整一个连续数字整体取出，加入 nums
 * + - * / ^ % : 需要将操作放入 ops 中。在放入之前先把栈内可以算的都算掉（只有「栈内运算符」比「当前运算符」优先级高/同等，才进行运算），使用现有的 nums 和 ops 进行计算，直到没有操作或者遇到左括号，计算结果放到 nums
 *
 *     Map<Character, Integer> map = new HashMap<>(){{
 *         put('-', 1);
 *         put('+', 1);
 *         put('*', 2);
 *         put('/', 2);
 *         put('%', 2);
 *         put('^', 3);
 *     }};
 *
 */
public class BasicCalculator227 {
    public int calculate(String s) {
        Stack<Character> opStack = new Stack<>();
        Stack<Integer> numStack = new Stack<>();

        numStack.push(0);
        char c;

        for (int i = 0; i < s.length(); i++) {
            c = s.charAt(i);
            if (c == ' ')
                continue;

            if (Character.isDigit(c)) {
                int temp = 0;
                while (i < s.length() && Character.isDigit(s.charAt(i))) {
                    temp = temp * 10 + (s.charAt(i) - '0');
                    i++;
                }
                numStack.push(temp);
                i--;
            } else if (c == '+' || c == '-') {
                calculate(opStack, numStack);
                opStack.push(c);
            } else if (c == '*' || c == '/') {
                int numBefore = numStack.pop();
                i++;
                while (s.charAt(i) == ' ') {
                    i++;
                }
                int numLate = 0;
                while (i < s.length() && Character.isDigit(s.charAt(i))) {
                    numLate = numLate * 10 + (s.charAt(i) - '0');
                    i++;
                }
                i--;

                if (c == '*')
                    numStack.push(numBefore * numLate);
                else // c == '/'
                    numStack.push(numBefore / numLate);
            }
        }

        calculate(opStack, numStack);

        return numStack.pop();
    }

    private void calculate(Stack<Character> opStack, Stack<Integer> numStack) {
        while (!opStack.isEmpty()) {
            char operation = opStack.pop();
            int numLate = numStack.pop();
            int numBefore = numStack.pop();

            if (operation == '+')
                numStack.push(numLate + numBefore);
            else
                numStack.push(numBefore - numLate);
        }
    }

    @Test
    public void test227() {
        System.out.println(calculate("1*2-3/4+5*6-7*8+9/10"));
    }
}
