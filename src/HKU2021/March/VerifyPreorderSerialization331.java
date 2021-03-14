package HKU2021.March;

import org.junit.Test;

import java.util.Stack;

public class VerifyPreorderSerialization331 {
    public boolean isValidSerialization(String preorder) {
        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        String[] orders = preorder.split(",");
        int temp;
        for (String order : orders) {
            if (stack.isEmpty()) {
                return false;
            }
            temp = stack.pop();
            if (temp > 1) {
                stack.push(temp - 1);
            }
            if (!order.equals("#")) {
                stack.push(2);
            }
        }
        return stack.isEmpty();
    }

    @Test
    public void test331() {
        System.out.println(isValidSerialization("9,#,#,1"));
    }

    public boolean isValidSerializationBetter(String preorder) {
        int slot = 1;
        String[] orders = preorder.split(",");
        for (String order : orders) {
            if (slot == 0) {
                return false;
            }
            slot--;

            if (!order.equals("#")) {
                slot += 2;
            }
        }
        return slot == 0;
    }
}
