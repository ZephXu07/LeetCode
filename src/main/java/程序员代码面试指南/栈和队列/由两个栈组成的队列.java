package 程序员代码面试指南.栈和队列;

import java.util.Stack;

/**
 * Title: 由两个栈组成的队列
 * Description: TODO
 *
 * @author zephxu
 * @version V1.0
 * @date 2021-03-11
 */
public class 由两个栈组成的队列 {
    private Stack<Integer> left;
    private Stack<Integer> right;
    /** Initialize your data structure here. */
    public 由两个栈组成的队列() {
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
