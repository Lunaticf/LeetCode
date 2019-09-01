package leetCode.stackAndQueue.minStack;

import java.util.Stack;

public class MinStack {
    private int min = Integer.MAX_VALUE;
    private Stack<Integer> stack = new Stack<>();

    /** initialize your data structure here. */
    public MinStack() {

    }

    // push的时候 要看是否是比min小
    public void push(int x) {
        // 如果x比min小，先push一个min保存相当于第二小的数
        if (x <= min) {
            stack.push(min);
            min = x;
        }
        stack.push(x);
    }

    public void pop() {
        if (stack.pop() == min) {
            min = stack.pop();
        }
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return min;
    }
}
