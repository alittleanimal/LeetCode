package HKU2021.March;

import java.util.LinkedList;
import java.util.Queue;

public class ImplementStack225 {

    private Queue<Integer> firstQueue;
    private Queue<Integer> secondQueue;


    /**
     * Initialize your data structure here.
     */
    public ImplementStack225() {
        firstQueue = new LinkedList<>();
        secondQueue = new LinkedList<>();
    }

    /**
     * Push element x onto stack.
     */
    public void push(int x) {
        secondQueue.offer(x);
        while (!firstQueue.isEmpty()){
            secondQueue.offer(firstQueue.poll());
        }
        Queue<Integer> temp = firstQueue;
        firstQueue = secondQueue;
        secondQueue = temp;
    }

    /**
     * Removes the element on top of the stack and returns that element.
     */
    public int pop() {
        return firstQueue.poll();
    }

    /**
     * Get the top element.
     */
    public int top() {
        return firstQueue.peek();
    }

    /**
     * Returns whether the stack is empty.
     */
    public boolean empty() {
        return firstQueue.isEmpty() && secondQueue.isEmpty();
    }

    public static void main(String[] args) {
        ImplementStack225 stack = new ImplementStack225();
        stack.push(1);
        stack.push(2);
        System.out.println(stack.top());
        System.out.println(stack.pop());
        System.out.println(stack.empty());
    }
}
