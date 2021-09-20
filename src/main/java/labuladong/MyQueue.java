package labuladong;

import java.util.Stack;

/**
 * Title: labuladong.MyQueue
 * Description: TODO
 *
 * @author zephxu
 * @version V1.0
 * @date 2020-11-21
 */
class MyQueue {
    private Stack<Integer> left;
    private Stack<Integer> right;

    /** Initialize your data structure here. */
    public MyQueue() {
        left = new Stack<>();
        right = new Stack<>();
    }

    /** Push element x to the back of queue. */
    public void push(int x) {
        right.push(x);
    }

    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        peek();
        return left.pop();
    }

    /** Get the front element. */
    public int peek() {
        if (left.empty()) {
            while (!right.empty()) {
                left.push(right.pop());
            }
        }
        return left.peek();
    }

    /** Returns whether the queue is empty. */
    public boolean empty() {
        return left.empty() && right.empty();
    }
}
