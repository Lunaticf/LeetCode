package leetCode.stackAndQueue.implementStackUsingQueues;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @Author Lunaticf
 * @Date 2019/9/12
 */
public class ImplementStackUsingQueues {
}

class MyStack {
    private Queue<Integer> queue = new LinkedList<>();

    /** Initialize your data structure here. */
    public MyStack() {
    }

    /** Push element x onto stack. */
    public void push(int x) {
        queue.add(x);
        for (int i = 0; i < queue.size() - 1; i++) {
            int el = queue.poll();
            queue.add(el);
        }
    }

    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
        return queue.poll();
    }

    /** Get the top element. */
    public int top() {
        return queue.peek();
    }

    /** Returns whether the stack is empty. */
    public boolean empty() {
        return queue.isEmpty();
    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */
