package Preparation;

import java.util.ArrayList;
import java.util.List;

public class MinStack {

    private List<Integer> stackList;
    private List<Integer> minList;
    private int size;

    /**
     * initialize your data structure here.
     */
    public MinStack() {
        stackList = new ArrayList<>();
        minList = new ArrayList<>();
        size = 0;
    }

    public void push(int x) {
        stackList.add(x);
        if (size != 0 && minList.get(size - 1) <= x) {
            minList.add(minList.get(size - 1));
        } else {
            minList.add(x);
        }
        size++;
    }

    public void pop() {
        if (size > 0) {
            stackList.remove(size - 1);
            minList.remove(size - 1);
            size--;
        }
    }

    public int top() {
        if (size > 0) {
            return stackList.get(size - 1);
        }
        return -1;
    }

    public int getMin() {
        if (size > 0) {
            return minList.get(size - 1);
        }
        return -1;
    }

    public static void main(String[] args) {
        MinStack minStack = new MinStack();
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);
        System.out.println(minStack.getMin());
        minStack.pop();
        System.out.println(minStack.top());
        System.out.println(minStack.getMin());
    }
}
